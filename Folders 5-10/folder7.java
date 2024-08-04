import java.util.*;
import java.math.*;

// class Point implements Comparable<Point> {
//     int x, y;

//     Point(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }

//     public int compareTo(Point p) {
//         return this.x - p.x;
//     }
// }
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class myCmp implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        return p2.x - p1.x; // p1.x-p2.x sort in increasing order of x co-ordinate and the current one sorts
                            // in increeasing order of x co-ordinate;
    }
}

class myCmp2 implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a % 2 - b % 2; // sorts even first and then odd no.s
    }
}

public class folder7 {
    // sorting can be used in random access containers
    // random accesss means where u can travel/or get any i'th element in a constant
    // time
    // arrays,deque,vector,etc;
    // for c++, the worst and avg case for sorting using sort() is O(nlogn)
    // sort() uses introsort(hybrid of quick heap and insertion sort);
    // if quick does unfair partitioning and uses more than nlogn time it switches
    // to heap and if the arrays or input is too small in count it goes to insertion
    // sort;

    // for java it has two algo a.dual pivot quicksort (for primitive data types)
    // b.based on merge sort adaptation of timsort(for non primitives like string
    // ,student & for collections in java) this one ensures stability
    // stability in sorting with example
    // consider the following structure{ cs,101;cs 104;ec 105;ec 106;ec 107;cs 108};
    // stability sorting {cs,101;cs104;cs 108;ec 105;ec 106;ec 107} while sorting
    // any of the cs structure cannot come before the one which was placed after it
    // originally . for eg cs 108 cannot be placed before any other cs structure ;
    // in short stability means that if 2 objects have same values then they should
    // occur in the order they were placed before
    // helpful if have multiple objects with multiple fields like the cs one field
    // and roll no other field;
    // public static void print(int arr[][]) {
    // for (int i = 0; i < arr.length; i++) {
    // for (int j = 0; j < arr[i].length; j++) {
    // System.out.println(arr[i][j] + " ");
    // }
    // }
    // }

    public static void bubbleSort(int arr[]) {
        int k = 0;
        while (k < arr.length - 1) {
            boolean swapped = false;
            for (int i = 0; i < arr.length - 1 - k; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
            System.out.println("After " + k + "th iteration");
            for (int i : arr) {
                System.out.println(i);
            }

            k++;
        }
    }

    public static void selectionSort(int arr[]) {
        int k = arr.length;
        int[] temp = new int[k];

        for (int i = 0; i < arr.length; i++) {
            int minIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp[i] = arr[minIndex];
            arr[minIndex] = Integer.MAX_VALUE;
        }

        for (int i : temp) {
            System.out.println(i);
        }

    }

    public static void optimizedSelectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[low + i];
        }
        for (int i = 0; i < n2; ++i) {
            rightArr[i] = arr[n1 + i];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;

            } else {
                arr[k] = rightArr[j];
                j++;

            }
            k++;
        }
        while (i < n1) {

            arr[k] = leftArr[i];
            i++;
            k++;

        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int arr[], int left, int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String args[]) {
        // int[] arr={2,4,3,7,6,1,3,34,3,4,3,3,4};
        // for(int i:arr){
        // System.out.println(i);
        // }
        // int[] charArr={'b','a','z','e'};
        // arrays.sort for primitives doesnt provide custom sorting functionalities so
        // if u want in descending order u first sort then reverse it
        // however for collections u can use collections.reverse i.e for non primitives
        // custom sorting is allowed
        // Arrays.sort(arr);
        // arrays.sort can sort a subarray to , the below eg shows the same, from 0 to 4
        // means start to 4-1 i.e. till 3rd element array will be sorted
        // Arrays.sort(arr,0,4); //sort a subarray
        // System.out.println(Arrays.toString(arr));
        // Arrays.sort(charArr);
        // System.out.println(Arrays.toString(charArr));

        // collection/nonprimitive sorting
        // Point arr[]={
        // new Point(3,12),new Point(4,13),new Point(1,10),new Point(2,10)
        // };
        // Arrays.sort(arr,new myCmp());
        // for(int i=0;i<arr.length;i++){
        // System.out.println(arr[i].x+" "+ arr[i].y);
        // }

        // list syntax
        // List<Integer> list=new ArrayList<Integer>();
        // list.add(23);
        // list.add(3);
        // list.add(25);
        // list.add(4);
        // Collections.sort(list);
        // Collections.sort(list,Collections.reverseOrder());

        // // System.out.println(list);

        // List<Integer> list2=new ArrayList<Integer>();
        // list2.add(3);
        // list2.add(1);
        // list2.add(5);
        // list2.add(2);
        // System.out.println(list2);
        // // Collections.sort(list2); this line not needed if going to reverse

        // Collections.sort(list2,Collections.reverseOrder());
        // System.out.println(list2);

        // Integer arr2[]={2,3,4,5,6,6,7};//this "Integer" is a wrapper class which
        // helped a primitive type to be reversed usign arrays.sort using a
        // collections.reverorder() function;
        // Arrays.sort(arr2,new myCmp2());
        // System.out.println(Arrays.toString(arr2));

        // v4
        // int arr[][]={{1,2,3},{1,2,3}};
        // int arrBubble[]={2,10,8,7};
        // bubbleSort(arrBubble);
        // int arrSelection[]={10,5,8,20,2,18};

        // selectionSort(arrSelection); //auxilliary space n
        // optimizedSelectionSort(arrSelection); //no auxilliary space

        // print(arr);

        // int[] insertionArr = { 20, 5, 40, 60, 10, 30 };
        // insertionSort(insertionArr);
        // int arr1[]={10,12,12,13};
        // int arr2[]={1,12};
        // int totalSize=arr1.length+arr2.length;
        // int sortedArr[]=new int[totalSize];
        // int p1=0;
        // int p2=0;
        // for(int i=0;i<totalSize;i++){
        // if( ((p1<arr1.length && p2<arr2.length) && arr1[p1]<arr2[p2]) ||
        // (p2==arr2.length) ){
        // sortedArr[i]=arr1[p1];
        // p1++;
        // }
        // else{
        // sortedArr[i]=arr2[p2];
        // p2++;
        // }
        // System.out.println("after iteration i="+i);
        // for(int j:sortedArr){

        // System.out.println(j);
        // }
        // }

        // naivemethod of insertion array
        // for(int i=0;i<arr1.length;i++){
        // sortedArr[i]=arr1[i];
        // }
        // for(int i=0;i<arr2.length;i++){
        // sortedArr[i+arr1.length]=arr2[i];
        // }
        // Arrays.sort(sortedArr);
        // int arr[] = {12,11,13,5,6,7};
        // int left = 0;
        // int right = arr.length - 1;
        // mergeSort(arr, 0, right); //merge sort wrong get the code from gfg

        // for (int i=0;i<arr.length;i++) {
        // System.out.println(arr[i]);
        // }

        // intersection(same elements) can work on any type of arrays (sorted or un
        // sorted)
        // int[] a={2,3,4,5,6,7,8,9,10};
        // int[] b={41,52,63,77,88,99,10,101};
        // for(int i=0;i<a.length;i++){
        // if(i>0 && a[i]==a[i-1]){
        // continue;
        // }
        // for(int j=0;j<b.length;j++){
        // if(a[i]==b[j]){
        // System.out.println(a[i]);
        // break;
        // }
        // }
        // }

        // intersecction efficient method drawback is that it can only work on sorted
        // arrays
        int[] arr = { 3, 5, 8 };
        int[] art = { 2, 8, 9, 10, 15 };
        int i = 0;
        int j = 0;
        while (i < arr.length && j < art.length) {

            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && art[j] == art[j - 1]) {
                j++;
                continue;
            }
            if (arr[i] < art[j]) {
                System.out.println(arr[i]); // if u have to print the union of the two arrays
                i++;
            }
            else if (arr[i] > art[j]) {

                System.out.println(art[j]);

                j++;
            } else {
                System.out.println(arr[i]);
                i++;
                j++;
            }

        }

        // if u have to print the union of the two arrays
        while (i < arr.length) {
            if (arr[i] != arr[i - 1]) {
                System.out.println(arr[i]);
            }
            i++;
        }
        while (j < art.length) {
            if (art[j] != art[j - 1]) {
                System.out.println(art[j]);
            }
            j++;
        }

    }
}
