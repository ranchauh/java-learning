package data.structures.array;

/**
 * Find element which appears once in the sorted array.
 * Input: {1,1,2,2,3,3,4,5,5}
 * Output: 4
 */
public class FindOnceAppearingElement {

    public static int findOnceAppearingElement(int array[]){
        if(array.length == 0){
            return -1;
        }
        if(array.length == 1){
            return array[0];
        }
        int i;
        for(i=0; i<array.length-1; i = i+2){
            if(array[i] != array[i+1]){
                return array[i];
            }
        }
        return array[i];

    }

    public static int findOnceAppearingElementXOR(int array[]){
        int xor = array[0];

        for(int i=1; i<array.length; i++){
            xor ^= array[i];
        }

        return xor;
    }

    public static int findOnceAppearingElementBinarySearch(int array[]){
        int start = 0;
        int end = array.length - 1;
        while (start <= end){
            int mid = (start+end)/2;
            if(start==end){
                return array[start];
            }else if(mid % 2 != 0) { // If mid id odd
                if(array[mid] == array[mid-1]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }else { // mid is even
                if(array[mid] == array[mid + 1]){
                    start = mid + 2;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {1,1,2,2,3,3,4,5,5};
        System.out.println(findOnceAppearingElement(array));
        System.out.println(findOnceAppearingElementXOR(array));
        System.out.println(findOnceAppearingElementBinarySearch(array));
    }

}
