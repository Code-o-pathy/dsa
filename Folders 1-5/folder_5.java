//largest element's index
// public class folder_5 {
//     public static void main(String args[]){
//         int[] arr={2,3,44,545,3,2634,2374,2427,24789,242};
//         int b=arr.length;
//         System.out.println(b);
//         int max=0;
//         for(int i=0;i<arr.length;i++){
//             if((arr[i])>arr[max]){
//                 max=i;
//             }
//         }
//         System.out.println("the largest element in the array is at "+max+" value is "+arr[max]);
//     }
// }
//second largest
// public class folder_5 {
//     public static void main(String args[]){
//         int[] arr={12,223332,2,3,4,534,344,2242,32542,234,344,24,2424,2};
//         int max=0;
//         int secMax=0;
//         for(int i=0;i<arr.length;i++){
//             if (arr[i]>arr[max]) {
//                 secMax=max;
//                 max=i;
//             }
//             if(arr[i]>arr[secMax] && arr[i]<arr[max]){
//                 secMax=i;
//             }
//         }
//         System.out.println("The largest no is "+arr[max]+" at index "+max);
//         System.out.println("The second largest no is "+arr[secMax]+" at index "+secMax);
//     }
// }
public class folder_5 {
    // public static void reversev14(int arr[], int low, int high) {
    // while (low < high) {
    // int temp = arr[low];
    // arr[low] = arr[high];
    // arr[high] = temp;
    // low++;
    // high--;
    // }
    // }
    public static int v22(int[] arr, int k) {
        int res = arr[0];
        int maxending = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxending = Math.max(maxending + arr[i], arr[i]);
            res = Math.max(maxending, res);
        }
        return res;
    }

    public static void main(String args[]) {

        // int[] arr={2,3};
        // for(int i=0;i<arr.length;i++){
        // System.out.print(arr[i]);
        // }
        // System.out.println("after swapping");
        // //swapping
        // for(int i=0;i<arr.length/2;i++){
        // int temp=arr[i];
        // arr[i]=arr[arr.length-i-1];
        // arr[arr.length-i-1]=temp;
        // }
        // for(int i=0;i<arr.length;i++){
        // System.out.print(arr[i]);
        // }

        // removing duplicates from a sorted array
        // naive method
        // auxiliary space required in this solution
        // int[] temp=new int[11];
        // temp[0]=arr[0];
        // int res=1;

        // for(int i=1;i<arr.length;i++){
        // if((arr[i])!=temp[res-1]){
        // temp[res]=arr[i];
        // res++;
        // }
        // }
        // for(int i=0;i<res;i++){
        // arr[i]=temp[i];

        // }
        // gfg solution more optimal one
        // int res=1;
        // for(int i=1;i<arr.length;i++){
        // if(arr[i]!=arr[res-1]){
        // arr[res]=arr[i];
        // res++;
        // }
        // }

        // insert and delete..
        // // arr[2]=4;
        // int total=8;
        // int num=3;
        // int pos=3;

        // if(total<arr.length){
        // for(int i=pos-1;i<arr.length-1;i++){
        // arr[i+1]=arr[i];
        // }
        // arr[pos-1]=num;
        // for(int i=0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // }
        // else{

        // System.out.println("no cant be inserted");
        // }
        // System.out.println("deleting");
        // int delNum=4;
        // int posdelNum=0;
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]==delNum){
        // posdelNum=i;

        // }

        // }
        // System.out.println("posdelnum"+posdelNum);
        // for(int i=posdelNum;i<arr.length-1;i++){
        // arr[i]=arr[i+1];
        // }
        // for(int i=0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // v12 naive solution On*n ;
        // int[] arr={12,3,2,23,23,0,0,324,234,24};
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]==0){
        // for(int j=i+1;j<arr.length;j++){
        // if(arr[j]!=0){
        // int temp=arr[i];
        // arr[i]=arr[j];
        // arr[j]=temp;
        // }
        // }
        // }
        // }
        // for(int i=0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // efficient solution
        // int count=0;
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]!=0){
        // int temp=arr[i];
        // arr[i]=arr[count];
        // arr[count]=temp;
        // count++;
        // }

        // }
        // for(int i=0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // left rotating an array below is by 1 digit, we can make this into loop for
        // how many digit we want
        // int[] arr = { 12, 3, 2, 23, 23, 0, 0, 324, 234, 24 };
        // int temp=arr[0];
        // for(int i=0;i<arr.length-1;i++){
        // arr[i]=arr[i+1];
        // }
        // arr[arr.length-1]=temp;
        // more optimal than looping the first method
        // int[] arr = { 12, 3, 2, 23, 23, 0, 0, 324, 234, 24 };
        // int d=2;
        // reversev14(arr,0,d-1);
        // reversev14(arr,d,arr.length-1);
        // reversev14(arr,0,arr.length-1);
        // for(int i=0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        // v15 leader naive way ;
        // for(int i=0;i<arr.length;i++){
        // boolean flag=false;
        // for(int j=i+1;j<arr.length;j++){
        // if(arr[i]<arr[j]){
        // flag=true;
        // break;
        // }
        // }
        // if(flag==false){
        // System.out.println("the leaders are"+arr[i]);
        // }
        // }
        // int[] arr = { 12, 3, 2, 23, 23, 0, 0, 324, 234, 24 };
        // System.out.println(arr[arr.length-1]+"leader<-");
        // int currLeader=arr[arr.length-1];
        // for(int i=arr.length-2;i>=0;i--){
        // if(arr[i]>currLeader){
        // System.out.println(arr[i]+"leader<-");
        // currLeader=arr[i];
        // }
        // }
        // max diff
        // int[] arr = { 12, 3, 2, 23, 23, -29, 0, 32, 23, 24 };
        // int min=arr[0];
        // int max=arr[0];
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]<min){
        // min=arr[i];
        // }
        // if(arr[i]>max){
        // max=arr[i];
        // }

        // }
        // int maxdiff=max-min;
        // System.out.println(maxdiff);
        // frequencies..
        // int[] arr = { 2, 3, 3, 4, 4, 4, 5, 5, 5 };
        // int freq = 1;
        // int i = 1;
        // while (i < arr.length ) {
        // while(i<arr.length && arr[i]==arr[i-1]){

        // freq++;
        // i++;
        // }
        // System.out.println(arr[i-1]+" "+freq);
        // i++;
        // freq=1;
        // }
        // if(arr.length==1 || arr[arr.length-1]!=arr[arr.length-2]){
        // System.out.println(arr[arr.length-1]+" "+1);
        // }
        // what i came up with
        // int[] arr = { 1,5,3,8,12 };
        // int i = 1;
        // int buyingprice = 0;
        // int sellingprice = 0;
        // int profit = 0;
        // while (i < arr.length) {
        // buyingprice = arr[i - 1];
        // while (i<arr.length && arr[i] >= arr[i - 1]) {
        // System.out.println("printing for"+i+" "+arr[i]);
        // i++;
        // }
        // sellingprice = arr[i-1];

        // profit = profit + (sellingprice - buyingprice);
        // System.out.println("printing for"+i+" profit is "+profit);
        // i++;
        // }
        // the actual gfg solution
        // int[] arr = { 1,5,3,8,12};
        // int profit=0;
        // for(int i=1;i<arr.length;i++){
        // if(arr[i]>arr[i-1]){
        // profit+=arr[i]-arr[i-1];
        // }
        // }
        // System.out.println(profit);
        // int[] arr = { -3,8,-2,4,-5,6 };
        // int i=arr.length-1;
        // System.out.println(v22(arr,i));
        // int[] arr = { 2, 4, 4, 5, 6, 7, 8 };
        // int res=0;
        // for (int i = 1; i < arr.length; i++) {
        //     int currRes = 0;
        //     while (((arr[i] % 2) == 0 && (arr[i - 1] % 2) != 0) || ((arr[i]%2)!=0 && (arr[i-1])%2==0)) {
        //         currRes++;
        //         System.out.println("curr res for "+ i+" "+currRes);
        //         i++;
        //         if(i==(arr.length)){
        //             break;
        //         }
        //     }
        //     res=Math.max(currRes,res);
        // }
        // System.out.println(res);
        int[] arr={1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,1,0};
        int flag=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1] && flag%2==0){
                System.out.println("from"+i);
                flag++;
            }
           else{
                if(arr[i]!=arr[i-1]){
                    System.out.println("To"+(i-1));
                    flag++;
                }
            }

        }
        if(arr[arr.length-1]!=arr[0] && flag%2!=0){
            System.out.println("to "+(arr.length-1));
        }
    }

}