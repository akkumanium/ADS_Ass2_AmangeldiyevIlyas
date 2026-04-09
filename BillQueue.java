import java.util.LinkedList;
import java.util.Queue;

public class BillQueue {

    private Queue<String> billQueue = new LinkedList<>();

    public void addBill(String bill) {
        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    public void processNext() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills to process.");
        } else {
            String processed = billQueue.poll();
            System.out.println("Processing: " + processed);
        }
    }
    public void displayQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
        } else {
            System.out.println("Pending bills: " + billQueue);
        }
    }

    public boolean isEmpty() {
        return billQueue.isEmpty();
    }
}
