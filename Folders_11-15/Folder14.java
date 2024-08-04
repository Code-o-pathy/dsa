import java.util.Deque;
import java.util.LinkedList;

class dequeue {
    int arr[];
    int front, sz, cap;

    dequeue(int x) {
        cap = x;
        arr = new int[cap];
        front = -1;
        sz = 0;
    }

    int size() {
        return sz;
    }

    boolean isEmpty() {
        return (sz == 0);
    }

    boolean isFull() {
        return (sz == cap);
    }

    int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return sz - 1;
    }

    void insertFront(int x) {
        if (isFull()) {
            return;
        }
        for (int i = sz - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];

        }
        arr[0] = x;
        sz++;

    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < sz - 1; i++) {
            arr[i] = arr[i + 1];
        }
        sz--;
    }

    void insertRear(int x) {
        if (isFull()) {
            return;
        }
        arr[sz] = x;
        sz++;
    }

    void deleteRear() {
        if (isEmpty()) {
            return;
        }
        sz--;
    }
}

class dequeueOptimized {
    int arr[];
    int front, sz, cap;

    dequeueOptimized(int x) {
        cap = x;
        arr = new int[cap];
        front = 0;
        sz = 0;
    }

    int size() {
        return sz;
    }

    boolean isEmpty() {
        return (sz == 0);
    }

    boolean isFull() {
        return (sz == cap);
    }

    int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front;
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return (front + sz - 1) % cap;
    }

    void insertFront(int x) {
        if (isFull()) {
            return;
        }
        front = (front - 1 + cap) % cap;
        arr[front] = x;
        sz++;

    }

    void deleteFront() {
        if (isEmpty()) {
            return;
        }
        front = (front + 1) % cap;
        sz--;
    }

    void insertRear(int x) {
        if (isFull()) {
            return;
        }
        int new_rear = (front + sz) % cap;
        arr[new_rear] = x;
        sz++;
    }

    void deleteRear() {
        if (isEmpty()) {
            return;
        }
        sz--;
    }
}

public class Folder14 {

    public static void printMax(int arr[],int k) {
        Deque<Integer> dq=new LinkedList<>();
        int n=arr.length;
        for(int i=0;i<k;i++){
            while (!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k;i<n;i++){
            System.out.println(" "+arr[dq.peek()]);
            while (!dq.isEmpty() && dq.peek()<=i-k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.println(" "+arr[dq.peek()]);
        
    }

    public static void main(String args[]) {
        // dequeue q = new dequeue(3);
        // System.out.println(q.isEmpty());
        // q.insertFront(10);
        // q.insertRear(10);
        // q.insertFront(10);
        // // System.out.println(q.getFront());
        // // System.out.println(q.getRear());
        // System.out.println(q.getFront());
        // System.out.println(q.getRear());

        // dequeueOptimized q = new dequeueOptimized(3);
        // System.out.println(q.isEmpty());
        // q.insertFront(10);
        // q.insertRear(10);
        // q.insertFront(10);
        // // System.out.println(q.getFront());
        // // System.out.println(q.getRear());
        // System.out.println(q.getFront());
        // System.out.println(q.isFull());
        // System.out.println(q.getRear());
        int arr[] = { 20, 10, 30, 10, 60 };
        int k=3;
        printMax(arr,k);

    }
}