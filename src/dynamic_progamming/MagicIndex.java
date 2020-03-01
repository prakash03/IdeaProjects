package dynamic_progamming;

import java.util.Arrays;

public class MagicIndex {

    /*
    This is a problem from CtCI book - DP chapter - Problem 8.3

    A magic index in array A[0..n] is an index where A[i] == i.
        1. Given a sorted array of distinct integers, write a method to find if a magic index exists.
        2. Followup: If the array values are not distinct. Find if a magic index exists.
     */

    /*
     When the elements are not distinct:
          0,  1, 2, 3, 4, 5
        [-2, -1, 0, 4, 4, 4]
        [ 0,  0, 3, 4, 4, 4]
        [      , 1, 3, 6, 6]
     */
    static boolean findMagicIndexInNonDistinctArray(int[] numbers){
        return findMagicIndexInNonDistinctArray(numbers, 0, numbers.length-1);
    }

    static boolean findMagicIndexInNonDistinctArray(int[] numbers, int start, int end){

        if(start<  0 || end < 0 || start > end) { return false;}
        if(start == end) { return numbers[start]  == start;}
        int mid_element = (start + end)/2;

        if(mid_element == numbers[mid_element]){
            return true;
        }
        else if(numbers[mid_element] < mid_element){
            return findMagicIndexInNonDistinctArray(numbers, mid_element+1, end) ||
                    findMagicIndexInNonDistinctArray(numbers, start, Math.min(mid_element-1, numbers[mid_element]));
        }
        else return findMagicIndexInNonDistinctArray(numbers, start, mid_element-1) ||
                    findMagicIndexInNonDistinctArray(numbers, Math.max(numbers[mid_element], mid_element+1), end);
    }

    // This method assumes that the elements in input `numbers` are all distinct.
    //
    // Time Complexity: O(log(n))
    // Space complexity: O(log(n)) --> ????
    static boolean findIfMagicIndexExists(int[] numbers, int start, int end){
        int mid_index = (start + end)/2;



        if(start == end) { return numbers[start] == start; }

        if(numbers[mid_index] == mid_index){
            return true;
        }
        else if(numbers[mid_index] > mid_index){
            return findIfMagicIndexExists(numbers, start, mid_index-1);
        }
        else{
            return findIfMagicIndexExists(numbers, mid_index+1, end);
        }
    }

    static boolean findIfMagicIndexExists(int[] numbers){
        return findIfMagicIndexExists(numbers, 0, numbers.length-1);
    }

    public static void main(String[] args){
        int[] numbers = new int[] {-20, -1, 0, 2, 4, 6, 9};
        System.out.println(findIfMagicIndexExists(numbers));

        int[] non_distinct_numbers = new int[] {-1,0,3,4,6,7,7,8,9};
        System.out.println(findMagicIndexInNonDistinctArray(non_distinct_numbers));

        int[] non_distinct_numbers_2 = new int[] {-1, 0, 3,4, 1000, 1001, 1002, 1002, 1005};
        System.out.println(findMagicIndexInNonDistinctArray(non_distinct_numbers_2));
    }
}
