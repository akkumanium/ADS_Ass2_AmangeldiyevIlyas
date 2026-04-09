import java.util.Scanner;

public class BankingApp {

    static MyLinkedList accounts       = new MyLinkedList();
    static TransactionStack history    = new TransactionStack();
    static BillQueue billQueue         = new BillQueue();
    static AccountQueue accountQueue   = new AccountQueue();
    static Scanner sc                  = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount[] predefined = {
            new BankAccount("ACC001", "Ali",  150000),
            new BankAccount("ACC002", "Sara", 220000),
            new BankAccount("ACC003", "Dana", 98000)
        };
        for (BankAccount acc : predefined) {
            accounts.add(acc);
        }
        System.out.println("3 accounts preloaded.\n");

        boolean running = true;
        while (running) {
            System.out.println("   WELCOME TO BANK   ");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> { System.out.println("Goodbye!"); running = false; }
                default -> System.out.println("Invalid option.\n");
            }
        }
    }

    static void bankMenu() {
        System.out.println("\n--- BANK MENU ---");
        System.out.println("1 – Submit account opening request");
        System.out.println("2 – Deposit money");
        System.out.println("3 – Withdraw money");
        System.out.println("4 – View all accounts");
        System.out.println("5 – Pay a bill");
        System.out.println("6 – Back");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                System.out.print("Initial deposit: ");
                double bal = sc.nextDouble();
                sc.nextLine();
                accountQueue.submitRequest(name, bal);
            }
            case 2 -> {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Deposit amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                if (accounts.deposit(user, amount)) {
                    BankAccount acc = accounts.findByUsername(user);
                    System.out.println("New balance: " + acc.balance);
                    history.addTransaction("Deposit " + amount + " to " + user);
                } else {
                    System.out.println("User not found.");
                }
            }
            case 3 -> {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Withdraw amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                if (accounts.withdraw(user, amount)) {
                    BankAccount acc = accounts.findByUsername(user);
                    System.out.println("New balance: " + acc.balance);
                    history.addTransaction("Withdraw " + amount + " from " + user);
                } else {
                    System.out.println("User not found or insufficient balance.");
                }
            }
            case 4 -> {
                System.out.println("\nAccounts List:");
                accounts.displayAll();
            }
            case 5 -> {
                System.out.print("Enter bill name (e.g. Electricity Bill): ");
                String bill = sc.nextLine();
                billQueue.addBill(bill);
                history.addTransaction("Bill payment queued: " + bill);
            }
            case 6 -> {}
            default -> System.out.println("Invalid option.");
        }
        System.out.println();
    }

    // ── ATM MENU ───────────────────────────────────────────────────
    static void atmMenu() {
        System.out.println("\n--- ATM MENU ---");
        System.out.println("1 – Balance enquiry");
        System.out.println("2 – Withdraw");
        System.out.println("3 – Back");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                BankAccount acc = accounts.findByUsername(user);
                if (acc != null) {
                    System.out.println("Balance for " + user + ": " + acc.balance);
                } else {
                    System.out.println("Account not found.");
                }
            }
            case 2 -> {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Withdraw amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                if (accounts.withdraw(user, amount)) {
                    BankAccount acc = accounts.findByUsername(user);
                    System.out.println("Dispensing " + amount + ". New balance: " + acc.balance);
                    history.addTransaction("ATM Withdraw " + amount + " from " + user);
                } else {
                    System.out.println("Failed: user not found or insufficient funds.");
                }
            }
            case 3 -> {}
            default -> System.out.println("Invalid option.");
        }
        System.out.println();
    }

    static void adminMenu() {
        System.out.println("\n--- ADMIN MENU ---");
        System.out.println("1 – View pending account requests");
        System.out.println("2 – Process next account request");
        System.out.println("3 – View bill payment queue");
        System.out.println("4 – Process next bill payment");
        System.out.println("5 – View transaction history");
        System.out.println("6 – Undo last transaction");
        System.out.println("7 – Back");
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> accountQueue.displayPending();
            case 2 -> accountQueue.processNext(accounts);
            case 3 -> billQueue.displayQueue();
            case 4 -> billQueue.processNext();
            case 5 -> history.displayAll();
            case 6 -> history.undoLast();
            case 7 -> {}
            default -> System.out.println("Invalid option.");
        }
        System.out.println();
    }
}
