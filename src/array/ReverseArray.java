package array;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {

    public static void main(String[] args){
        int[] arr1 = {2, 1, 6, 3, 8, 7, 6};
        System.out.println("Original Array: "+ Arrays.toString(arr1));
        int[] newArr1 =reverseArray(arr1);
        System.out.println("Reversed Array: "+ Arrays.toString(newArr1));

        int[] arr2 = {2, 1, 6, 3, 8, 7, 6};
        System.out.println("Original Array: "+ Arrays.toString(arr2));
        reverseArrayRecursive(arr2, 0, arr2.length - 1);
        System.out.println("Reversed Array: "+ Arrays.toString(arr2));

        int[] arr3 = {2, 1, 6, 3, 8, 7, 6};
        System.out.println("Original Array: "+ Arrays.toString(arr3));
        int[] newArr3 =reverseArrayUsingStack(arr3);
        System.out.println("Reversed Array: "+ Arrays.toString(newArr3));
    }

    public static int[] reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static void reverseArrayRecursive(int[] arr, int start, int end){
        if(start >= end)
            return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArrayRecursive(arr, start + 1, end - 1);
    }

    public static int[] reverseArrayUsingStack(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for (int i : arr) {
            stack.push(i);
        }

        for (int i = 0; i < arr.length; i++){
            if (!stack.isEmpty())
                arr[i] = stack.pop();
        }

        return arr;
    }
}


