public class folder_3 {
    // public static void table(int n) {
    // int[] table = new int[256];
    // table[0] = 0;
    // for (int i = 1; i < 256; i++) {
    // table[i] = (i & 1) + table[i / 2];
    // }
    // int count = table[n & 0xff];
    // System.out.println(table[0xff]);
    // n = n >> 8;
    // count = count + table[n & 0xff];
    // n = n >> 8;
    // count = count + table[n & 0xff];
    // n = n >> 8;
    // count = count + table[n & 0xff];
    // n = n >> 8;
    // System.out.println(count);

    // }

    public static void main(String args[]) {
        // int n = 200;
        // int m = 6;
        // System.out.println(Integer.toBinaryString(n));
        // System.out.println(Integer.toBinaryString(m));

        // System.out.println();
        // int x = n & m;

        // System.out.println(x);
        // System.out.println(Integer.toBinaryString(x));
        // int n = 7;

        // naive soln
        // while(n!=0){
        // if((n&1)==1){
        // count++;
        // n=n>>1;
        // }
        // else{
        // n=n>>1;

        // }
        // }
        // while(n!=0){
        // n=n&(n-1);
        // count++;
        // }
        // table lookup method;
        // table(n);

        // two oddly occuring no.s in an array
        // int res = 0;
        // int res1 = 0;
        // int res2 = 0;
        // int[] arr = { 3, 4, 3, 4, 5, 4, 4, 8, 7, 7 };
        // for (int i = 0; i < arr.length; i++) {
        // res = res ^ arr[i];
        // }
        // int sn = res & ~(res - 1);
        // for (int i = 0; i < arr.length; i++) {
        // if ((arr[i] & sn) != 0) {
        // res1 = res1 ^ arr[i];
        // } else {
        // res2 = res2 ^ arr[i];

        // }
        // }
        // System.out.println(res1);
        // System.out.println(res2);
        // power set what i came up with
        // String s="abc";
        // int a=s.length();
        // int lim=(int)Math.pow(2, a);
        // char charat0=s.charAt(0);
        // char charat1=s.charAt(1);
        // char charat2=s.charAt(2);
        // for(int i=0;i<=lim;i++){
        // String res="";
        // if((i&1)!=0){
        // res+=charat0;
        // }
        // if ((i&2)!=0) {
        // res+=charat1;
        // }
        // if ((i&4)!=0) {
        // res+=charat2;
        // }
        // System.out.println(res);

        // }
        // actual solution
        // int counter = 0;
        // String s = "abc";
        // int lim = (int) Math.pow(2, s.length());
        // for (int i = 0; i < lim; i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         if ((counter & (1 << j)) != 0) {
        //             System.out.print(j);
        //             System.out.print(s.charAt(j));
        //         }
        //         counter++;

        //     }
        //     System.out.println();
        // }
    }
}
