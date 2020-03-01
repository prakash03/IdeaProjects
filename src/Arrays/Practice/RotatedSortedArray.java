package Arrays.Practice;

public class RotatedSortedArray {

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/ // TODO
     *
     * Given a sorted array that is rotated at some pivot find a target element in the array in O(logn) time.
     */

    static int findIndex(int[] inputArr, int target, int start, int end){

        while(start <= end){
            if(start==end) return (inputArr[start] == target) ? start : -1;
            if(start+1 == end){
                if(inputArr[start] == target) return start;
                if(inputArr[end] == target) return end;
                return -1;
            }

            int mid = (start +end )/2;
            if(inputArr[mid] == target) return mid;
            if(inputArr[mid+1] < inputArr[end]) {
                if (target >= inputArr[mid+1] && target <= inputArr[end]) {
                  start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if (target >= inputArr[start] && target <= inputArr[mid-1]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    static int findIndex(int[] inputArr, int target){
        return findIndex(inputArr, target, 0, inputArr.length-1);
    }

    public static void main(String[] args){
        int[] input = new int[]{1,3};
        int target = 2;

        System.out.println(findIndex(input, target));
    }
}
