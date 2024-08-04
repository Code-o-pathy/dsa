import java.util.Arrays;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public static long[] kthPalindrome(int[] queries, int length) {
        // making the answer array
        int max = queries[queries.length - 1];
        long answer[] = new long[max];
        Arrays.fill(answer, -1);

        // deciding the range;
        int start = 1;
        int end = 9;
        while (length > 1) {
            start = start * 10;
            end = end * 10 + 9;
            length--;

        }

        //

        return answer;

    }

    public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans) {
                ans -= num;
                System.out.println(ans);
            } else {
                ans += num;
            }
        }
        return ans;
    }

    public static String intToRoman(int num) {
        int intValue[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String code[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intValue.length; i++) {
            System.out.println("Round i" + i);
            while (num >= intValue[i]) {
                sb.append(code[i]);
                System.out.println(sb.toString());
                num = num - intValue[i];
            }
        }
        return sb.toString();
    }

    public static int myAtoi(String s) {
        int finalRes = 0;
        int i = 0;
        while (i < s.length()) {
            if ((s.charAt(i) - '0') <= 9 && s.charAt(i) - '0' >= 0) {
                int digit = s.charAt(i) - '0';
                finalRes = finalRes * 10 + digit;
            }
            if (s.charAt(i) == '-') {
                finalRes = finalRes * (-1);
            }
            i++;
        }
        return finalRes;
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

    public static Node addList(Node l1, Node l2) {

        Node curr1 = l1;
        Node curr2 = l2;
        Node ans = new Node(9);
        if (l1 == null) {
            System.out.println("l1==null");
            insertEnd(ans, l2.data);
            curr2 = curr2.next;
        }
        if (l2 == null) {
            System.out.println("l2==null");
            insertEnd(ans, l1.data);
            curr1 = curr1.next;
        }

        int carry = 0;
        int insertable = 0;
        while (curr1 != null && curr2 != null) {
            System.out.println("l1 and 2!=null");
            insertable = 0;
            int data = curr1.data + curr2.data + carry;
            if (data > 9) {
                insertable = (data % 10);

                insertEnd(ans, insertable);
            } else {
                insertEnd(ans, data);
            }
            carry = data / 10;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr2 != null) {
            System.out.println("l1 expired");
            int data = curr2.data + carry;

            if (data > 9) {
                insertable = (data % 10);

                insertEnd(ans, insertable);
            } else {
                insertEnd(ans, data);
            }
            carry = data / 10;

            curr2 = curr2.next;
        }
        while (curr1 != null) {
            System.out.println("l2expired");
            int data = curr1.data + carry;

            if (data > 9) {
                insertable = (data % 10);

                insertEnd(ans, insertable);
            } else {
                insertEnd(ans, data);
            }
            carry = data / 10;

            curr1 = curr1.next;
        }
        if (carry != 0) {
            insertEnd(ans, carry);
        }

        ans = delBeg(ans);

        return ans;

    }

    public static Node delBeg(Node head) {
        if (head == null) {
            return null;
        }
        return head.next;

    }

    public static void printNode(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printNode(head.next);
    }

    public static boolean pairInSortedRotated(int arr[], int n,
            int x) {
        // Find the pivot element
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        // l is now index of smallest element
        int l = (i + 1) % n;

        // r is now index of largest element
        int r = i;

        // Keep moving either l or r till they meet
        while (l != r) {
            // If we find a pair with sum x, we
            // return true
            if (arr[l] + arr[r] == x)
                return true;

            // If current pair sum is less, move
            // to the higher sum
            if (arr[l] + arr[r] < x)
                l = (l + 1) % n;    

            // Move to the lower sum side
            else
                r = (n + r - 1) % n;
        }
        return false;
    }

    public static void main(String args[]) {
        // int queries[] = { 1, 2, 3, 4, 5, 90 };
        // int length = 3;
        // kthPalindrome(queries, length);
        // String s="LVIII";

        // int n=76;
        // System.out.println(intToRoman(n));

        // System.out.println(romanToInt(s));

        // String s="42";

        // System.out.println(s.charAt(1)+1);
        // int ans=myAtoi(s);
        // System.out.println(ans);

        // // 8
        // Node l1 = new Node(9);
        // l1.next = new Node(9);
        // l1.next.next = new Node(9);
        // l1.next.next.next = new Node(9);
        // l1.next.next.next.next = new Node(9);
        // l1.next.next.next.next.next = new Node(9);
        // l1.next.next.next.next.next.next = new Node(9);
        // Node l2 = new Node(9);
        // l2.next = new Node(9);
        // l2.next.next = new Node(9);
        // l2.next.next.next = new Node(9);
        // printNode(l1);
        // System.out.println();
        // printNode(l2);
        // Node ans = addList(l1, l2);

        // System.out.println();
        // printNode(ans);
        // int nums[]={2,3,0,-2,4};

        // int max = nums[0], min = nums[0], ans = nums[0];

        // for (int i = 1; i < nums.length; i++) {

        // int temp = max;

        // max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
        // min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
        // System.out.println(max+" for "+i);
        // System.out.println(min+" for "+i);
        // System.out.println(ans+" for "+i);

        // if (max > ans) {
        // ans = max;
        // }
        // }
        // System.out.println(ans);

        int arr[] = { 11, 15, 6, 8, 9, 10 };
        int X = 16;
        int N = arr.length;

        if (pairInSortedRotated(arr, N, X))
            System.out.print("true");
        else
            System.out.print("false");

    }
}
