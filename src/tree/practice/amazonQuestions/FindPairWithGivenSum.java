package tree.practice.amazonQuestions;

import java.util.*;

public class FindPairWithGivenSum {

    /**
     * https://leetcode.com/discuss/interview-question/356960
     *
     * Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.
     *
     * Conditions:
     *
     * You will pick exactly 2 numbers.
     * You cannot pick the same element twice.
     * If you have multiple pairs, select the pair with the largest number.
     */

    private static int[] findPairSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        int[] result = new int[] {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (index.containsKey(temp)) {
                if(result[0] == -1 && result[1] == -1){
                    result[0] = index.get(temp);
                    result[1] = i;
                }
                else {
                    int current_max = Math.max(nums[result[0]], nums[result[1]]);
                    int new_max = Math.max(nums[i], temp);
                    if (new_max > current_max) {
                        result[0] = index.get(temp);
                        result[1] = i;
                    }
                }
            }
            index.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{20, 59, 1, 50, 40, 25, 30, 30, 10};

//        int[] nums = new int[]{30, 10, 50, 30};
        System.out.println("Result is: " + Arrays.toString(findPairSum(nums, 90-30)));

    }
}
