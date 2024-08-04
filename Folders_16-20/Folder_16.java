import java.util.*;

class Node {
    int key;
    Node left;
    Node right;

    Node(int d) {
        key = d;
        left = right = null;
    }
}

class ABNode {
    // augmented binary node
    int key;
    Node left;
    Node right;
    int lcount;

    ABNode(int d) {
        key = d;
        left = right = null;
    }
}

public class Folder_16 {

    static int count = 0;

    public static void printkth(Node root, int k) {
        if (root == null) {
            return;
        }
        printkth(root.left, k);
        count++;
        if (count == k) {
            System.out.println(root.key);

        } else {
            printkth(root.right, k);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);

            System.out.println(root.key);
            inorder(root.right);
        }
    }

    public static boolean search(Node root, int ans) {
        if (root == null)
            return false;
        if (root.key == ans)
            return true;
        if (ans > root.key)
            return search(root.right, ans);
        else
            return search(root.left, ans);

    }

    public static Node insert(Node root, int x) {
        if (root == null) {
            return new Node(x);
        } else if (root.key < x) {
            root.right = insert(root.right, x);
        } else if (root.key > x) {
            root.left = insert(root.left, x);
        }
        return root;
    }

    public static Node insertIterative(Node root, int x) {
        Node temp = new Node(x);
        Node curr = root;
        Node parent = null;
        while (curr != null) {
            parent = curr;
            if (x > curr.key) {
                curr = curr.right;
            } else if (curr.key > x) {
                curr = curr.left;
            } else {
                return root;
            }
        }
        if (parent == null) {
            return temp;
        }
        if (parent.key > x) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }
        return root;
    }

    public static Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    public static Node delete(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (root.key > x) {
            root.left = delete(root.left, x);
        } else if (root.key < x) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                Node temp = root.right;
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                return temp;

            } else {
                Node temp = getSuccessor(root);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
        return root;
    }

    public static Node floor(Node root, int res) {
        Node ans = null;
        while (root != null) {
            if (root.key == res) {
                return root;
            } else if (root.key > res) {
                root = root.left;
            } else {
                ans = root;
                root = root.right;
            }
        }
        return ans;

    }

    public static Node ceil(Node root, int res) {
        Node ans = null;
        while (root != null) {
            if (root.key == res) {
                return root;
            } else if (root.key > res) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;

    }

    static Node prev = null;
    static Node first = null;
    static Node last = null;

    public static void swappNodes(Node root) {

        if (root == null) {
            return;
        }
        swappNodes(root.left);
        if (prev != null && root.key < prev.key) {
            if (first == null) {
                first = prev;
            }
            last = root;

        }
        prev = root;
        swappNodes(root.right);

    }

    public static boolean givenSum(Node root, int sum, HashSet<Integer> s) {
        if (root == null) {
            return false;
        }
        if (givenSum(root.left, sum, s) == true) {
            return true;
        }
        if (s.contains(sum - root.key)) {
            return true;
        } else {
            s.add(root.key);
        }
        return givenSum(root.right, sum, s);

    }

    public static void vSumR(Node root, int hd, TreeMap<Integer, Integer> mp) {
        if (root == null)
            return;
        vSumR(root.left, hd - 1, mp);
        int psum = (mp.get(hd) == null) ? 0 : mp.get(hd);
        mp.put(hd, psum + root.key);
        vSumR(root.right, hd + 1, mp);

    }

    public static void vSum(Node root) {
        TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        vSumR(root, 0, mp);
        for (Map.Entry sum : mp.entrySet()) {
            System.out.println(sum.getValue() + " ");
        }
    }

    public static void getVerticalOrder(Node root, int hd,
            TreeMap<Integer, Vector<Integer>> m) {
        if (root == null)
            return;

        Vector<Integer> get = m.get(hd);

        // if (get == null) {
        //     get = new Vector<>();
        //     get.add(root.key);
        // } else {

        //     get.add(root.key); // dont use this line i u want top view of the binary tree

        // }
        
        //for bottom view
        if (get == null) {
            get = new Vector<>();
            get.clear();
            get.add(root.key);
        } else {
            get.clear();
            get.add(root.key);
        }
        

        m.put(hd, get);

        getVerticalOrder(root.left, hd - 1, m);

        getVerticalOrder(root.right, hd + 1, m);
    }

    public static void printVerticalOrder(Node root) {
        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, m);

        for (Map.Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String args[]) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(10);
        root.left.right = new Node(40);
        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        // Node head = delete(root, 50);

        // System.out.println("Inorder");
        // inorder(head);
        // System.out.println();
        // System.out.println("preorder");
        // preorder(head);

        // floor of the binary search tree
        // int key = 58;
        // Node ans=floor(root, key);
        // System.out.println(ans.key);

        // ceil in the bst
        // int key=78;
        // Node ans=ceil(root,key);
        // System.out.println(ans.key);

        // Treeset in java is an implementation of auto balancing tree
        // TreeSet<String> s = new TreeSet<String>();
        // s.add("gfg");
        // s.add("course");
        // s.add("ide");
        // System.out.println(s);
        // System.out.println(s.contains("course"));
        // Iterator<String> i=s.iterator();
        // while(i.hasNext()){
        // System.out.println(i.next());
        // }

        // below functions return true if the values doesnt exist
        // TreeSet<Integer> s = new TreeSet<Integer>();
        // s.add(12);
        // s.add(15);
        // s.add(20);
        // s.add(25);
        // System.out.println(s.floor(12));
        // System.out.println(s.ceiling(14));
        // System.out.println(s.lower(14));
        // System.out.println(s.higher(14));

        // add contains remove floor ceiling higher lower Olog n, size isEmpty On

        // TreeMap<Integer,String> s=new TreeMap<Integer,String>();
        // s.put(10,"hello" );
        // s.put(15,"Hii" );
        // s.put(20,"Namaste" );
        // s.put(25,"Wankkam" );
        // System.out.println(s.containsKey(10));
        // System.out.println(s.higherKey(10));
        // System.out.println(s.lowerKey(15));
        // System.out.println(s.ceilingKey(15));
        // System.out.println(s.floorKey(15));
        // System.out.println(s.higherEntry(15).getValue());
        // System.out.println(s.lowerEntry(15).getValue());
        // System.out.println(s.ceilingEntry(15).getValue());
        // System.out.println(s.floorEntry(15).getValue());

        // put remove containskey floorkey floorentry ceilingkey ceilingentry higherkey
        // higherentry lowerkey lowerentry Ologn size isEmpty() O(1)

        // TreeSet<Integer> s = new TreeSet<Integer>();
        // int arr[] = { 2, 8, 30, 15, 25, 12 };
        // s.add(arr[0]);
        // System.out.println(-1);
        // for (int i = 1; i < arr.length; i++) {
        // if ((s.ceiling(arr[i])) != null) {
        // System.out.println(s.ceiling(arr[i]));
        // } else {
        // System.out.println(-1);
        // }
        // s.add(arr[i]);
        // }

        // kth node naive method

        // int k=3;
        // printkth(root, k);

        // ABNode roots=new ABNode(10);
        // roots.lcount=1;
        // System.out.println(roots.lcount);
        // compare root node with (lcount+1) if its same return node, if greater than k
        // recur for left subtree with same k; if smaller than k recur for right tree
        // with right subtree with k as (k-lcount-1);
        // now for insertion and deletion , when your no is greater than then dont touch
        // lcount but when its smaller increment it. same for deletiion but rather than
        // incrementing it decrement it.

        // swapping the wrong nodes
        // naive

        // int arr[] = { 4, 60, 10, 20, 8, 80, 100 };
        // swappNodes(arr);

        // swappNodes(root);
        // System.out.println(first.key);
        // System.out.println(last.key);

        // given pair
        // int sum = 150;
        // HashSet<Integer> s = new HashSet<>();

        // System.out.println(givenSum(root, sum, s));

        // vSum(root);

        printVerticalOrder(root);

    }

}