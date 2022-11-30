package array;

import java.util.Arrays;

public class KthMinMaxElementArray {

    static class Pair {
        int minElement;
        int maxElement;
    }

    public static void main(String[] args) {

        int[] arr1 = {1000, 11, 445, 15, 330, 3000};
        int k1 = 2;
        System.out.println(Arrays.toString(arr1));
        Pair minMax1 = sortingMethod(arr1, k1);
        System.out.println("Kth Smallest Element  " + minMax1.minElement);
        System.out.println("Kth Largest Element " + minMax1.maxElement);

        int[] arr2 = {1000, 11, 445, 15, 330, 3000};
        int k2 = 2;
        System.out.println(Arrays.toString(arr2));
        Pair minMax2 = minHeapMethod(arr2, k2);
        System.out.println("Kth Smallest Element  " + minMax2.minElement);
        System.out.println("Kth Largest Element " + minMax2.maxElement);

        int[] arr3 = {1000, 11, 445, 15, 330, 3000};
        int k3 = 2;
        System.out.println(Arrays.toString(arr3));
        Pair minMax3 = quickSelectMethod(arr3, k3);
        System.out.println("Kth Smallest Element  " + minMax3.minElement);
        System.out.println("Kth Largest Element " + minMax3.maxElement);

    }

    public static Pair sortingMethod(int[] arr, int k) {
        Pair minMax = new Pair();
        Arrays.sort(arr);

        minMax.minElement = arr[k - 1];
        minMax.maxElement = arr[arr.length - k];

        return minMax;
    }

    static class MinHeap {
        int[] heapArr;
        int heapSize;

        int parent(int i) {
            return ((i - 1) / 2);
        }

        int left(int i) {
            return ((2 * i) + 1);
        }

        int right(int i) {
            return ((2 * i) + 2);
        }

        int getMin() {
            return heapArr[0];
        }

        void replaceMax(int x) {
            this.heapArr[0] = x;
            minHeapify(0);
        }

        MinHeap(int[] a) {
            heapSize = a.length;
            heapArr = a;

            int i = (heapSize - 1) / 2;
            while (i >= 0) {
                minHeapify(i);
                i--;
            }
        }

        int extractMin() {

            if (heapSize == 0)
                return Integer.MAX_VALUE;

            int root = heapArr[0];

            if (heapSize > 1) {
                heapArr[0] = heapArr[heapArr.length - 1];
                minHeapify(0);
            }

            heapSize--;
            return root;
        }

        void minHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            if (l < heapSize && heapArr[l] < heapArr[i])
                smallest = l;
            if (r < heapSize && heapArr[r] < heapArr[smallest])
                smallest = r;

            if (smallest != i) {
                int temp = heapArr[i];
                heapArr[i] = heapArr[smallest];
                heapArr[smallest] = temp;
                minHeapify(smallest);
            }
        }

    }

    public static Pair minHeapMethod(int[] arr, int k) {

        int len = arr.length;
        Pair minMax = new Pair();
        MinHeap minHeap = new MinHeap(arr);

        for (int i = 0; i < k - 1; i++)
            minHeap.extractMin();
        minMax.minElement =  minHeap.getMin();

        for (int i = 0; i < len - k - 1; i++)
            minHeap.extractMin();

        minMax.maxElement = minHeap.getMin();
        return minMax;
    }

    public static Pair quickSelectMethod(int[] arr, int k){
        Pair minMax = new Pair();

        minMax.minElement = quickSelect(arr, 0, arr.length - 1, k - 1);
        minMax.maxElement = quickSelect(arr, 0 , arr.length - 1, arr.length - k);

        return minMax;
    }

    public static int quickSelect(int[] arr, int low, int high, int k){

        int pivot = arr[high];
        int pi = partition(arr, pivot, low, high);

        if (k > pi)
            return quickSelect(arr, pi + 1, high, k);
        else if (k < pi)
            return quickSelect(arr, low, pi - 1, k);
        else
            return arr[pi];
    }

    public static int partition(int[] arr, int pivot, int low, int high){
        int i = low, j = low;

        while(i <= high){
            if (arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }else
                i++;
        }
        return j - 1;
    }
}