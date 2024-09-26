import java.util.Arrays;

class Folder_21 {
    static int[] memo = new int[10];
    // public static int fibo(int n) {

    // if (n == 0 || n == 1) {
    // return n;
    // }
    // int res = fibo(n - 1) + fibo(n - 2);
    // System.out.println(memo[2]);
    // return res;

    // }
    public static int fiboMemo(int n) {
        if (memo[n] == -1) {
            int res;
            if (n == 0 || n == 1) {
                return n;
            } else {

                res = fiboMemo(n - 1) + fiboMemo(n - 2);
            }
            // System.out.println(memo[2]);

            memo[n] = res;
        }
        return memo[n];

    }

    public static int fiboTabula(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];

    }

    static int[][] memoLCS = new int[5][4];

    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }

    public static int memoLcs(String s1, String s2, int m, int n) {
        if (memoLCS[m][n] != -1) {
            return memoLCS[m][n];
        }
        if (m == 0 || n == 0) {
            memoLCS[m][n] = 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memoLCS[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            memoLCS[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
        return memoLCS[m][n];
    }

    static int[][] dp = new int[5][4];

    public static int lcsTabul(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        for (int i = 0; i < memoLCS.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];



    }

    public static void main(String args[]) {
        // int n=7;
        // for(int i=0;i<n;i++){
        // System.out.println(fibo(i));
        // }
        // int n = 7;
        // Arrays.fill(memo, -1);
        // for (int i = 0; i < n; i++) {
        // System.out.println(fiboMemo(i));
        // }
        // int n = 5;
        // System.out.println(fiboTabula(n));

        // for (int i = 0; i < memoLCS.length; i++) {
        //     Arrays.fill(memoLCS[i], -1);
        // }

        String s1 = "AXYZ";
        String s2 = "BAZ";
        // int m = s1.length();
        // int n = s2.length();
        // System.out.println(memoLcs(s1, s2, m, n));

        System.out.println(lcsTabul(s1, s2));

    }
}