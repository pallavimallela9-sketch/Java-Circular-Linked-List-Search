import java.util.Scanner;

public class CircularLinkedListSearch {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node insertAtEnd(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        return head;
    }

    static void search(Node head, int key) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        int position = 1;

        do {
            if (temp.data == key) {
                System.out.println("Element found at position " + position);
                return;
            }

            temp = temp.next;
            position++;

        } while (temp != head);

        System.out.println("Element not found.");
    }

    static void display(Node head) {

        if (head == null) {
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter data: ");
            int data = sc.nextInt();

            head = insertAtEnd(head, data);
        }

        System.out.println("Circular Linked List:");
        display(head);

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        search(head, key);

        sc.close();
    }
}
