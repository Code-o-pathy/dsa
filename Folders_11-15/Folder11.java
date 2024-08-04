class Node {
    // here Node and Next are not keywords but a variable; there will be no change
    // if the words are named differently
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class NodesBoolean {
    int data;
    NodesBoolean next;
    boolean value;

    NodesBoolean(int x) {
        data = x;
        next = null;
        value = false;

    }
}

class Nodes {
    int data;
    Nodes prev;
    Nodes next;

    Nodes(int x) {
        data = x;
        prev = null;
        next = null;
    }
}

public class Folder11 {
    public static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data + " " + curr.next);
            curr = curr.next;
        }
    }

    public static void printNode(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data + " ");
        printNode(head.next);
    }

    public static void printNode(Nodes head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data + " ");
        printNode(head.next);
    }

    public static Node insertBeg(Node head, int x) {

        Node temp = new Node(x);
        temp.next = head;
        // head = temp;
        // printlist(head);
        return temp;

    }

    public static Node insertEnd(Node head, int x) {
        Node curr = head;
        Node temp = new Node(x);
        if (head == null) {
            return temp;
        }

        while (curr.next != null) {
            // System.out.println(curr.data + " " + curr.next);
            curr = curr.next;
        }
        curr.next = temp;
        // printNode(head);
        return head;
    }

    public static Node delEnd(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static Node delBeg(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;

    }

    public static Node inserAtGivenPos(Node head, int targetPosi, int value) {
        Node temp = new Node(value);
        if (targetPosi == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for (int i = 1; i <= targetPosi - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static int searchLink(Node head, int key) {
        Node curr = head;
        int posi = 1;
        while (curr != null) {
            if (curr.data == key) {
                return posi;
            }

            posi++;

            curr = curr.next;
        }
        return -1;
    }

    public static int searchLinkRec(Node head, int key) {
        Node curr = head;
        if (curr == null) {
            return -1;
        }
        if (curr.data == key) {
            return 1;
        } else {
            int res = searchLink(head.next, key);
            if (res == -1) {
                return -1;

            } else {
                return (res + 1);
            }
        }
    }

    public static Nodes inserAtBeg(Nodes head, int x) {
        Nodes temp = new Nodes(x);
        temp.next = head;
        if (head != null) {
            head.prev = temp;
        }
        return temp;
    }

    public static Nodes inserAtEnd(Nodes head, int x) {
        Nodes temp = new Nodes(x);
        if (head == null) {
            return temp;
        }
        Nodes curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;

    }

    public static Nodes reverseList(Nodes head) {
        if (head == null || head.next == null) {
            return head;
        }
        Nodes curr = head;
        Nodes prev = null;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;

        }

        return prev.prev;
    }

    public static Nodes deleteHead(Nodes head) {
        if (head == null || head.next == null) {
            return null;
        }
        Nodes curr = head;
        head = head.next;
        head.prev = null;
        return head;

    }

    public static Nodes deleteTail(Nodes head) {
        if (head == null || head.next == null) {
            return null;
        }
        Nodes curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }

    public static Node printCircNode(Node head) {
        // what i came up with

        // if(head==null){
        // return null;
        // }
        // Node curr=head.next;
        // if(head.next==null){
        // return head;
        // }
        // System.out.println(head.data+" ");
        // while(curr!=head){
        // System.out.println(curr.data+" ");
        // curr=curr.next;
        // }
        // return head;

        // method one
        if (head == null) {
            return null;
        }
        System.out.println(head.data);
        for (Node curr = head.next; curr != head; curr = curr.next) {
            System.out.println(curr.data);
        }

        // method two
        // Node curr=head;
        // if(head==null){
        // return null;
        // }
        // do{
        // System.out.println(curr.data);
        // curr=curr.next;
        // }
        // while(curr!=head);
        return head;

    }

    public static void printNodeCirc(Nodes head) {

        if (head == null) {
            return;
        }
        System.out.println(head.data);
        for (Nodes curr = head.next; curr != head; curr = curr.next) {
            System.out.println(curr.data);
        }
    }

    public static Node inserAtBegCirc(Node head, int x) {

        // naive

        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
        }
        // else{
        // Node curr= head;
        // while(curr.next!=head){
        // curr=curr.next;
        // }
        // curr.next=temp;
        // temp.next=head;
        // }
        // return temp;

        // efficient
        else {
            temp.next = head.next;
            head.next = temp;
            int t = head.data;
            head.data = temp.data;
            temp.data = t;
        }

        return head;
    }

    public static Node insertAtEndCirc(Node head, int x) {
        head = inserAtBegCirc(head, x);
        return head.next;
    }

    public static Node deleteHeadCirc(Node head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    public static Node deleteKthNode(Node head, int k) {
        Node curr = head;
        if (head == null || head.next == head) {
            return null;
        }
        if (k == 1) {
            head = deleteHeadCirc(head);
            return head;
        }
        for (int i = 0; i < k - 2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
    }

    // public static void printNodeCirc(Nodes head) {

    // if (head == null) {
    // return;
    // }
    // System.out.println(head.data);
    // for (Nodes curr = head.next; curr != head; curr = curr.next) {
    // System.out.println(curr.data);
    // }
    // }
    public static Nodes insertDoublCirc(Nodes head, int x) {
        Nodes temp = new Nodes(x);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }
        temp.prev = head.prev;
        temp.next = head;
        head.prev.next = temp;
        head.prev = temp;
        return temp;

    }

    public static Nodes sortedInsert(Nodes head, int x) {
        Nodes temp = new Nodes(x);
        if (head == null) {

            return temp;
        }
        if (x < head.data) {
            temp.next = head;
            return temp;
        }
        Nodes curr = head;
        while (head.data <= x) {
            curr = curr.next;
        }

        return head;

    }

    public static int middleElem(Node head) {
        // efficient one
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast != null) {

            slow = slow.next;
            fast = fast.next.next;

        }
        return slow.data;
    }

    public static int middleElemNaive(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        Node curr2 = head;
        for (int i = 0; i < count / 2; i++) {
            curr2 = curr2.next;
        }
        return curr2.data;
    }

    public static void nthFromLast(Node head, int n) {
        if (head == null) {
            return;
        }
        Node forwarNode = head;
        Node res = head;
        for (int i = 0; i < n; i++) {
            if (forwarNode == null) {
                System.out.println("error - length limit reached");
                return;
            }
            forwarNode = forwarNode.next;

        }
        while (forwarNode != null) {
            forwarNode = forwarNode.next;
            res = res.next;

        }
        System.out.println(res.data);
    }

    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node recReverse(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node restHead = recReverse(head.next);
        Node restTail = head.next;
        head.next = null;
        restTail.next = head;
        return restHead;
    }

    public static Node recursivetype2(Node head, Node prev) {
        if (head == null) {

            return prev;
        }
        Node next = head.next;
        head.next = prev;

        return recursivetype2(next, head);
    }

    public static void deleteDuplicate(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    public static void booleancheckMethod1(NodesBoolean head) {
        NodesBoolean slow = head;
        NodesBoolean fast = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("loop detected");
                break;
            }
        }
        System.out.println("loop exhausted");

    }

    public static void booleancheckMethod3(NodesBoolean head) {

        NodesBoolean temp = new NodesBoolean(0);
        NodesBoolean curr = head;
        while (curr != null && curr.next != temp) {
            NodesBoolean temp2 = curr.next;

            curr.next = temp;
            curr = temp2;
        }
        if (curr != null) {
            System.out.println("loop detected");
        } else {
            System.out.println("link exhausted");
        }

    }

    public static void booleancheckMethod2(NodesBoolean head) {
        NodesBoolean curr = head;
        while (curr != null && curr.value == false) {
            System.out.println(curr.data);
            curr.value = true;
            curr = curr.next;
        }
        if (curr != null && curr.value == true) {

            System.out.println("Loop detected");

        } else {
            System.out.println("link exhausted");
        }

    }

    // loop removal algo
    public static void loopRemoval(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return;
        } else {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        printNode(head);

    }

    public static void deleteMidNode(Node point, Node head) {
        Node temp = point.next;
        point.data = temp.data;
        point.next = point.next.next;
        printlist(head);

    }

    public static Node evenOdd(Node head) {
        Node eS = null;
        Node eE = null;
        Node oS = null;
        Node oE = null;
        for (Node curr = head; curr != null; curr = curr.next) {
            int x = curr.data;
            if (x % 2 == 0) {
                if (eS == null) {
                    eS = curr;
                    eE = eS;

                } else {
                    eE.next = curr;
                    eE = eE.next;

                }
            } else {
                if (oS == null) {
                    oS = curr;
                    oE = oS;

                } else {
                    oE.next = curr;
                    oE = oE.next;
                }
            }
        }
        if (oS == null || eS == null) {
            return head;
        }
        eE.next = oS;
        oE.next = null;
        return eS;
    }

    public static void pairSwap(Node head){
        Node curr=head;
        while(curr!=null && curr.next!=null){
            int temp=curr.data;
            curr.data=curr.next.data;
            curr.next.data=temp;
            curr=curr.next.next;
        }
        printlist(head);

    }
    public static void pairSwap2(Node head){
        Node curr=head.next.next;
        Node prev=head;
        head=head.next;
        head.next=prev;
        
        while(curr!=null && curr.next!=null){
            prev.next=curr.next;
            prev=curr;
            Node next=curr.next.next;
            curr.next.next=curr;
            curr=next;

        }
        prev.next=curr;

        printlist(head);

    }

    public static void main(String args[]) {

        // singly linked list
        // Node head = new Node(50);
        // head.next = new Node(10);
        // head.next.next = new Node(30);
        // head.next.next.next = new Node(70);
        // head = insertBeg(head, 30);
        // insertEnd(head, 40);
        // printlist(head);

        // //deleting a node is easier in java cause we dont have to deallocate the
        // memory after deleting a node like we have to do in c++
        // head=delBeg(head);
        // printNode(head);
        // head=delEnd(head);
        // System.out.println("after del");
        // printNode(head);
        // int x = 4;
        // int y = 70;
        // head = inserAtGivenPos(head, x, y);
        // printNode(head);
        // int key = 0;
        // int ans = searchLink(head, key);
        // int ans = searchLinkRec(head, key);
        // System.out.println(ans);

        // Doubly linked list
        // Nodes head = new Nodes(12);
        // Nodes temp1 = new Nodes(13);
        // Nodes temp2 = new Nodes(14);
        // temp1.prev = head;
        // temp2.prev = temp1;
        // head.next = temp1;
        // temp1.next = temp2;
        // head = inserAtBeg(head, 11);
        // printNode(head);
        // head = inserAtEnd(head, 15);
        // printNode(head);
        // head= reverseList(head);
        // printNode(head);
        // head=deleteHead(head);
        // printNode(head);
        // head=deleteTail(head);
        // System.out.println("after deleting");
        // printNode(head);

        // circular linked list
        // Node head = new Node(10);
        // head.next = new Node(5);
        // head.next.next = new Node(20);
        // head.next.next.next = new Node(15);
        // head.next.next.next.next = head;
        // printCircNode(head);
        // System.out.println("h");
        // head=inserAtBegCirc(head, 6);
        // printCircNode(head);
        // head=insertAtEndCirc(head,7);
        // printCircNode(head);
        // head=deleteHeadCirc(head);
        // printCircNode(head);
        // int k=2;
        // deleteKthNode(head,k);

        // circular doubly linked list;
        // Nodes head = new Nodes(12);
        // Nodes temp1 = new Nodes(22);
        // Nodes temp2 = new Nodes(44);
        // head.prev = temp2;
        // temp1.prev = head;
        // temp2.prev = temp1;
        // head.next = temp1;
        // temp1.next = temp2;
        // temp2.next = head;
        // // printNodeCirc(head);
        // // head=insertDoublCirc(head, 10);
        // printNodeCirc(head);
        // int x = 23;
        // sortedInsert(head, x);

        // middle element

        // Node head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // head.next.next.next = new Node(40);
        // head.next.next.next.next = new Node(50);
        // head.next.next.next.next.next = new Node(60);
        // head.next.next.next.next.next.next = new Node(70);
        // System.out.println(middleElemNaive(head));

        // nth element from last nod
        // Node head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // head.next.next.next = new Node(40);
        // head.next.next.next.next = new Node(50);
        // head.next.next.next.next.next = new Node(60);
        // head.next.next.next.next.next.next = new Node(70);
        // nthFromLast(head, 9);

        // reverse a linked list

        // iterative
        // head1 = reverseLinkedList(head1);

        // recursive
        // head1 = recReverse(head1);
        // printlist(head1);

        // recursice type2
        // Node prev = null;
        // head1 = recursivetype2(head1, prev);
        // printlist(head1);

        // remove duplicates
        // deleteDuplicate(head1);
        // printlist(head1);

        // NodesBoolean head2 = new NodesBoolean(10);
        // head2.next = new NodesBoolean(20);
        // head2.next.next = new NodesBoolean(30);
        // head2.next.next.next = new NodesBoolean(40);
        // head2.next.next.next.next = head2.next;

        // booleancheckMethod2(head2);
        // booleancheckMethod1(head2);
        // booleancheckMethod3(head2);

        // loopRemoval(head1);
        // printNode(head1);

        // Node head1 = new Node(12);
        // head1.next = new Node(13);
        // head1.next.next = new Node(14);
        // head1.next.next.next = new Node(15);
        // deleteMidNode(head1.next,head1);

        Node head1 = new Node(12);
        head1.next = new Node(13);
        head1.next.next = new Node(14);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(16);

        //even first and then rest odd
        // Node head = evenOdd(head1);
        // printlist(head);

        //pair swapping
        // naive-swaps data not Node (On and O1)
        // pairSwap(head1);
        pairSwap2(head1);



    }
}