import java.util.*;
// public class folder10 {
//     public static void main(String args[]){
//     //  String s="geeksforgeeks";
//     //  int count[]=new int[26];
//     //  for(int i=0;i<s.length();i++){
//     //     count[s.charAt(i)-'a']++;
//     //  }
//     //  for(int i=0;i<count.length;i++){
//     //     if(count[i]>0){
//     //         System.out.println((char)(i+'a')+"="+count[i]);
//     //     }
//     //  }
//     String str1="hg";
//     String str2="hf";
//     System.out.println(str1.compareTo(str2));
//     }
// }



// class Solution {
//     public static int[] productExceptSelf(int[] nums) {
//         int pro_right[] = new int[nums.length];
//         int pro_left[] = new int[nums.length];
//         int ans[] = new int[nums.length];
//         pro_right[pro_right.length - 1] = nums[nums.length - 1];
//         pro_left[0] = nums[0];
//         for (int i = nums.length - 2; i >= 0; i--) {
//             pro_right[i] = pro_right[i + 1] * nums[i];
//         }
//         for (int i = 1; i < nums.length; i++) {
//             pro_left[i] = pro_left[i - 1] * nums[i];

//         }
//         for(int i:pro_left){
//         System.out.print(i+" ");
//         }
//         System.out.println();
//         for(int i:pro_right){
//             System.out.print(i+" ");
//         }
//         System.out.println();
//         ans[0] = pro_right[1];
//         ans[nums.length-1] = pro_left[nums.length-2];

//         for (int i = 1; i < nums.length-1; i++) {
//         ans[i]=pro_left[i-1]*pro_right[i+1];
//         }

//         return ans;
//     }


// }

class folder10 {
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i:nums){
            System.out.print(i);
        }
        int arr[] = new int[k];
        if (nums.length <= 2 && k == 1) {
            arr[0] = nums[0];
            return arr;
        }
        if (nums.length <= 2 && k == 2) {
            arr[0] = nums[0];
            arr[1] = nums[1];
            return arr;
        }
        arr[0] = nums[0];
        if (k > 1) {

            arr[1] = 0;
        }
        int i = 1;
        while (i < nums.length) {
            int count = 1;
            while (nums[i] == nums[i - 1]) {
                count++;
                i++;

            }


            //problem is when count compares with arr[] it copares with no,s in array and not its count do something for that


            System.out.println(arr[0]+" "+i);
            if (k > 1) {
                if (count > arr[1]) {
                    if (count > arr[0]) {
                        arr[1] = arr[0];
                        arr[0] = nums[i - 1];
                    } else {

                        arr[1] = nums[i - 1];
                    }
                }

            } else {
                if (count > arr[0]) {
                    
                    arr[0] = nums[i - 1];
                }
            }

            i++;
        }

        
        return arr;
    }
    public static void main(String args[]){
        int nums[]={3,0,1,0};
        int k=1;
        int arr[]=topKFrequent(nums,k);
        for(int i:arr){
            System.out.println(i);
        }
    }
}