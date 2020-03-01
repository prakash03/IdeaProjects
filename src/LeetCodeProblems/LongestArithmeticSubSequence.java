package LeetCodeProblems;

import java.util.*;

public class LongestArithmeticSubSequence {
//    Problem: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

    private class SsNumber{
        int num;
        int index;
        private SsNumber(int num, int index){
            this.num = num;
            this.index = index;
        }
    }

    private int findLongestSubSequence(List<SsNumber[]> numbersWithDifference){
        int maxLength = 0;
        int i = 0;


        while(i < numbersWithDifference.size() - 1){
            int j = i + 1;
            List<SsNumber> subSequence = new ArrayList<>();
            SsNumber[] current = numbersWithDifference.get(i);
//            System.out.println("current is :" + current[0].num + " and " + current[1].num);
            subSequence.add(current[0]);
            subSequence.add(current[1]);
//            System.out.println("In here: " + subSequence.size());
            while(j < numbersWithDifference.size()){

//                System.out.println("Current is : " + current[0].num + " and " + current[1].num + " and indexes are " + current[0].index + " and " + current[1].index);
//                System.out.println("jth element indexes are : " + numbersWithDifference.get(j)[0].index + " and " + numbersWithDifference.get(j)[1].index );
                if(numbersWithDifference.get(j)[0].index == current[1].index){
                    subSequence.add(numbersWithDifference.get(j)[1]);
                    current = numbersWithDifference.get(j);
                    j++;
                    System.out.println("Current gets updated to : " + current[0].num + " and " + current[1].num);
                }
                else j++;
            }
            for(SsNumber num : subSequence){
                System.out.println(num.num + "and the index " + num.index);
            }
//            System.out.println("----------------------");
            maxLength = subSequence.size() > maxLength ? subSequence.size() : maxLength;
            i++;
        }
        return maxLength;
    }

    public int longestSubsequence(int[] arr, int difference) {
        List<SsNumber[]> numbersWithDifference = new ArrayList<>();

        for(int i = 0; i < arr.length-1 ; i++){
            for(int j = i +1; j< arr.length; j++){
                if(arr[j] - arr[i] == difference){
//                    System.out.println("Numbers are:" + arr[i] + "and" +  arr[j]);
                    SsNumber[] numbers = new SsNumber[] {new SsNumber(arr[i], i), new SsNumber(arr[j], j)};
                    numbersWithDifference.add(numbers);
                }
            }
        }

//        System.out.println("Number of pairs:" + numbersWithDifference.size());
        if(numbersWithDifference.size() == 0){
            return 1;
        } else if((numbersWithDifference.size() == 1)) return 2;

        return findLongestSubSequence(numbersWithDifference);
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1,5,7,8,5,3,4,2,1,-1,0,-3};
        int diff = -2;

        int[] arr2 = new int[] {1,2,3,4};

        int[] arr3 = new int[] {3,4,-3,-2,-4};

        LongestArithmeticSubSequence lass = new LongestArithmeticSubSequence();
//        System.out.println(lass.longestSubsequence(arr, diff));
//
//        System.out.println((lass.longestSubsequence(arr2, 5)));

        System.out.println(lass.longestSubsequence(arr3, -5));
    }
}
