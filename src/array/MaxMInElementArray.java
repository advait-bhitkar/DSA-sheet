package array;

import java.util.Arrays;

public class MaxMInElementArray {

    public static void main(String[] args){
        int[] arr1 = {1000, 11, 445, 15, 330, 3000};
        Pair minMax1 = minMaxElement(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Minimum Element : " + minMax1.min);
        System.out.println("Maximun Element : " + minMax1.max);

        int[] arr2 = {1000, 11, 445, 15, 330, 3000};
        Pair minmax2 = minMaxTournament(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        System.out.println("Minimum Element : " + minmax2.min);
        System.out.println("Maximun Element : " + minmax2.max);

        int[] arr3 = {1000, 4000, 445, 15, 330, 3000};
        Pair minmax3 = minMaxComparePairs(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println("Minimum Element : " + minmax3.min);
        System.out.println("Maximun Element : " + minmax3.max);
    }

    static class Pair{
        int max;
        int min;
    }

    public static Pair minMaxElement(int[] arr){
        Pair minMax = new Pair();
        int n = arr.length;

        if (n == 1){
            minMax.min = arr[0];
            minMax.max = arr[0];
            return minMax;
        }

        if (arr[0] > arr[1]){
            minMax.min = arr[1];
            minMax.max = arr[0];
        }else {
            minMax.min = arr[0];
            minMax.max = arr[1];
        }

        for(int i=2; i < n; i++){
            if (arr[i] < minMax.min)
                minMax.min = arr[i];
            else if (arr[i] > minMax.max)
                minMax.max = arr[i];
        }
        return minMax;
    }

    public static Pair minMaxTournament(int[] arr, int low, int high){
        Pair minMax = new Pair();
        Pair minMaxLeft;
        Pair minMaxRight;

        if(low == high){
            minMax.min = arr[low];
            minMax.max = arr[low];
            return minMax;
        }

        if (high == low + 1){
            if (arr[low] > arr[low]){
                minMax.min = arr[high];
                minMax.max = arr[low];
            }
            else {
                minMax.min = arr[low];
                minMax.max = arr[high];
            }
            return minMax;
        }

        int mid = low + (high - low)/2;
        minMaxLeft = minMaxTournament(arr, low, mid);
        minMaxRight = minMaxTournament(arr, mid, high);

        minMax.min = Math.min(minMaxLeft.min, minMaxRight.min);
        minMax.max = Math.max(minMaxLeft.max, minMaxRight.max);

        return minMax;
    }

    public static Pair minMaxComparePairs(int[] arr){
        Pair minMax = new Pair();
        int n = arr.length;
        int i;

        if(n % 2 == 0){
            if (arr[0] > arr[1]){
                minMax.min = arr[1];
                minMax.max = arr[0];
            }else {
                minMax.min = arr[0];
                minMax.max = arr[1];
            }
            i = 2;
        }else {
            minMax.min = arr[0];
            minMax.max = arr[0];
            i = 1;
        }

        while (i <= n-1){
            if (arr[i] > arr[i + 1]){
                if (arr[i] > minMax.max)
                    minMax.max = arr[i];
                if(arr[i+1] < minMax.min)
                    minMax.min = arr[i + 1];
            }else {
                if (arr[i] < minMax.min)
                    minMax.min = arr[i];
                if (arr[i + 1] > minMax.max)
                    minMax.max = arr[i + 1];
            }
            i += 2;
        }
        return minMax;
    }
}
