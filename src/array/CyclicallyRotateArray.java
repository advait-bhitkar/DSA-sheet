package array;

import java.util.Arrays;

public class CyclicallyRotateArray {

    public static void main(String[] args){

//        Input:  arr[] = {1, 2, 3, 4, 5}
//        Output: arr[] = {5, 1, 2, 3, 4}

        int[] arr1 = {22, 33, 45, 27, 65, 87, 55};
        System.out.println(Arrays.toString(arr1));
        rotateArrayByOne(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {22, 33, 45, 27, 65, 87, 55};
        System.out.println(Arrays.toString(arr2));
        rotateArrayUsingTwoPointers(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    public static void rotateArrayByOne(int[] arr){

        int temp = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    public static void rotateArrayUsingTwoPointers(int[] arr){

        int i = 0, j = arr.length - 1;

        while (i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }
}
