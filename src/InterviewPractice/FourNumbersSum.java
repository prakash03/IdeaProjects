package InterviewPractice;
import java.util.Arrays;

/*
Find the number of quadruplets from the given list of numbers that sum upto a given number.
 */
public class FourNumbersSum {
    static boolean twoSum(int nums[], int sum){
        //This helper method already has the input in sorted format, and doesn't require further sorting.
        for(int i=0,j=nums.length-1;i<j; ){
            if((nums[i] + nums[j]) == sum) return true;
            else if(nums[i] + nums[j] <sum) i++;
            else if(nums[i]+ nums[j] > sum) j--;

        }
        return false;
    }

    static int findNoOfPairs(int numbers[], int sum){
        int answer = 0;
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length-3; i++){
            for (int j=i+1; j<numbers.length-2; j++){
                int req_sum = sum - numbers[i] - numbers[j];
                int[] rem_array = Arrays.copyOfRange(numbers, j+1, numbers.length);
                if(twoSum(rem_array, req_sum)) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int sum = 0;
        int[] numbers = new int[]{1,-1,2,-3,3};
        int[] numbers1 = new int[]{3,-1,-3,0,2,5,7,9,-7,-5,10,-6,8};

        System.out.println(findNoOfPairs(numbers1,sum)); //O(n^3) Complexity.

    }
}
