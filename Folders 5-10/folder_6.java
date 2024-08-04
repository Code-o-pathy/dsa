public class folder_6 {
    public static int binarySearch(int[] arr, int x, int low, int high) {
        // normal binary search

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                low = mid + 1;
            }
            if (arr[mid] > x) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int x, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        }
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            low = mid + 1;
            return recursiveBinarySearch(arr, x, low, high);
        }
        high = mid - 1;
        return recursiveBinarySearch(arr, x, low, high);

    }

    // wrong but nice try
    public static void rotatedSorted(int[] arr, int x, int low, int high) {

        int mid = (low + high) / 2;
        if (arr[mid] >= arr[0]) {
            // left is sorted;
            if (arr[mid] >= x) {
                int ans1 = binarySearch(arr, x, 0, mid + 1);
                System.out.println(ans1);

            }
        }
        rotatedSorted(arr, x, mid + 1, high);
        int ans2 = binarySearch(arr, x, mid + 1, arr.length);

        System.out.println(ans2);

    }

    public static int searchRotatedSorted(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] >= arr[low]) {
                if (x >= arr[low] && x < arr[mid]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }
            } else {
                if(x>arr[mid]&& x<=arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }

        }
        return -1;
    }
    public static int twoPointer(int[] arr, int x,int low,int high){
        while(low<high){
            if(arr[low]+arr[high]==x){
                System.out.println(arr[low]);
                return high;
            }
            if(arr[low]+arr[high]>x){
                high=high-1;
            }
           else{
                low=low+1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        // binary search
        // int[] arr={11,12,12,15,15,15,18};
        // int x=15;
        // int low=0;
        // int high=arr.length-1;
        // int d=binarySearch(arr, x);
        // //for finding the first/last occurrence
        // while(d<arr.length && arr[d]==x){
        // d++;

        // }
        // int c=recursiveBinarySearch(arr,x,low,high);
        // // System.out.println(c);
        // System.out.println(d-1);
        int[] arr = { 10, 20, 22, 34, 55, 88 };
        int x = 89;
        int low = 0;
        int high = arr.length-1;
        int ans = twoPointer(arr, x, low, high);
        if(ans!=-1){
        System.out.println(arr[ans]);
    }

    }
}
