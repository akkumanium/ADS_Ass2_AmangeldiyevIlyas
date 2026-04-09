import java.util.LinkedList;
import java.util.Queue;

public class AccountQueue {

    private Queue<BankAccount> requests = new LinkedList<>();
    private int nextAccountNumber = 1001; 

    public void submitRequest(String username, double initialBalance) {
        String accNum = "ACC" + nextAccountNumber++;
        BankAccount newAccount = new BankAccount(accNum, username, initialBalance);
        requests.add(newAccount);
        System.out.println("Request submitted for: " + username + " (pending approval)");
    }

    public BankAccount processNext(MyLinkedList accounts) {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return null;
        }
        BankAccount approved = requests.poll();
        accounts.add(approved);
        System.out.println("Approved and added: " + approved);
        return approved;
    }

    public void displayPending() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            System.out.println("--- Pending Account Requests ---");
            for (BankAccount acc : requests) {
                System.out.println("  " + acc.username);
            }
        }
    }

    public boolean isEmpty() {
        return requests.isEmpty();
    }
}
