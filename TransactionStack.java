import java.util.Stack;

public class TransactionStack {
    private Stack<String> history = new Stack<>();

    public void addTransaction(String transaction) {
        history.push(transaction);
        System.out.println("Transaction saved: " + transaction);
    }

    public void peekLast() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Last transaction: " + history.peek());
        }
    }

    public void undoLast() {
        if (history.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            String removed = history.pop();
            System.out.println("Undo → removed: " + removed);
        }
    }

    public void displayAll() {
        if (history.isEmpty()) {
            System.out.println("Transaction history is empty.");
            return;
        }
        System.out.println("--- Transaction History ---");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println("  " + history.get(i));
        }
    }
}
