import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DBAccountService implements AccountService {

    private static String ACCOUNT_BALANCE_UPDATE_SQL = "UPDATE accounts SET amount = ? WHERE id = ?";
    private static String SELECT_ACCOUNT_LOCKED_SQL = "SELECT id, holder, amount FROM accounts WHERE id = ? FOR UPDATE";
    private static String SELECT_ACCOUNT_SQL = "SELECT id, holder, amount FROM accounts WHERE id = ?";

    private Connection connection;

    public DBAccountService(Connection connection) throws IOException, InvalidFileStructure {
        this.connection = connection;
    }

    @Override
    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException {
        changeBalance(accountId, amount, Operation.DEBIT);
    }

    @Override
    public void deposit(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException {
        changeBalance(accountId, amount, Operation.CREDIT);
    }

    private void changeBalance(int accountId, int amount, Operation operation)
            throws NotEnoughMoneyException, UnknownAccountException{

        checkAmount(amount);

        try {
            changeBalanceTransaction(accountId, amount, operation);
        } catch (SQLException e) {
            throw new NotEnoughMoneyException(e.getMessage());
        }
    }

    private void changeBalanceTransaction(int accountId, int amount, Operation operation)
            throws NotEnoughMoneyException, UnknownAccountException, SQLException {

        try {
            Account account = findAndLockAccountById(accountId);

            if (operation == Operation.CREDIT) {
                account.increaseAmount(amount);
            } else if (operation == Operation.DEBIT) {
                checkBalance(account, amount);
                account.decreaseAmount(amount);
            }

            updateAccountBalance(account);
            connection.commit();

        } catch (Exception e) {
            connection.rollback();
            throw e;
        }
    }

    @Override
    public int balance(int accountId) throws UnknownAccountException {
        try {
            Account account = findAccountById(accountId);
            return account.getAmount();
        } catch (SQLException e) {
            throw new UnknownAccountException(e.getMessage());
        }
    }

    @Override
    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException {

        checkAmount(amount);

        try {
            transferTransaction(from, to, amount);
        } catch (SQLException e) {
            throw new NotEnoughMoneyException(e.getMessage());
        }
    }

    public void transferTransaction(int from, int to, int amount)
            throws NotEnoughMoneyException, UnknownAccountException, SQLException {

        try {

            Account accountFrom = findAndLockAccountById(from);
            checkBalance(accountFrom, amount);
            Account accountTo = findAndLockAccountById(to);

            accountFrom.decreaseAmount(amount);
            accountTo.increaseAmount(amount);

            List<Account> accounts = new ArrayList<>(2);
            accounts.add(accountFrom);
            accounts.add(accountTo);

            updateAccountBalances(accounts);
            connection.commit();

        } catch (Exception e) {
            connection.rollback();
            throw e;
        }
    }

    private void checkBalance(Account account, int amount) throws NotEnoughMoneyException {
        if (account.getAmount() < amount) {
            throw new NotEnoughMoneyException("Недостаточно средств для выполнения операции");
        }
    }

    private void checkAmount(int amount) throws NotEnoughMoneyException {
        if (amount <= 0) {
            throw new NotEnoughMoneyException("Неверная сумма операции");
        }
    }

    private Account findAccountById(int accountId) throws UnknownAccountException, SQLException {
        return selectAccount(accountId, SELECT_ACCOUNT_SQL);
    }

    private Account findAndLockAccountById(int accountId) throws UnknownAccountException, SQLException {
        return selectAccount(accountId, SELECT_ACCOUNT_LOCKED_SQL);
    }

    private Account selectAccount(int accountId, String sql) throws UnknownAccountException, SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, accountId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Account account = new Account(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3)
                    );
                    return account;
                } else {
                    throw new UnknownAccountException("Неизвестный идентификатор счета: " + String.valueOf(accountId));
                }
            }
        }
    }

    private void updateAccountBalance(Account account) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(ACCOUNT_BALANCE_UPDATE_SQL)) {
            statement.setInt(1, account.getAmount());
            statement.setInt(2, account.getId());
            statement.execute();
        }
    }

    private void updateAccountBalances(List<Account> accounts) throws SQLException {
        if (accounts.size() > 0) {
            try (PreparedStatement statement = connection.prepareStatement(ACCOUNT_BALANCE_UPDATE_SQL)) {
                for (Account account: accounts) {
                    statement.setInt(1, account.getAmount());
                    statement.setInt(2, account.getId());
                    statement.addBatch();
                }
                statement.executeBatch();
            }
        }
    }
}

