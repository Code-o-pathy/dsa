import java.util.Arrays;

public class Leetcode {

    public static int[] repeatedNumber( int[] A) {
        Arrays.sort(A);
        int arr[]=new int[2];

    
        for(int i=1;i<A.length;i++){
            if(!(A[i]>A[i-1])){
                arr[0]=A[i];
                arr[1]=A[i]+1;
                break;
            }
        }
        
        return arr;
    }

    public static void main(String args[]) {
        int A[]={3,1,2,4,4};
        int ans[]=repeatedNumber(A);
        for(int i:ans){
            System.out.println(i);
        }

      

    }
}