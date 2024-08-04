import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.io.*;
import java.lang.*;

class Node {
    int key;
    Node left;
    Node right;

    Node(int k) {
        key = k;
        left = right = null;
    }

}

class Distance {
    int val;

    Distance(int d) {
        val = d;
    }
}

public class Folder15 {

    static int res = 0;

    public static int burnTime(Node root, int leaf,
            Distance dist) {
        if (root == null)
            return 0;
        if (root.key == leaf) {
            dist.val = 0;
            return 1;
        }
        Distance ldist = new Distance(-1),
                rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, dist.val + rh);
        } else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + lh);
        }
        return Math.max(lh, rh) + 1;
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.key);
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void distanceRoot(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.key);
        } else {
            distanceRoot(root.left, k - 1);
            distanceRoot(root.right, k - 1);
        }
    }

    public static void levelorder(Node root) {
        int k = 0;
        int height = height(root);
        while (k < height) {
            distanceRoot(root, k);
            k++;
        }
    }

    public static void levelorderEfficient(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.println(curr.key);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

    }

    public static void levelSabkeNikalenge(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size() > 1) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.println(curr.key);

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
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

    public static int sizeOfBinary(Node root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + sizeOfBinary(root.left) + sizeOfBinary(root.right);
        }
    }

    public static int maximumOfBinaryTree(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.key, Math.max(maximumOfBinaryTree(root.left), maximumOfBinaryTree(root.right)));
        }
    }

    static int maxLevel = 0;

    public static void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(root.key + " key");
            maxLevel = level;
            System.out.println(maxLevel);
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);

    }

    public static void leftViewIterative(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (i == 0) {

                    System.out.print(curr.key);
                }

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

    public static boolean childrenSum(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.key;
        }
        if (root.right != null) {
            sum += root.right.key;
        }

        return (root.key == sum && childrenSum(root.left) && childrenSum(root.right));
    }

    public static int balancedOrNot(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = balancedOrNot(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = balancedOrNot(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return Math.max(lh, rh) + 1;
        }
    }

    public static int maximumWidth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            int count = q.size();
            res = Math.max(res, count);
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
        return res;

    }

    static Node prev = null;

    public static Node binaryToDoubly(Node root) {
        if (root == null) {
            return root;
        }
        Node head = binaryToDoubly(root.left);
        if (prev == null) {
            head = root;

        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        binaryToDoubly(root.right);
        return head;
    }

    static int preIndex = 0;

    public static Node inorderAndPreorderToTree(int in[], int pre[], int is, int ie) {
        if (is > ie) {
            return null;
        }
        Node root = new Node(pre[preIndex++]);
        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.left = inorderAndPreorderToTree(in, pre, is, inIndex - 1);
        root.right = inorderAndPreorderToTree(in, pre, inIndex + 1, ie);
        return root;
    }

    public static void spiralTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        boolean reverse = false;
        q.add(root);
        while (q.isEmpty() == false) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (reverse) {
                    s.push(curr.key);
                } else {

                    System.out.print(curr.key + " ");
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (reverse) {
                while (s.isEmpty() == false) {
                    System.out.print(s.pop() + " ");
                }
            }
            reverse = !reverse;
            System.out.println();

        }

    }

    public static void spiralTreeOptimized(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (s1.isEmpty() == false || s2.isEmpty() == false) {
            while (s1.isEmpty() == false) {
                Node curr = s1.pop();
                if (curr.left != null) {
                    s2.push(curr.left);
                }
                if (curr.right != null) {
                    s2.push(curr.right);
                }
                System.out.print(curr.key + " ");
            }
            System.out.println();
            while (s2.isEmpty() == false) {
                Node curr = s2.pop();
                if (curr.right != null) {
                    s1.push(curr.right);
                }
                if (curr.left != null) {
                    s1.push(curr.left);
                }
                System.out.print(curr.key + " ");
            }
            System.out.println();
        }

    }

    public static int heights(Node root) {
        if (root == null) {
            return 0;
        } else {

            return (1 + Math.max(heights(root.left), heights(root.right)));
        }
    }

    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int d1 = 1 + heights(root.left) + heights(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);
        return Math.max(d1, Math.max(d2, d3));

    }

    static int result = 0;

    public static int diameter2(Node root) {
        if (root == null) {
            return 0;

        }
        int lh = diameter2(root.left);
        int rh = diameter2(root.right);
        result = Math.max(result, 1 + lh + rh);
        return result;
    }

    public static boolean findPath(Node root, int n,
            ArrayList<Integer> path) {
        // base case
        if (root == null) {
            return false;
        }

        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.key);

        if (root.key == n ||
                findPath(root.left, n, path) ||
                findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root,
        // remove root from path[] and return false
        path.remove(path.size() - 1);

        return false;
    }

    public static int findLCAInternal(Node root, int n1, int n2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        if (!findPath(root, n1, path1)
                || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0)
                    ? "n1 is present"
                    : "n1 is missing");
            System.out.println((path2.size() > 0)
                    ? "n2 is present"
                    : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

            // System.out.println(path1.get(i) + " " +
            // path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    public static Node efficientLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.key == n1 || root.key == n2) {
            return root;
        }
        Node lca1 = efficientLCA(root.left, n1, n2);
        Node lca2 = efficientLCA(root.right, n1, n2);
        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static int noOfNodes(Node root) {
        int lh = 0;
        int rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (rh == lh) {
            return (int) Math.pow(2, rh) - 1;
        } else {
            return 1 + noOfNodes(root.left) + noOfNodes(root.right);
        }
    }

    static final int EMPTY = -1;

    public static void serialize(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(EMPTY);
            return;
        }
        arr.add(root.key);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    static int index = 0;

    public static Node deSerialize(ArrayList<Integer> arr) {
        if (index == arr.size()) {
            return null;
        }
        int val = arr.get(index);
        index++;
        if (val == EMPTY) {
            return null;
        }
        Node root = new Node(val);
        root.left = deSerialize(arr);
        root.right = deSerialize(arr);
        return root;
    }

    public static void iterativeInorder(Node root) {
        Node curr = root;
        Stack<Node> st = new Stack<>();
        while (curr != null || st.isEmpty() == false) {
            // condition to check if the node is leftmost node
            while (curr != null) {
                // step 3 of our algorithm
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            // cout statement to print the node data
            System.out.println(curr.key + " ");

            // statement to process right subtree
            curr = curr.right;
        }
    }

    public static void iterativePreorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (st.isEmpty() == false) {
            // condition to check if the node is leftmost node
            Node curr = st.pop();
            System.out.println(curr.key + " ");
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
    }

    public static void iterativePreorderOptimized(Node root) {
        Node curr = root;
        Stack<Node> st = new Stack<>();
        while (curr != null || st.isEmpty() == false) {
            while (curr != null) {
                System.out.println(curr.key + " ");
                if (curr.right != null) {
                    st.push(curr.right);

                }
                curr = curr.left;
            }
            if(st.isEmpty()==false){
                curr=st.pop();
            }

        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(60);
        root.left.left.left = new Node(90);
        root.left.right = new Node(70);
        // root.left.right.left = new Node(90);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        // Node curr=root;
        // while(curr!=null){
        // System.out.println(curr.key);
        // curr=curr.right;
        // }

        // inorder(root);
        // preorder(root);
        // postorder(root);

        // height of a tree
        // int ans = height(root);
        // System.out.println(ans);

        // k distance from root
        // int k=1;
        // distanceRoot(root,k);

        // using height and distance k from root function
        // levelorder(root);

        // efficient way
        // levelorderEfficient(root);

        // level by level but a new line at the end of every level
        // levelSabkeNikalenge(root);

        // method 2
        // levelSabkeNikalengePart2(root);

        // size of binary tree-recursive time complexity O(h)-height of binary tree.
        // int ans= sizeOfBinary(root);
        // System.out.println(ans);

        // size of binary tree-iterative(levelsabkenikalenge me counter add krke
        // q.poll() pe counter++ end me counter return ) time complexity O(n)-n is width
        // of binary tree at given level..

        // maximum of a binary tree
        // int ans = maximumOfBinaryTree(root);
        // System.out.println(ans);

        // left view of binary tree(leftest node on every level)
        // recursive
        // int level = 1;

        // leftView(root, level);

        /// iterative
        // leftViewIterative(root);

        // childrenSum
        // boolean ans=childrenSum(root);
        // System.out.println(ans);

        // balanced or not
        // int ans = balancedOrNot(root);
        // System.out.println(ans);

        // maximum width
        // int ans = maximumWidth(root);
        // System.out.println(ans);

        // binary tree to doubly linked list
        // Node head = binaryToDoubly(root);
        // Node curr = head;
        // while (curr != null) {
        // System.out.println(curr.key);
        // curr = curr.right;
        // }

        // inorder and oreorder to tree
        // int in[] = { 20, 10, 40, 30, 50 };
        // int pre[] = { 10, 20, 30, 40, 50 };
        // int is = 0;
        // int ie = 4;
        // Node head= inorderAndPreorderToTree(in, pre, is, ie);
        // inorder(head);
        // System.out.println();
        // preorder(head);

        // currently it takes O(n2) but with hashing we can remove the for loop and time
        // complexity will be O(n)

        // print tree in spiral form

        // spiralTree(root);
        // the above solution uses two datastructures,
        // when to print reverse it goes into queue then comes out of the queue and goes
        // into the stack and comes out of the stack increasing the time taken.

        // spiralTreeOptimized(root);

        // print the diameter of the tree(longest distance between its nodes)

        // int ans = diameter(root);
        // System.out.println(ans);

        // lowest common ancestor
        // int ans = findLCAInternal(root, 70, 20);
        // System.out.println(ans);

        // efficient lowest common ancestor
        // Node ans=efficientLCA(root, 40 , 50);
        // System.out.println(ans.key);

        // time to burn the tree
        // Distance dist = new Distance(-1);
        // int ans = burnTime(root, 50, dist);
        // System.out.println(ans);

        // no of nodes in a complete binary tree;
        // int ans=noOfNodes(root);
        // System.out.println(ans);

        // serialize and deserialize
        // ArrayList<Integer> arr=new ArrayList<>();
        // serialize(root,arr);
        // for(int i:arr){
        // System.out.print(i+" ");
        // }
        // System.out.println();

        // Node head=deSerialize(arr);
        // levelSabkeNikalenge(head);

        // iterative inorder traversal
        // iterativeInorder(root);
        // iterativePreorder(root);
        iterativePreorderOptimized(root);

    }
}