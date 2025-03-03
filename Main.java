class SinglyLinkedList {
    private Node head;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void remove(int value) {
        if (head == null) return;

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Integer findMiddle() {
        if (head == null) return null;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    public void reverse() {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next; // Store next node
            current.next = prev;      // Reverse the link
            prev = current;           // Move prev to current
            current = next;           // Move to next node
        }
        head = prev; // Update head to the new front
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        System.out.println("Original List:");
        list.display();

        list.remove(3);
        System.out.println("After Removing 3:");
        list.display();

        System.out.println("Middle Element: " + list.findMiddle());

        list.reverse();
        System.out.println("Reversed List:");
        list.display();
    }
}