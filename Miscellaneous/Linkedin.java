import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

//chaining in hashing   
class MyHash {
    int bucket;
    ArrayList<LinkedList<Integer>> table;

    MyHash(int b) {
        bucket = b;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < b; i++) {
            table.add(new LinkedList<Integer>());
        }
    }

    void insert(int key) {
        int i = key % bucket;
        table.get(i).add(key);
    }

    void remove(int key) {
        int i = key % bucket;
        table.get(i).remove(key);
    }

    boolean search(int key) {
        int i = key % bucket;
        return table.get(i).contains(key);
    }

}

public class Linkedin {

    public static boolean containsDuplicate(int[] nums) {
        boolean ans = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    System.out.println(nums[i]);
                    System.out.println(nums[j]);
                    ans = true;
                }
            }
        }
        return ans;
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int currCount = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] == nums[i - 1] + 1)) {
                currCount++;
            } else {
                count = Math.max(currCount, count);

                System.out.println(count);

                currCount = 1;
            }
        }
        return count;
    }
    public static void Zigzg(String s,int n){
        int arr[]=new int[s.length()];
        int count=0;
        Arrays.fill(arr, 0);
        for(int i=0;i<arr.length;i=i+4){
            arr[i]=1;
            count++;
            System.out.print(s.charAt(i));
        }
        while(count!=arr.length-1){
            int target=0;
            for(int i=1;i<arr.length;i++){
                if(arr[i]==1){
                    target=i;
                }

            }

        }
    }

    public static void main(String args[]) {

        // int nums[] = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // System.out.println(longestConsecutive(nums));

        // String s="PAYPALISHIRING";
        // int rows=3;
        // Zigzg(s,rows);
        char c=' ';
        System.out.println((int)c);
        

    }
}