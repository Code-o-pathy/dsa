import java.io.*;
import java.util.Arrays;

class Point implements Comparable<Point> {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point p) {
		return this.x - p.x;
	}
}

public class folder7_2 {

	// Java program for Merge Sort

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	public static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Merge the temp arrays

		// Initial indices of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public static void sort(int arr[], int l, int r) {
		if (l < r) {

			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// A utility function to print array of size n
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// countand merge algo
	public static int countAndMerge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// Create temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		// Merge the temp arrays

		// Initial indices of first and second subarrays
		int i = 0, j = 0;
		int res = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
				res = res + (n1 - i);
			}
			k++;
		}

		// Copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// Copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return res;
	}

	// countInversion function
	public static int countInversion(int arr[], int l, int r) {
		int res = 0;
		if (l < r) {
			int mid = l + (r - l) / 2;
			res = res + countInversion(arr, l, mid);
			res = res + countInversion(arr, mid + 1, r);
			res = res + countAndMerge(arr, l, mid, r);

		}
		return res;
	}

	// naive partitioning method
	public static void partition(int arr[], int l, int h, int p) {
		int temp[] = new int[h - l + 1];
		int indx = 0;

		for (int i = l; i <= h; i++) {
			if (arr[i] <= arr[p]) {
				temp[indx] = arr[i];
				indx++;

			}
		}
		for (int i = l; i <= h; i++) {
			if (arr[i] > arr[p]) {
				temp[indx] = arr[i];
				indx++;

			}
		}
		for (int i = l; i <= h; i++) {
			arr[i] = temp[i - l];
		}

	}
	// lomuto partition

	public static int lPartition(int arr[], int l, int h) {

		int pivot = arr[h];

		// swap(arr, arr[h], pivot); //if pivot is not the last element swap the given
		// pivot with last element in the array and continue

		int i = l - 1;
		for (int j = l; j <= h - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				// swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}

		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[h];
		arr[h] = temp;

		return (i + 1);

	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int hPartition(int arr[], int l, int h) {
		int i = l - 1;
		int j = h + 1;

		int pivot = arr[l];
		while (true) {
			do {

				i++;
			}

			while (arr[i] < pivot);
			do {
				j--;
			} while (arr[j] > pivot);
			if (i >= j) {
				return j;
			}
			swap(arr, i, j);

		}
	}

	// quick sort using lomuto partition
	// public static void quickSort(int arr[],int l,int h){

	// if(l<h){
	// int p=lPartition(arr, l, h);
	// quickSort(arr, l, p-1);
	// quickSort(arr, p+1, h);
	// }

	// }
	// quick sort using hoares partition
	public static void quickSort(int arr[], int l, int h) {

		if (l < h) {
			int p = hPartition(arr, l, h);
			quickSort(arr, l, p);
			quickSort(arr, p + 1, h);
		}

	}

	public static int kth(int arr[], int k) {
		int l = 0;
		int h = arr.length - 1;
		while (l <= h) {
			int p = lPartition(arr, l, h);
			System.out.println("i" + p);
			for (int i : arr) {
				System.out.println(i);
			}
			if (p == k - 1) {
				return p;
			} else if (p > k - 1) {
				h = p - 1;
			} else {
				l = p + 1;
			}
		}
		return -1;
	}

	public static int minDiff(int arr[], int m) {
		int l = 0;
		int h = arr.length - 1;
		if (m > arr.length) {
			return -1;

		}
		Arrays.sort(arr);
		int res = arr[m - 1] - arr[0];
		for (int i = 1; (i + m - 1) < arr.length; i++) {
			res = Math.min(res, arr[i + m - 1] - arr[i]);
		}

		return res;
	}

	public static void segNum(int arr[]) {
		int i = -1;
		int j = arr.length;
		while (true) {
			do {
				i++;
			} while (arr[i] < 0);
			do {
				j--;
			} while (arr[j] >= 0);
			if (i >= j) {
				return;
			}
			swap(arr, i, j);
		}
	}

	public static void segNum2(int arr[]) {
		// dutch national flag algo
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr, low, mid);
				mid++;
				low++;

			} else if (arr[mid] == 1) {
				mid++;
			} else {
				swap(arr, mid, high);
				high--;

			}
		}
	}

	public static void meetGuest(int arr[], int[] dept) {

		Arrays.sort(arr);
		Arrays.sort(dept);
		int curr = 1;
		int res = 1;
		int i = 1;
		int j = 0;
		while (i < arr.length && j < dept.length) {
			if (arr[i] <= dept[j]) {
				curr++;
				i++;
			} else {
				curr--;
				j++;
			}
			res = Math.max(curr, res);

		}
		System.out.println(res);

	}

	// cycle sort
	public static void cycleSort(int arr[]) {
		int swap = 0;
		for (int cs = 0; cs < arr.length - 1; cs++) {
			int item = arr[cs];
			int pos = cs;
			for (int i = cs + 1; i < arr.length; i++) {
				if (arr[i] <= item) {// for duplicate <= otherwise just <
					pos++;
				}

			}
			// swap item and arr[pos]
			int temp = item;
			item = arr[pos];
			arr[pos] = temp;
			swap++;

			System.out.println(swap + "swap after first stage cs:" + cs);

			while (pos != cs) {
				pos = cs;
				for (int i = cs + 1; i < arr.length; i++) {
					if (arr[i] < item) {
						pos++;
					}

				}

				// swap item and arr[pos]
				int temp2 = item;
				item = arr[pos];
				arr[pos] = temp2;
				swap++;
				System.out.println(swap + "swap after cs 0");

			}
		}
		System.out.println(swap + "swap");

	}

	// heap sort
	// step 1 build maxheap
	public static void buildheap(int arr[],int n) {
		for (int i = (n - 2) / 2; i >= 0; i--) {
			maxheap(arr,n,i);
		}
		//the above code finds the lastt internal node in the tree;
		//an internal node is a node which has childs;
	}

	// maxheap function
	public static void maxheap(int arr[], int n,int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if(left<n && arr[largest]<arr[left]){
			largest =left;
		}
		if(right<n && arr[largest]<arr[right]){
			largest =right;
		}
		//the above code finds the
		if(largest!=i){
			swap(arr, largest , i);
			maxheap(arr, n,largest);
		}

	}

	public static void heapsort(int arr[],int n){
		buildheap(arr,n);
		for(int i=n-1;i>=1;i--){
			swap(arr, 0, i);
			maxheap(arr,i,0);
		}

	}

	//naive counting sort
	public static void counting(int[] arr,int k){
		int count[]=new int[k];
		//count array with size of the range here k

		//initializing with all values 0;
		for(int i=0;i<k /*count.length */;i++){
			count[i]=0;
		}

		//increasing the value in count array signifying the no of occurrences

		for(int i=0;i<arr.length;i++){
			count[arr[i]]++;
		}

		int index=0;
		for(int i=0;i<k;i++){
			for(int j=0;j<count[i];j++){
				arr[index]=i;
				index++;
			}
		}

		//advance part
		for(int i=1;i<k;i++){
			count[i]=count[i]+count[i-1];
		}

		int output[]=new int[arr.length];
		for(int i=arr.length-1;i>=0;i--){
			output[count[arr[i]]-1]=arr[i];
			count[arr[i]]--;
		}
		for(int i=0;i<arr.length;i++){
			arr[i]=output[i];
		}

	}

	public static void radix(int arr[]){
		int mx=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>mx){
				mx=arr[i];
			}
		}
		for(int exp=1;mx/exp>0;exp=exp*10){
			countingsort(arr,exp);
		}
	}

	public static void countingsort(int arr[],int exp){
		int count[]=new int[10];
		int output[]=new int[arr.length];

		for(int i=0;i<10 /*count.length */;i++){
			count[i]=0;
		}



		for(int i=0;i<arr.length;i++){
			count[(arr[i]/exp)%10]++;
		}

		
		//advance part
		for(int i=1;i<10;i++){
			count[i]=count[i]+count[i-1];
		}

		for(int i=arr.length-1;i>=0;i--){
			output[count[(arr[i]/exp)%10]-1]=arr[i];
			count[(arr[i]/exp)%10]--;
		}
		for(int i=0;i<arr.length;i++){
			arr[i]=output[i];
		}

	}

	

	public static void main(String args[]) {
		// int arr[] = {12,11,13,5,6,7 };
		// merge sort

		// System.out.println("Given array is");
		// printArray(arr);

		// sort(arr, 0, arr.length - 1);

		// System.out.println("\nSorted array is");

		// countinversion

		// int a=countInversion(arr, 0, arr.length-1);
		// System.out.println(a);
		// int[] arr={5,13,6,9,12,11,8};
		// int l=0;
		// int h= arr.length-1;
		// int p=arr.length-1;
		// partition(arr,l,h,p);
		// for(int i:arr){
		// System.out.println(i);
		// }

		// out of all 3 partitions hoares,lomuto and naive only naive one is stable.
		// int arr[]={16,11,12,10,14,15};

		// lPartition(arr, l, h);
		// quickSort(arr,l,h);
		// int k = 4;
		// quick select

		// int x=kth(arr, k);

		// System.out.println(arr[x]);
		// chocolate problem
		// int arr[]={0,1,2,1,1,2};
		// for(int p:arr){
		// System.out.println(p);
		// }
		// int m=3;
		// int a=minDiff(arr,m);

		// segNum2(arr);

		// for(int i:arr){

		// System.out.println(i);
		// }

		// merge overlapping problem

		// Point arr[]={
		// new Point(5,10),new Point(3,15),new Point(18,30),new Point(2,7)
		// };
		// Arrays.sort(arr);
		// int res=0;
		// for(int i=1;i<arr.length;i++){

		// if(arr[res].y>=arr[i].x){
		// arr[res].y=Math.max(arr[i].y, arr[res].y);
		// arr[res].x=Math.min(arr[i].x, arr[res].x);
		// }
		// else{
		// res++;
		// arr[res]=arr[i];
		// }
		// }
		// for(int i=0;i<=res;i++){
		// System.out.println(arr[i].x+" "+arr[i].y);

		// }

		// //meeting maximum guest
		// int arr[]={900,600,700};
		// int dept[]={1000,800,730};
		// meetGuest(arr,dept);
		// int arr[] = { 20, 40, 50, 10, 30 };
		// cycleSort(arr);
		// for(int i:arr){
		// System.out.println(i);
		// }
		// int arr[] = { 10, 15, 50, 4, 20 };
		// int n=arr.length;
		// heapsort(arr,n);
		// for(int i=0;i<n;i++){
		// 	System.out.println(arr[i]);
		// }
		int arr[] = { 319,212,6,8,100,50};
		int k=5;
		radix(arr);
		for(int i:arr){
			System.out.println(i);
		}
		// for(int i:arr){
		// 	System.out.println(i);
		// }
		
	}
}
/* This code is contributed by Rajat Mishra */
