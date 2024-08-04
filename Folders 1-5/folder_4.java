public class folder_4 {
    public static void v5(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        v5(n - 1);
    }

    public static void v6(int n) {

        if (n == 0) {
            return;
        }
        v6(n - 1);
        System.out.print(n + " ");
    }

    public static void v6_tr(int n,int counter) {

        if (n == 0) {
            return;
        }
        System.out.print(counter);
        v6_tr(n - 1,  + 1);
    }

    public static int v7(int n, int m) {
        if (n == 0 || n == 1) {
            return m;
        }
        System.out.println(m);
        return v7(n - 1, m * n);

    }

    public static int v8_1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * v8_1(n - 1);
    }

    public static int v8_2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return v8_2(n - 1) + v8_2(n - 2);
    }

    public static int v9(int n, int m) {
        if (n == 0) {
            return m;
        }
        // m=m+n;
        return v9(n - 1, m+n /*m */);
    }
    public static int v9_gfg(int n) {
        if (n == 0) {
            return n;
        }
        // m=m+n;
        return n+v9_gfg(n - 1);
    }
    public static boolean v10(String s,int n){
        while (n<s.length()) {
            
            if(s.charAt(n)!=s.charAt(s.length()-1-n)){
                return false;
            }
            return v10(s, n=n+1);
        }
        return true;
    }
    public static int  v11(int n,int m){
        if(n<=0){
            return m;
        }
        int ld=n%10;

        m+=ld;
        
        return v11((n/10),m);
    }
    public static int  v11_gfg(int n){
        if(n<=9){//<=0
            return n;//0
        }

        return v11((n/10),n%10);
    }
    public static int v12(int ropeLength,int rope1,int rope2,int rope3){
        if(ropeLength==0){
            return 0;
        }
        if(ropeLength<0){
            return -1;
        }
        int res=Math.max(v12( ropeLength-rope1, rope1, rope2, rope3), Math.max(v12( ropeLength-rope2, rope1, rope2, rope3), v12( ropeLength-rope3, rope1, rope2, rope3)));
        if(res==-1){
            return -1;
        }
        return 1+res;
    }
    public static void v13(String s,String curr,int i){
        if(i==s.length()){
            System.out.println(curr);
            return;
        }
        v13(s, curr, i+1);
        v13(s, curr+s.charAt(i), i+1);
    }
    public static void v14(int n,char A,char B,char C){
        if(n==1){
            System.out.println("Move 1 from "+ A+" to "+C);
            return;
        }
        v14(n-1, A, C, B);
        System.out.println("Move "+n+" from "+A+" to "+C);
        v14(n-1, B, A, C);
    }
    public static int v15(int n,int k){
        if(n==1){
            return 0;

        }
        return v15(n-1,k);
    }

    public static void main(String args[]) {
        // int n = 3;
        // n to 1
        // v5(n);
        // 1 to n non tail recursive
        // v6(n);
        // int counter =1;
        // v6_tr(n,counter);
        // int m=1;
        // int d=v7(n,m);
        // System.out.println(d);
        // v8
        // int d=v8_1(n);
        // int d=v8_2(n);
        // System.out.println(d);
        // int m = 0;
        // int d = v9(n, m);
        // int d = v9_gfg(n);
        // System.out.println(d);
        // String s="effde";
        // System.out.println((v10(s,n)));
        // int n=9987;
        // int m=0;
        // v11(n,m);
        // System.out.println(v11(n, m));
        // v11_gfg(n);
        // System.out.println(v11_gfg(n));
        // int ropeLength=5;
        // int rope1=5;
        // int rope2=2;
        // int rope3=1;
        // v12(ropeLength,rope1,rope2,rope3);
        // System.out.println(v12(ropeLength, rope1, rope2,  rope3));
        //v13 generate subsets
        // String s="ABC";
        // String curr="";
        // int i=0;
        // v13(s,curr,i);
        // int n=4;
        // char A='A';
        // char B='B';
        // char C='C';
        // v14(n,A,B,C);
        int n=4;
        int k=2;
        v15(n,k);



    }
}
