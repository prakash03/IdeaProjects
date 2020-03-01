package InterviewPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

//    LeetCode Problem: 239, https://leetcode.com/problems/sliding-window-maximum/
//

    int maxInArray(int[] subArray){

        int max = Integer.MIN_VALUE;
        for(int num : subArray){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    int maxInArrayUsingPriorityQueue(int[] subArray){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((x, y) -> y - x);

        for(int num : subArray){
            pQueue.add(num);  //Initialized with Integer but adding an int works just fine
        }

        return pQueue.poll();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> maxList = new ArrayList<>();
        for(int i = 0; i <= nums.length - k; i++){
            int[] subArray = Arrays.copyOfRange(nums, i, i+k);
            if(subArray.length > 0) {

//                maxList.add(maxInArray(subArray));
                maxList.add(maxInArrayUsingPriorityQueue(subArray));

            }
        }

        return maxList.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args){
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(swm.maxSlidingWindow(nums, k)));
    }
}
