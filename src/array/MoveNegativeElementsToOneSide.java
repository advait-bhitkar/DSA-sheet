package array;

import java.util.Arrays;

public class MoveNegativeElementsToOneSide {

    public static void main(String[] args){

        int[] arr1 = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr1));
        moveNegativeToStart(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr2));
        dnfMethod(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void moveNegativeToStart(int[] arr){

        int left = 0, right = arr.length - 1;

        while (left < right){
            if (arr[left] < 0 && arr[right] < 0)
                left++;
            else if (arr[left] > 0 && arr[right] < 0){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }else if (arr[left] > 0 && arr[right] > 0)
                right++;
            else {
                left++;
                right--;
            }
        }
    }

    public static void dnfMethod(int[] arr){
        int low = 0, high = arr.length - 1;

        while (low < high){
            if (arr[low] <=0)
                low++;
            else{
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
