import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final String BALANCE_COMMAND = "balance";
    private static final String WITHDRAW_COMMAND = "withdraw";
    private static final String DEPOSIT_COMMAND = "deposite";
    private static final String TRANSFER_COMMAND = "transfer";
    private static final String QUIT_COMMAND = "quit";

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            AccountService service = new FileAccountService("accounts.txt");
            printHelp();

            boolean quit = false;

            System.out.println("Введите команду");
            while (! quit) {
                System.out.print("> ");
                String command = in.next();
                int accountId;
                int amount;
                int accountIdTo;

                try {
                    switch (command.toLowerCase()) {
                        case BALANCE_COMMAND:
                            accountId = in.nextInt();
                            System.out.println(service.balance(accountId));
                            printOperationPerformed();
                            break;
                        case WITHDRAW_COMMAND:
                            accountId = in.nextInt();
                            amount = in.nextInt();
                            service.withdraw(accountId, amount);
                            printOperationPerformed();
                            break;
                        case DEPOSIT_COMMAND:
                            accountId = in.nextInt();
                            amount = in.nextInt();
                            service.deposit(accountId, amount);
                            printOperationPerformed();
                            break;
                        case TRANSFER_COMMAND:
                            accountId = in.nextInt();
                            accountIdTo = in.nextInt();
                            amount = in.nextInt();
                            service.transfer(accountId, accountIdTo, amount);
                            printOperationPerformed();
                            break;
                        case QUIT_COMMAND:
                            quit = true;
                            break;
                        default:
                            System.out.println("Неизвестная команда.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Неверный формат команды");
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }  catch (Exception e) {
            System.out.println("Критическая ошибка: " + e.getMessage());
        }
    }

    private static void printHelp() {
        StringBuffer helpText = new StringBuffer();
        helpText.append("\nbalance [id] - вывести информацию о счете");
        helpText.append("\nwithdraw [id] [amount] - снять указанную сумму");
        helpText.append("\ndeposite [id] [amount] – внести на счет указанную сумму");
        helpText.append("\ntransfer [from] [to] [amount] - перевести сумму с одного счета на другой");
        System.out.println(helpText.toString());
    }

    private static void printOperationPerformed() {
        System.out.println("Операция выполнена");
    }

}
