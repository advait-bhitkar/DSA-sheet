package array;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args){

        int[] arr1 = {0, 1, 0, 1, 2, 1, 0, 0, 1, 2};
        System.out.println(Arrays.toString(arr1));
        System.out.println("Sorted Array: " + Arrays.toString(countingMethod(arr1)));

        int[] arr2 = {0, 1, 0, 1, 2, 1, 0, 0, 1, 2};
        System.out.println(Arrays.toString(arr2));
        System.out.println("Sorted Array: " + Arrays.toString(dutchNationalFlagMethod(arr2)));
    }

    public static int[] countingMethod(int[] arr){
        int zeroCount = 0, oneCount = 0, twoCount = 0;

        for (int i : arr) {
            if (i == 0)
                zeroCount++;
            else if (i == 1)
                oneCount++;
            else if (i == 2)
                twoCount++;
        }

        int i = 0;

        while (zeroCount != 0){
            arr[i] = 0;
            zeroCount--;
            i++;
        }
        while (oneCount != 0){
            arr[i] = 1;
            oneCount--;
            i++;
        }
        while (twoCount != 0){
            arr[i] = 2;
            twoCount--;
            i++;
        }

        return arr;
    }

    public static int[] dutchNationalFlagMethod(int[] arr){
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high){
            if (arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            }
            else if (arr[mid] == 1){
                mid++;
            }
            else if (arr[mid] == 2){
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
            }
        }

        return arr;
    }
}
