


public class Q7RotateList {

    public static ListNode rotateNext(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) return head;

        // Step 1: Get the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Make it a circular list
        current.next = head;

        // Step 3: Find the new tail (length - n % length - 1) and new head
        n = n % length;
        int stepsToNewHead = length - n;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : " -> null"));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode("ID_A01");
        head.next = new ListNode("ID_A02");
        head.next.next = new ListNode("ID_A03");
        head.next.next.next = new ListNode("ID_A04");
        head.next.next.next.next = new ListNode("ID_A05");
        head.next.next.next.next.next = new ListNode("ID_A06");

        int n = 2;
        System.out.print("Original List: ");
        printList(head);

        ListNode rotated = rotateNext(head, n);
        System.out.print("Rotated List:  ");
        printList(rotated);
    }
}
class ListNode {
    String val;
    ListNode next;

    ListNode(String val) {
        this.val = val;
    }
}