package assignment1;

// ========= السؤال 2 =========
import java.util.Random;
import java.util.Arrays;

class RemoveRandomElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Random rand = new Random();
        int indexToRemove = rand.nextInt(arr.length);
        System.out.println("Removing element at index: " + indexToRemove);
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != indexToRemove) newArr[j++] = arr[i];
        }
        System.out.println("Array after removal: " + Arrays.toString(newArr));
    }
}

// ========= السؤال 4 =========
class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}

// ========= السؤال 6 =========
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) { tail = tail.next; length++; }
        k = k % length;
        if (k == 0) return head;
        tail.next = head;
        for (int i = 0; i < length - k; i++) tail = tail.next;
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
    public static void printList(ListNode head) {
        while (head != null) { System.out.print(head.val + " "); head = head.next; }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original List:");
        printList(head);
        head = rotateRight(head, 2);
        System.out.println("Rotated List by 2:");
        printList(head);
    }
}

// ========= السؤال 8 =========
class Node8 {
    int data;
    Node8 next;
    Node8(int data) { this.data = data; }
}

class SearchLinkedList {
    public static int findIndex(Node8 head, int target) {
        int index = 0;
        while (head != null) { if (head.data == target) return index; head = head.next; index++; }
        return -1;
    }
    public static void main(String[] args) {
        Node8 head = new Node8(10);
        head.next = new Node8(20);
        head.next.next = new Node8(30);
        int target = 20;
        int index = findIndex(head, target);
        System.out.println("Index of " + target + ": " + index);
    }
}

// ========= السؤال 10 =========
class DNode {
    int data;
    DNode next, prev;
    DNode(int data) { this.data = data; }
}

class RemoveDuplicatesDoubly {
    public static DNode removeDuplicates(DNode head) {
        DNode current = head;
        while (current != null) {
            DNode runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                    DNode next = runner.next;
                    if (runner.prev != null) runner.prev.next = runner.next;
                    if (runner.next != null) runner.next.prev = runner.prev;
                    runner = next;
                } else runner = runner.next;
            }
            current = current.next;
        }
        return head;
    }
    public static void printList(DNode head) {
        while (head != null) { System.out.print(head.data + " "); head = head.next; }
        System.out.println();
    }
    public static void main(String[] args) {
        DNode head = new DNode(1);
        head.next = new DNode(2); head.next.prev = head;
        head.next.next = new DNode(2); head.next.next.prev = head.next;
        head.next.next.next = new DNode(3); head.next.next.next.prev = head.next.next;
        System.out.println("Original List:");
        printList(head);
        head = removeDuplicates(head);
        System.out.println("After removing duplicates:");
        printList(head);
    }
}

// ========= السؤال 12 =========
class SearchDoubly {
    public static int search(DNode head, int target) {
        int index = 0;
        while (head != null) { if (head.data == target) return index; head = head.next; index++; }
        return -1;
    }
    public static void main(String[] args) {
        DNode head = new DNode(5);
        head.next = new DNode(10); head.next.prev = head;
        head.next.next = new DNode(15); head.next.next.prev = head.next;
        int target = 10;
        int index = search(head, target);
        System.out.println("Index of " + target + ": " + index);
    }
}

// ========= السؤال 14 =========
class CNode {
    int data;
    CNode next;
    CNode(int data) { this.data = data; }
}

class DeleteCircular {
    public static CNode deleteAtPosition(CNode head, int pos) {
        if (head == null) return null;
        CNode curr = head;
        if (pos == 0) {
            if (head.next == head) return null;
            CNode tail = head;
            while (tail.next != head) tail = tail.next;
            tail.next = head.next;
            head = head.next;
            return head;
        }
        for (int i = 0; i < pos - 1; i++) curr = curr.next;
        curr.next = curr.next.next;
        return head;
    }
    public static void printList(CNode head) {
        if (head == null) return;
        CNode temp = head;
        do { System.out.print(temp.data + " "); temp = temp.next; } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        CNode head = new CNode(1);
        head.next = new CNode(2);
        head.next.next = new CNode(3);
        head.next.next.next = head;
        System.out.println("Original Circular List:");
        printList(head);
        head = deleteAtPosition(head, 1);
        System.out.println("After deleting position 1:");
        printList(head);
    }
}

// ========= السؤال 16 =========
class SplitCircular {
    public static void splitList(CNode head) {
        if (head == null || head.next == head) { System.out.println("List too small to split."); return; }
        CNode slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) { slow = slow.next; fast = fast.next.next; }
        CNode head1 = head;
        CNode head2 = slow.next;
        fast = fast.next == head ? fast : fast.next;
        fast.next = head2;
        slow.next = head1;
        System.out.print("First half: "); printCircular(head1);
        System.out.print("Second half: "); printCircular(head2);
    }
    public static void printCircular(CNode head) {
        if (head == null) return;
        CNode temp = head;
        do { System.out.print(temp.data + " "); temp = temp.next; } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        CNode head = new CNode(1);
        head.next = new CNode(2);
        head.next.next = new CNode(3);
        head.next.next.next = new CNode(4);
        head.next.next.next.next = head;
        splitList(head);
    }
}