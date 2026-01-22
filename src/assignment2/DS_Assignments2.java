package assignment2;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
// ========= السؤال 1: Reverse String using Stack =========
class ReverseStringStack {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return reversed.toString();
    }
    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reverseString(str));
    }
}

// ========= السؤال 2: Sort a Stack using only another Stack =========
class SortStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> temp = new Stack<>();
        while (!input.isEmpty()) {
            int curr = input.pop();
            while (!temp.isEmpty() && temp.peek() > curr) input.push(temp.pop());
            temp.push(curr);
        }
        return temp;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println("Original stack: " + stack);
        stack = sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }
}

// ========= السؤال 3: Reverse Queue =========

class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) stack.push(queue.poll());
        while (!stack.isEmpty()) queue.offer(stack.pop());
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}

// ========= السؤال 4: Priority Queue (smallest element dequeued first) =========

class MinPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap by default
        pq.offer(5);
        pq.offer(1);
        pq.offer(3);
        pq.offer(2);
        System.out.println("Priority Queue elements dequeued in order:");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
    }
}

// ========= السؤال 5: Merge two sorted queues =========
class MergeSortedQueues {
    public static Queue<Integer> mergeQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> merged = new LinkedList<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) merged.offer(q1.poll());
            else merged.offer(q2.poll());
        }
        while (!q1.isEmpty()) merged.offer(q1.poll());
        while (!q2.isEmpty()) merged.offer(q2.poll());
        return merged;
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.offer(1); q1.offer(3); q1.offer(5);
        Queue<Integer> q2 = new LinkedList<>();
        q2.offer(2); q2.offer(4); q2.offer(6);
        System.out.println("Queue 1: " + q1);
        System.out.println("Queue 2: " + q2);
        Queue<Integer> merged = mergeQueues(q1, q2);
        System.out.println("Merged Queue: " + merged);
    }
}