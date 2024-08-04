import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class minHeap {
    int size;
    int cap;
    int arr[];

    minHeap(int c) {

        cap = c;
        size = 0;
        arr = new int[c];

    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int sz() {
        return size;
    }

    int[] prints() {
        return arr;
    }

    void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    int peek() {
        return arr[0];
    }

    void insert(int x) {
        if (size == cap) {
            return;
        }
        size++;
        arr[size - 1] = x;
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i];) {

            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }

    }

    void heapify(int i) {

        int lt = (2 * i) + 1;
        int rt = (2 * i) + 2;
        int smallest = i;
        if (lt < size && arr[lt] < arr[i]) {
            smallest = lt;
        }
        if (rt < size && arr[rt] < arr[smallest]) {
            smallest = rt;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(i = smallest);
        }

    }

    void changePeak(int i) {
        arr[0] = i;
    }

}

class Node {
    int key;
    Node left;
    Node right;

    Node(int d) {
        key = d;
        left = right = null;
    }
}

public class Folder17 {

    public static void heapify(int arr[], int size, int i) {
        int lt = (2 * i) + 1;
        int rt = (2 * i) + 2;
        int smallest = i;
        if (lt < size && arr[lt] < arr[i]) {
            smallest = lt;
        }
        if (rt < size && arr[rt] < arr[smallest]) {
            smallest = rt;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, size, smallest);
        }

    }

    public static void extractMin(int arr[]) {
        int i = 0;
        arr[0] = arr[arr.length - 1];
        // System.out.println(arr[0]);
        arr[arr.length - 1] = Integer.MAX_VALUE;
        heapify(arr, arr.length - 1, i);

    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static void decreaseKey(int arr[], int i, int x) {
        arr[i] = x;

        while (i != 0 && arr[i] < arr[parent(i)]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }

    }

    public static void deleteKey(int arr[], int i) {
        decreaseKey(arr, i, Integer.MIN_VALUE);
        extractMin(arr);
    }

    public static void buildify(int arr[]) {
        int size = arr.length;
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    public static void levelSabkeNikalengePart2(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();

                System.out.println(curr.key);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();

        }

    }

    public static void maxHeapify(int arr[], int size, int i) {
        int lt = (2 * i) + 1;
        int rt = (2 * i) + 2;
        int largest = i;
        if (lt < size && arr[lt] > arr[i]) {
            largest = lt;
        }
        if (rt < size && arr[rt] > arr[largest]) {
            largest = rt;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, size, largest);
        }

    }

    public static void kSortedArray(int arr[], int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            q.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = q.poll();
            q.add(arr[i]);
        }
        while (q.isEmpty() == false) {
            arr[index++] = q.poll();
        }
    }

    public static void buildMaxHeap(int arr[]) {
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }

    public static void heapsort(int arr[]) {
        buildMaxHeap(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println();
        for (int i = arr.length - 1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        // Node root = new Node(10);
        // root.left = new Node(20);
        // root.right = new Node(15);
        // root.left.left = new Node(40);
        // root.left.left.left = new Node(45);
        // root.left.right = new Node(50);
        // root.right.left = new Node(100);
        // root.right.right = new Node(25);

        // levelSabkeNikalengePart2(root);

        // minHeap s = new minHeap(10);
        // s.insert(10);
        // s.insert(20);
        // s.insert(30);
        // s.insert(40);
        // s.insert(4);
        // System.out.println(s.sz());

        // heapify
        // int arr[] = { 40, 20, 30, 45, 50, 60, 70 };
        // int size = 7;
        // heapify(arr, size, 0);

        // int arr[] = { 20, 25,30, 35, 40, 80, 32, 100,70,60 };
        // extractMin(arr);

        // int arr[]={25,35,30,60,40,80,32};
        // int i=2;
        // int x=5;
        // decreaseKey(arr, i, x);

        // int arr[] = { 25, 35, 30, 60, 40, 80, 32 };
        // int i = 4;
        // deleteKey(arr,i);

        // build heap
        // int arr[] = { 1, 10, 30, 60, 5, 80, 2 };
        // buildify(arr);
        // for (int k : arr) {
        // System.out.println(k);
        // }
        // int arr[] = { 1, 10, 30, 60, 5, 80, 2 };
        // heapsort(arr);
        // for (int k : arr) {
        // System.out.println(k);
        // }

        // PriorityQueue<Integer> q=new PriorityQueue<Integer>(); //min heap
        // PriorityQueue<Integer> q=new
        // PriorityQueue<Integer>(Collections.reverseOrder()); //max heap
        // q.add(10);
        // q.add(15);
        // q.add(20);
        // System.out.println(q.peek());
        // System.out.println(q.poll());
        // System.out.println(q.peek());

        // int arr[]={9,8,7,19,18};
        // int k=2;
        // kSortedArray(arr, k);
        // for(int i:arr){
        // System.out.println(i);
        // }

        // purchasing maximum items
        // can be done by using heap;
        // first build heap and then remove every top node and then heapify your tree.
        // subtract the value of removed node from the sum given and increase result, do
        // this till sum is either 0 or too small to remove any next node, return result

        // k largest element
        // int k = 3;
        // int arr[] = { 59, 15, 10, 20, 8, 25, 18 };
        // minHeap s = new minHeap(k);
        // for (int i = 0; i < k; i++) {
        // s.insert(arr[i]);
        // }
        // for (int i = k; i < arr.length; i++) {
        // if (s.peek() < arr[i]) {
        // s.changePeak(arr[i]);
        // s.heapify(0);

        // }
        // }
        // s.print();

        // k closest element
        int arr[] = { 10, 30, 5, 40, 38, 80, 70 };
        int x = 20;
        minHeap s = new minHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            s.insert((x - arr[i]));
        }   
        s.print();
        System.out.println();
        int ans[] = s.prints();
        for (int i : ans) {
            System.out.println(i+x);
        }

        //the above solution can be improved if u use a class and in  it use priority queue and index;
        //now when u insert diff insert with index so that when u pop it out u will have the index of the element;

    }

}
