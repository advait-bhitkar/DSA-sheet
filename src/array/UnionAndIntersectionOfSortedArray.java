package array;

public class UnionAndIntersectionOfSortedArray {

    public static void main(String[] args){

        int[] arr1 = { 1, 1, 1, 2, 4, 5, 6 };
        int[] arr2 = { 2, 2, 3, 3, 5, 7 };

        System.out.println("Union : ");
        printUnion(arr1, arr2);
        System.out.println("\nIntersection : ");
        printIntersection(arr1, arr2);
    }

    public static void printUnion(int[] arr1, int[] arr2){

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length){
            while (i < arr1.length - 2 && arr1[i] == arr1[i + 1]){
                i++;
            }
            while (j < arr2.length - 2 && arr2[j] == arr2[j + 1]) {
                j++;
            }
            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i++]  + " ");
            }
            else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j++]  + " ");
            }
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }

        while (i < arr1.length)
            System.out.print(arr1[i++] + " ");

        while (j < arr2.length)
            System.out.print(arr2[j++] + " ");

    }

    public static void printIntersection(int[] arr1, int[] arr2){


        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length){
            while (i < arr1.length - 2 && arr1[i] == arr1[i + 1]){
                i++;
            }
            while (j < arr2.length - 2 && arr2[j] == arr2[j + 1]) {
                j++;
            }

            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else if (arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
            }
        }
    }
}
