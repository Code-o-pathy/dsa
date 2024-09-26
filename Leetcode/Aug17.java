import java.util.Arrays;

class Aug17 {
    public static boolean search2D(int matrix[][], int target) {
        int rows = matrix.length;
        int column = matrix[0].length;
        int top = 0;
        int bot = rows - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][column - 1]) {
                top = row + 1;

            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }
        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0;
        int r = column - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > matrix[row][mid]) {
                l = mid + 1;
            } else if (target < matrix[row][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;

    }

    public static int kokoBananas(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;

            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }
            if (totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
    public static void main(String args[]) {

        // search a 2D martrix
        // int matrix[][] = { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } };
        // int target = 4;
        // boolean ans = search2D(matrix, target);
        // System.out.println(ans);



        //koko eat bananas
        // int piles[] = { 1, 4, 3, 2 };
        // int h = 9;
        // int ans=kokoBananas(piles,h);
        // System.out.println(ans);




    }
}