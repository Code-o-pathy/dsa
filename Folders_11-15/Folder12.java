import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

class twoStacks {
    int arr[];
    int cap, top1, top2;

    twoStacks(int n) {
        cap = n;
        top1 = -1;
        top2 = n;
        arr = new int[n];
    }

    void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        }
    }

    void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;

        } else {
            return Integer.MIN_VALUE;
        }
    }

    int pop2() {
        if (top2 < cap) {
            int x = arr[top2];
            top2++;
            return x;

        } else {
            return Integer.MIN_VALUE;
        }
    }

    int size1() {
        return top1 + 1;
    }

    int size2() {
        return cap - top2;
    }

    boolean isEmpty1() {
        return top1 < 0;
    }

    boolean isEmpty2() {
        return top2 == cap;
    }

    int peek1() {
        if (top1 >= 0) {

            return arr[top1];
        } else {
            return Integer.MIN_VALUE;
        }
    }

    int peek2() {
        if (top2 < cap) {

            return arr[top2];
        } else {
            return Integer.MIN_VALUE;
        }
    }
}

class MyStack {
    int arr[];
    int cap;
    int top;

    MyStack(int c) {
        cap = c;
        arr = new int[cap];
        top = -1;
    }

    void push(int x) {
        if (top == cap - 1) {
            System.out.println("overflow");
        } else {
            top++;
            arr[top] = x;
        }
    }

    int pop() {
        if (top == -1) {
            System.out.println("underflow");
            return -1;
        } else {

            int res = arr[top];
            top--;
            return res;
        }
    }

    int peek() {
        if (top == -1) {
            System.out.println("underflow");
            return -1;
        } else {
            return arr[top];
        }
    }

    int size() {
        return (top + 1);
    }

    boolean isEmpty() {
        return (top == -1);
    }
};

class stackArray {
    ArrayList<Integer> al = new ArrayList<>();

    void push(int x) {
        al.add(x);
    }

    int pop() {

        int res = al.get(al.size() - 1);
        al.remove(al.size() - 1);
        return res;
    }

    int peek() {

        return al.get(al.size() - 1);

    }

    int size() {
        return (al.size());
    }

    boolean isEmpty() {
        return (al.isEmpty());
    }
};

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class nodeStack {
    Node head;
    int sz;

    nodeStack() {
        head = null;
        sz = 0;
    }

    int size() {
        return sz;
    }

    boolean isEmpty() {
        return (sz == 0);
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        sz++;
    }

    int pop() {
        if (head == null) {
            return Integer.MAX_VALUE;

        }
        int res = head.data;
        head = head.next;
        return res;
    }

    int peek() {
        if (head == null) {
            return Integer.MAX_VALUE;

        }

        int res = head.data;
        return res;
    }
}

class KStack {
    int arr[]; // Array of size n to store actual content to be stored in stacks
    int top[]; // Array of size k to store indexes of top elements of stacks
    int next[]; // Array of size n to store next entry in all stacks
                // and free list
    int n, k;
    int free; // To store beginning index of free list

    // constructor to create k stacks in an array of size n
    KStack(int k1, int n1) {
        // Initialize n and k, and allocate memory for all arrays
        k = k1;
        n = n1;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        // Initialize all spaces as free
        free = 0;
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = -1; // -1 is used to indicate end of free list
    }

    // A utility function to check if there is space available
    boolean isFull() {
        return (free == -1);
    }

    // To push an item in stack number 'sn' where sn is from 0 to k-1
    void push(int item, int sn) {
        // Overflow check
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int i = free; // Store index of first free slot

        // Update index of free slot to index of next slot in free list
        free = next[i];

        // Update next of top and then top for stack number 'sn'
        next[i] = top[sn];
        top[sn] = i;

        // Put the item in array
        arr[i] = item;
    }

    // To pop an element from stack number 'sn' where sn is from 0 to k-1
    int pop(int sn) {
        // Underflow check
        if (isEmpty(sn)) {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }

        // Find index of top item in stack number 'sn'
        int i = top[sn];

        top[sn] = next[i]; // Change top to store next of previous top

        // Attach the previous top to the beginning of free list
        next[i] = free;
        free = i;

        // Return the previous top item
        return arr[i];
    }

    // To check whether stack number 'sn' is empty or not
    boolean isEmpty(int sn) {
        return (top[sn] == -1);
    }

}

public class Folder12 {

    public static void spanStack(int[] arr) {

        Stack<Integer> s = new Stack<>();
        s.push(0);
        System.out.println("Span of 1 is 1");

        for (int i = 1; i < arr.length; i++) {
            while (s.isEmpty() == false && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            int span = s.isEmpty() ? i + 1 : i - s.peek();
            System.out.println("Span of " + (i + 1) + " is " + span);
            s.push(i);

        }
    }

    public static void prevGreat(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        System.out.println((1) + "-> " + (-1));
        for (int i = 1; i < arr.length; i++) {
            while (s.empty() == false && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                System.out.println((i + 1) + "-> " + (-1));
                s.push(i);
            } else {
                System.out.println((i + 1) + "-> " + arr[s.peek()]);
            }
        }
    }

    public static void nextGreater(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr.length - 1);
        System.out.println(((arr.length - 1) + "->" + (-1)));
        for (int i = arr.length - 2; i >= 0; i--) {
            while (s.empty() == false && arr[s.peek()] < arr[i]) {
                s.pop();
            }

            System.out.println(i + "->" + arr[s.peek()]);
            s.push(i);

        }
    }

    public static int naiveLargestReactangularArea(int arr[]) {
        int ans = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    res = res + arr[i];
                } else {
                    break;
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k] >= arr[i]) {
                    res = res + arr[i];
                } else {
                    break;
                }
            }

            ans = Math.max(res, ans);
        }
        return ans;
    }

    public static int[] prevSmaller(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int res[] = new int[arr.length];
        s.push(0);
        res[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (s.empty() == false && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }

    public static int[] nextSmaller(int arr[]) {
        int res[] = new int[arr.length];
        res[arr.length - 1] = arr.length;
        Stack<Integer> s = new Stack<>();
        s.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (s.empty() == false && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                res[i] = arr.length;
            } else {
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }

    public static int betterRectangularArea(int arr[]) {
        int ps[] = prevSmaller(arr);
        int ns[] = nextSmaller(arr);
        int res = 0;
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr = arr[i];
            curr += (i - ps[i] - 1) * arr[i];
            curr += (ns[i] - i - 1) * arr[i];
            res = Math.max(curr, res);

        }
        return res;

    }

    public static void main(String[] args) {
        // MyStack s = new MyStack(2);
        // s.push(11);
        // s.push(12);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.peek());
        // System.out.println(s.size());
        // System.out.println(s.isEmpty());

        // output
        // 12
        // 11
        // underflow
        // -1
        // underflow
        // -1
        // 0
        // true

        // stackArray k = new stackArray();
        // k.push(12);
        // k.push(13);
        // k.push(14);
        // System.out.println(k.peek());

        // v6
        // application of stack
        // funciton calls executed in LIFO order using function call stack

        // checking for balance paranthesis
        // reversing items
        // infix to prefix/postfix
        // evaluation of prefix/postfix
        // stock span problem and its variations
        // undo/redo or forward/backward

        // nodeStack s = new nodeStack();

        // s.push(12);
        // System.out.println(s.size());

        // System.out.println( s.isEmpty());

        // In java stack can be implemented by 2 classes stack and ArrayDequeue
        // arraydequeue is good for single threaded and stack is thread safe but
        // increases overhead

        // Collections- list-vector-stack
        // Collections- queue-dequeue-ArrayDequeue

        // Stack<Integer> stack=new Stack<>();
        // ArrayDeque<Integer> stack= new ArrayDeque<>();
        // stack.push(23);
        // stack.push(24);
        // stack.push(25);
        // stack.pop();
        // System.out.println(stack.peek());

        // all operations have O(1), arraydeque and stack are both 'dynamic'size array
        // based implementations
        // so the push pop operations is amortized O(1),
        // it means some operations might be costly but average is O(1)

        // check for paranthesis

        // myWay
        // String s = "[{(())()[]{}}]";
        // int slength = s.length();
        // int i = 0;
        // Stack<Character> stack = new Stack<>();
        // while (i < slength) {
        // if (s.charAt(i) == ']') {
        // if (stack.isEmpty()) {
        // break;
        // }
        // if (stack.peek() == '[') {

        // stack.pop();
        // }
        // } else if (s.charAt(i) == '}') {
        // if (stack.isEmpty()) {
        // break;
        // }
        // if (stack.peek() == '{') {

        // stack.pop();
        // }
        // } else if (s.charAt(i) == ')') {
        // if (stack.isEmpty()) {
        // break;
        // }
        // if (stack.peek() == '(') {

        // stack.pop();
        // }
        // } else {
        // stack.push(s.charAt(i));
        // }
        // i++;
        // }
        // System.out.println(i);
        // System.out.println(s.length());
        // System.out.println(stack.size());

        // if (stack.isEmpty() && i == s.length()) {
        // System.out.println("good");
        // } else {

        // System.out.println("not good");
        // }

        // two stacks in an array
        // twoStacks s=new twoStacks(10);
        // s.push1(10);
        // s.push2(20);
        // System.out.println(s.peek1());
        // System.out.println(s.peek2());
        // System.out.println(s.size1());
        // System.out.println(s.size2());
        // System.out.println(s.pop1());
        // System.out.println(s.pop2());
        // System.out.println(s.isEmpty1());
        // System.out.println(s.isEmpty2());
        // System.out.println(s.size1());
        // System.out.println(s.size2());

        // implement k stacks in an array
        // int k = 3, n = 10;

        // KStack ks = new KStack(k, n);

        // ks.push(15, 2);
        // ks.push(45, 2);

        // // Let us put some items in stack number 1
        // ks.push(17, 1);
        // ks.push(49, 1);
        // ks.push(39, 1);

        // // Let us put some items in stack number 0
        // ks.push(11, 0);
        // ks.push(9, 0);
        // ks.push(7, 0);

        // System.out.println("Popped element from stack 2 is " + ks.pop(2));
        // System.out.println("Popped element from stack 1 is " + ks.pop(1));
        // System.out.println("Popped element from stack 0 is " + ks.pop(0));

        // span of stocks
        // int arr[]={60,10,20,15,35,50};
        // spanStack(arr);

        // prev Great
        // int arr[]={12,23,234,2313,344,3432,4223,2321};
        // prevGreat(arr);

        // next great
        // int arr[] = { 5, 15, 10, 8, 6, 12, 9, 18 };
        // nextGreater(arr);

        // largest rectangular area
        // int arr[] = { 2, 5, 1 };
        // int ans = naiveLargestReactangularArea(arr);
        // System.out.println(ans);

        // prevSmaller and next smaller
        // int arr[] = { 6, 2, 5, 4, 1, 5, 6 };
        // int ans = betterRectangularArea(arr);
        // System.out.println(ans);

        

    }

}