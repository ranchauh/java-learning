package data.structures.array;

/**
 * Find the minimum size sub array in a given array whose sum is greater than or
 * equal to a given number k.
 * Example: array = {1,1,2,3,4,5} and k=9
 * Answer: {4,5}
 *
 */
public class MinimumSizeSubArray {


    /**
     * Create all sub-arrays of the given array and keep track of the array size having sum
     * greater than or equal to k.
     */
    public static int findMinimumSizeSubArrayBruteForce(int array[], int k) {
        int minLength = Integer.MAX_VALUE;
        int sum;

        for(int i=0; i<array.length; i++){
            sum = 0;
            for(int j=i; j<array.length; j++){
                sum += array[j];

                if(sum >= k){
                    minLength = Math.min(minLength, j-i+1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * Use two pointers start and end starting from index 0.
     * Maintain the sum of elements from start till end index.
     * Increase end pointer until the sum is greater than or equal to k.
     * Once the sum is greater than or equal to k, move the start pointer and reduce the value at start index from the sum
     * until the sum becomes less than k and start is less than end.
     */
    public static int findMinimumSizeSubArrayOptimized(int array[], int k){
        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int end=0; end < array.length; end++){
            sum += array[end];
            while(sum >= k && start <= end){
                minLength = Math.min(minLength, end-start+1);
                sum -= array[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int array[] = {1,1,2,3,4,5};
        System.out.println(findMinimumSizeSubArrayBruteForce(array,9));
        System.out.println(findMinimumSizeSubArrayOptimized(array,9));
    }
}
