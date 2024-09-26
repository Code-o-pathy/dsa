import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start;
    int finish;

    Activity(int s, int f) {
        start = s;
        finish = f;
    }
}

class Job {
    int deadline;
    int profit;

    Job(int d, int p) {
        deadline = d;
        profit = p;
    }
}

class MyCmpJob implements Comparator<Job> {
    public int compare(Job a1, Job a2) {
        return a2.profit - a1.profit;
    }
}

class MyCmp implements Comparator<Activity> {
    public int compare(Activity a1, Activity a2) {
        return a1.finish - a2.finish;
    }
}
// class MyCmp implements Comparator<Activity> {
// public int compare(Activity a1, Activity a2) {
// return a2.profit - a1.profit;
// }
// }

class Item implements Comparable<Item> {
    int wt;
    int val;

    public Item(int w, int v) {
        wt = w;
        val = v;

    }

    public int compareTo(Item i) {
        return (wt * i.val) - (val * i.wt);
    }
}

class Folder19 {

    public static int noOfCoins(int arr[], int amount) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= amount) {
                int c = Math.floorDiv(amount, arr[i]);
                amount = amount - c * arr[i];
                res = res + c;
            }
            if (amount == 0) {
                break;
            }
        }

        System.out.println(res + "<=res");
        return res;

    }

    public static int maxActivity(Activity[] arr) {
        Arrays.sort(arr, new MyCmp());
        int res = 1;
        int prev = 0;
        for (int curr = 1; curr < arr.length; curr++) {
            if (arr[curr].start >= arr[prev].finish) {
                res++;
                prev = curr;
            }
        }
        return res;
    }

    public static double knapsack(Item arr[], int W) {

        // time complexity is O(nlogn)+O(n) =O(nlogn)
        Arrays.sort(arr);
        double res = 0.0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].wt <= W) {
                res = res + arr[i].val;
                W = W - arr[i].wt;
            } else {
                res = res + arr[i].val * (double) W / (double) arr[i].val;
                break;
            }
        }
        System.out.println(res);
        return res;
    }

    public static int maxProfitJobs(Job[] arr) {
        Arrays.sort(arr, new MyCmpJob());
        int res=0;
        int ans[] = new int[arr.length];
        for (Job i : arr) {
            System.out.println(i.deadline +" "+i.profit );
            if(ans[i.deadline-1]==0){
                res+=i.profit;
                ans[i.deadline-1]=i.profit-1;
            }
        }

        System.out.println(res);
        return res;
    }

    public static void main(String args[]) {
        // System.out.println("Hello");
        // greedy algorithm works with selecting the optimum solution at the current
        // point.
        // sometimes greedy algo wont work, for eg, if the below coind example had coins
        // such as {18,1,10} and the amount was just 20, and the goal was to find the
        // least no of coins.
        // or finding shortest path where,
        // int arr[] = { 100, 50, 20, 10, 5, 2, 1 };
        // int amount = 10;
        // int ans = noOfCoins(arr, amount);
        // System.out.println(ans);

        // applications of greedy algorithm

        // -finding optimal solutions
        // --Activity selection
        // --fractional knapsack
        // --Job sequencing
        // --prims algorithms
        // --kruskels algorithm
        // --Djkistra's algorithm
        // --huffman coding

        // -finding close to optimal solutions to NP hard problems

        // Activity selection problem
        // Activity array[] = { new Activity(1, 2), new Activity(10, 20), new
        // Activity(20, 30) };
        // System.out.println(maxActivity(array));

        // Fractional KnapSack problem
        // Item arr[]={new Item(10,60),new Item(40,40),new Item(20,100),new
        // Item(30,120)};
        // int W=50;
        // knapsack(arr,W);

        Job arr[] = { new Job(4, 50), new Job(3, 5), new Job(2, 20), new Job(5, 10), new Job(5, 80) };
        int ans = maxProfitJobs(arr);
        System.out.println(ans);
    }
}
