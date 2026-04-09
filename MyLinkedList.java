public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        BankAccount data;
        Node next;

        Node(BankAccount data) {
            this.data = data;
        }
    }

    public void add(BankAccount account) {
        Node newNode = new Node(account);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No accounts found.");
            return;
        }
        Node current = head;
        int i = 1;
        while (current != null) {
            System.out.println(i + ". " + current.data.username
                    + " – Balance: " + current.data.balance);
            current = current.next;
            i++;
        }
    }

    public BankAccount findByUsername(String username) {
        Node current = head;
        while (current != null) {
            if (current.data.username.equalsIgnoreCase(username)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deposit(String username, double amount) {
        BankAccount acc = findByUsername(username);
        if (acc == null) return false;
        acc.balance += amount;
        return true;
    }

    public boolean withdraw(String username, double amount) {
        BankAccount acc = findByUsername(username);
        if (acc == null) return false;
        if (acc.balance < amount) return false;
        acc.balance -= amount;
        return true;
    }

    public int size() {
        return size;
    }
}
