package dynamic_progamming;
import java.util.*;

public class HouseRobber {
    /**
     * This is a leetcode problem found here : https://leetcode.com/problems/house-robber/
     *
     * Solution with description: https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
     */

    // [1,2,1,1]


    /**
     * This solution finds the maximum possible rob amount recursively.
     * @param nums
     * @return
     */
    static int robRecursively(int[] nums){
        return robRecursively(nums, 0);
    }

    static int robRecursively(int[] nums, int house_index){
        if(house_index > nums.length -1) return 0;

        return Math.max(nums[house_index] + robRecursively(nums, house_index+2 ), robRecursively(nums, house_index+1 ));
    }

    /**
     * This solution finds the rob amount recursively with some memoization.
     * @param
     */
    static int robRecursiveWithMemo(int[] nums){
        int[] memo = new int[nums.length];   // why does the solution consider new int[nums.length+1] instead?
        Arrays.fill(memo, -1);
        return robRecursiveWithMemo(nums, 0, memo);
    }

    static int robRecursiveWithMemo(int[] nums, int house_index, int[] memo){
        if(house_index > nums.length - 1) return 0;

        if(memo[house_index] > -1){
            return memo[house_index];
        }

        memo[house_index] = Math.max(nums[house_index] + robRecursiveWithMemo(nums, house_index+2, memo), robRecursiveWithMemo(nums, house_index+1, memo));

        return memo[house_index];
    }

    /**
     * This solution finds the rob amount iteratively
     * @param
     */
    static int robIteratively(int[] nums){
        int[] robAmountsAtEachHome = new int[nums.length +1];
        robAmountsAtEachHome[0] = 0;
        robAmountsAtEachHome[1] = nums[0];

        for(int i = 1; i < nums.length; i++){
            robAmountsAtEachHome[i+1] = Math.max((nums[i] + robAmountsAtEachHome[i-1]), robAmountsAtEachHome[i]);
        }

        return robAmountsAtEachHome[nums.length];
    }


    /**
     * This solution calculates Iteratively with space optimization
     * @param
     */
    static int robIterativelyWithLessSpace(int[] nums){
        if(nums.length == 0) return 0;

//        int[] robAmounts = new int[3];
//        robAmounts[0] = 0;
//        robAmounts[1] = nums[0];
        int max = nums[0];
        int a = 0;
        int b = nums[0];
        for(int i=1; i< nums.length; i++){
            max = Math.max(nums[i]+a, b);
            a = b;
            b = max;
        }
        return max;


//        for(int i = 1; i< nums.length; i++){
//            robAmounts[2] = Math.max((nums[i]+robAmounts[0]), robAmounts[1]);
//            robAmounts[0] = robAmounts[1];
//            robAmounts[1] = robAmounts[2];
//        }

//        return robAmounts[2];
    }


    public static void main(String[] args){
        int[] nums = new int[] {2,5,7,4,5,10,1};
        int[] nums_2 = new int[] {2,1,7,9};

        System.out.println(robRecursively(nums));

        System.out.println(robRecursiveWithMemo(nums));
        System.out.println(robIteratively(nums));
        System.out.println(robIterativelyWithLessSpace(nums));
//        System.out.println(robIterativelyWithLessSpace(nums));
    }
}
