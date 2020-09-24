import java.io.*;
import java.util.*;

public class FileAccountService implements AccountService {

    private static final int DEFAULT_ACCOUNTS_NUMBER = 10;
    private static final String TEMP_FILE_POSTFIX = ".tmp";
    private static final int GENERATED_AMOUNT_MAX_BOUND = 100;
    private File storage;
    private File tmpStorage;
    private Map<Integer, Account> accounts;

    public FileAccountService(String filename) throws IOException, InvalidFileStructure {
        accounts = new HashMap<Integer, Account>();

        storage = new File(filename);
        tmpStorage = new File(filename + TEMP_FILE_POSTFIX);

        if (! storage.exists()) {
            generateAccounts(DEFAULT_ACCOUNTS_NUMBER);
            saveAccounts();
        } else {
            loadAccounts();
        }
    }

    private void generateAccounts(int numberOfAccounts) {
        Random random = new Random();
        for (int i = 0; i < numberOfAccounts; i++) {
            int accountId = i + 1;
            accounts.put(accountId, new Account(accountId, "Account holder " + accountId, random.nextInt(GENERATED_AMOUNT_MAX_BOUND)));
        }
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

        Account account = findAccountById(accountId);
        int originalAmount = account.getAmount();

        if (operation == Operation.CREDIT) {
            account.increaseAmount(amount);
        } else if (operation == Operation.DEBIT){
            checkBalance(account, amount);
            account.decreaseAmount(amount);
        }

        try {
            saveAccounts();
        } catch (Exception e) {
            account.setAmount(originalAmount);
            throw new UnknownAccountException("Возникла ошибка при выполнении операции");
        }
    }

    @Override
    public int balance(int accountId) throws UnknownAccountException {
        Account account = findAccountById(accountId);
        return account.getAmount();
    }

    @Override
    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException {
        checkAmount(amount);

        Account accountFrom = findAccountById(from);
        checkBalance(accountFrom, amount);

        Account accountTo = findAccountById(to);

        int originalAmountFrom = accountFrom.getAmount();
        int originalAmountTo = accountTo.getAmount();

        accountFrom.decreaseAmount(amount);
        accountTo.increaseAmount(amount);

        try {
            saveAccounts();
        } catch (Exception e) {
            accountFrom.setAmount(originalAmountFrom);
            accountTo.setAmount(originalAmountTo);
            throw new UnknownAccountException("Возникла ошибка при выполнении операции");
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

    private Account findAccountById(int accountId) throws UnknownAccountException {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new UnknownAccountException("Неизвестный идентификатор счета: " + String.valueOf(accountId));
        }
        return account;
    }

    private void saveAccounts() throws IOException {
        // сохраняем данные во временный файл
        try (PrintWriter writer = new PrintWriter(new FileWriter(tmpStorage))) {
            for (Account account : accounts.values()) {
                writer.println(serializeAccount(account));
            }
        }
        // переименовываем временный файл в постоянный
        if (storage.exists()) {
            if (!storage.delete()) {
                throw new IOException("Невозможно удалить файл " + storage.getName());
            }
        }
        if (!tmpStorage.renameTo(storage)) {
            throw new IOException("Невозможно переименовать файл " + storage.getName() + " в " + tmpStorage.getName());
        }
    }

    private void loadAccounts() throws IOException, InvalidFileStructure {
        try (BufferedReader reader = new BufferedReader(new FileReader(storage))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Account account = deserializeAccount(line);
                accounts.put(account.getId(), account);
            }
        }
    }

    private String serializeAccount(Account account) {
        return new StringBuilder().append(account.getId())
                .append(",").append(account.getAmount())
                .append(",").append(account.getHolder()).toString();
    }

    private Account deserializeAccount(String data) throws InvalidFileStructure {
        String[] elements = data.split(",", 3);
        if (elements.length != 3) {
            throw new InvalidFileStructure("Ожидаемое количество полей: 3, фактическое: " + elements.length);
        }
        Account account = new Account(Integer.valueOf(elements[0]),
                elements[2],
                Integer.valueOf(elements[1]));
        return account;
    }
}
