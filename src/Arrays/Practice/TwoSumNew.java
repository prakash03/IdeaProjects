package Arrays.Practice;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSumNew {
    static int[] findUsingHash(int[] numbers, int target) {
        int[] answer = new int[2];

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++) {
            if(set.contains(target - numbers[i])){
                answer[0] = numbers[i];
                answer[1] = target - numbers[i];
                return answer;
            } else set.add(numbers[i]);
        }
        return answer;
    }

    static int[] findTheTwoNumbers(int[] numbers, int target) {
        int[] answer = new int[2];

        for(int i = 0,  j = numbers.length - 1; i < j;) {
            if(numbers[i] + numbers[j] == target) {
                answer[0] = numbers[i];
                answer[1] = numbers[j];
                return answer;
            } else if(numbers[i] + numbers[j] < target) {
                i++;
            } else if(numbers[i] + numbers[j] > target) {
                j--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 8, 10, 12, 15};
        System.out.println("For a sorted array");
        System.out.println(Arrays.toString(findTheTwoNumbers(numbers, 19)));

        int[] unsortedNumbers = {45, 12, 32, 40, 7, 5, 9, 1, 2, 0, 21, 16};
        System.out.println("For an unsorted array:");
        System.out.println(Arrays.toString(findUsingHash(numbers, 56)));

    }
}
