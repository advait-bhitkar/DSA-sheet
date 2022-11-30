package array;

public class KadaneAlgorithm {

    public static void main(String[] args){

        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maximumContiguousSubArraySum(arr1));
        System.out.println(kadaneAlgo(arr1));

    }

    public static int maximumContiguousSubArraySum(int[] arr){
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            int sum = 0;
            for (int j = i; j < arr.length; j++){
                sum += arr[j];
                if (sum > largest)
                    largest = sum;
            }
        }
        return largest;
    }

    public static int kadaneAlgo(int[] arr){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingAtIndex = 0;

        for (int i : arr) {
            maxEndingAtIndex += i;

            if (maxSoFar < maxEndingAtIndex)
                maxSoFar = maxEndingAtIndex;

            if (maxEndingAtIndex < 0)
                maxEndingAtIndex = 0;
        }
        return maxSoFar;
    }

}
