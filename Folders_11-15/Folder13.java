import java.util.*;

class queueArray {
    int arr[];
    int cap;
    int front, rear, sz;

    queueArray(int x) {
        cap = x;
        front = 0;
        rear = 0;
        sz = 0;
        arr = new int[cap];

    }

    void enqueue(int x) {
        if (isFull()) {
            return;
        }
        arr[sz] = x;
        sz++;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int ans = arr[front];
        for (int i = 0; i < sz - 1; i++) {
            arr[i] = arr[i + 1];
        }

        sz--;
        return ans;
    }

    int size() {
        return sz;
    }

    int getFront() {
        return isEmpty() ? -1 : 0;
    }

    int getRear() {
        return isEmpty() ? -1 : sz - 1;
    }

    boolean isFull() {
        return (sz == cap);
    }

    boolean isEmpty() {
        return sz == 0;
    }

}

class queueArrayUtilised {
    int arr[];
    int cap;
    int front, sz;

    queueArrayUtilised(int x) {
        cap = x;
        front = 0;
        sz = 0;
        arr = new int[cap];

    }

    void enqueue(int x) {
        if (isFull()) {
            return;
        }
        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = x;
        sz++;
    }

    void dequeue() {
        if (isEmpty()) {
            return;
        }
        front = (front + 1) % cap;
        sz--;

    }

    int size() {
        return sz;
    }

    int getFront() {
        return isEmpty() ? -1 : front;
    }

    int getRear() {
        return isEmpty() ? -1 : (front + sz - 1) % cap;
    }

    boolean isFull() {
        return (sz == cap);
    }

    boolean isEmpty() {
        return sz == 0;
    }

}

class Node {

    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class queueLinked {
    Node front;
    Node rear;
    int sz;

    queueLinked() {
        front = rear = null;
        sz = 0;

    }

    int getSize() {
        return sz;
    }

    void enqueue(int x) {
        Node temp = new Node(x);
        sz++;
        if (front == null) {
            front = rear = temp;

        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    void dequeue() {
        if (front == null) {
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

}

class stackUsingQueue {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    int sz;

    stackUsingQueue() {
        sz = 0;
    }

    void push(int x) {
        while (q1.isEmpty() == false) {
            q2.offer(q1.peek());
            q1.poll();
        }
        q1.offer(x);
        sz++;
        while (q2.isEmpty() == false) {
            q1.offer(q2.peek());
            q2.poll();
        }
    }

    int pop() {
        sz--;
        return q1.peek();
    }

    int size() {
        return sz;
    }

}

public class Folder13 {

    public static void reverseIterative(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (q.isEmpty() == false) {
            int ans = q.peek();
            s.push(ans);
            q.poll();
        }
        while (s.isEmpty() == false) {
            int ans = s.peek();
            q.offer(ans);
            s.pop();
        }
        while (q.isEmpty() == false) {

            System.out.println(q.poll());
        }
    }

    public static void reverseRecursive(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int ans = q.poll();
        reverseRecursive(q);
        q.offer(ans);
    }

    public static void callerFunction(Queue<Integer> q) {
        reverseRecursive(q);
        while (q.isEmpty() == false) {
            int ans = q.poll();
            System.out.println(ans);

        }

    }

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();

        // q.add(12);// add an element at the end, if queue is full throws exception
        // q.offer(13);// add an element at the end, if queue is full returns false

        // System.out.println(q.element()); // throws exception if queue is empty
        // System.out.println(q.peek()); // returns null if queue is empty

        // // q.remove() removes and returns element at front of the queue, if queue is
        // // empty throws an exception
        // // q.poll() removes and returns element at front of the queue, if queue is
        // empty
        // // returns null

        // // add element and remove -excetion
        // // offer(false),poll peek-null

        // q.add(22);
        // q.add(32);
        // System.out.println(q.poll()); // poll is like pop, it returns the element at
        // // beginning and pops it out of the queue
        // System.out.println(q.size());
        // q.clear();
        // System.out.println(q.contains(12));

        // queue using array

        // System.out.println();

        // queueArray q = new queueArray(3);
        // q.enqueue(12);
        // q.enqueue(13);
        // q.enqueue(14);
        // System.out.println(q.size());
        // System.out.println(q.dequeue());
        // q.enqueue(14);
        // System.out.println(q.size());
        // System.out.println(q.isEmpty());
        // System.out.println(q.isFull());
        // System.out.println();

        // queue using array (Utilised method)
        // queueArrayUtilised q = new queueArrayUtilised(3);
        // q.enqueue(12);
        // q.enqueue(13);
        // q.enqueue(14);
        // System.out.println(q.size());
        // q.dequeue();
        // q.enqueue(14);
        // System.out.println(q.size());
        // System.out.println(q.isEmpty());
        // System.out.println(q.isFull());

        // (queue using linked list)
        // queueLinked q=new queueLinked();
        // q.enqueue(10);
        // q.enqueue(12);
        // System.out.println(q.getSize());
        // stackUsingQueue a=new stackUsingQueue();
        // a.push(12);
        // a.push(13);
        // a.push(14);
        // a.pop();
        // System.out.println(a.size());

        // Queue<Integer> q = new ArrayDeque<>();
        // q.offer(12);
        // q.offer(13);
        // q.offer(14);
        // q.offer(15);

        // reverseIterative(q);
        // System.out.println("Hello");
        // callerFunction(q);

    }
}
