package Arrays;

import java.util.*;


public class TwoSum {

    static int[] bruteForce(int[] array, int target){ ///O(n^2) solution brute force approach.
        int[] answer = new int[2];
        for(int i=0; i<array.length-1; i++){
            int req = target - array[i];
            for(int j=i+1; j<array.length; j++){
                if(array[j] == req){
                    answer[0] = array[i];
                    answer[1] = array[j];
                    return answer;
                }
            }
        }
        return answer;
    }

    static int[] finderUsingHash(int[] array, int target){ //O(n) solution
        int answer[] = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i= 0; i<array.length; i++){
            if(set.contains(target-array[i])){
                answer[0] = array[i];
                answer[1] = target-array[i];
                return answer;
            }
            set.add(array[i]);
        }
        return answer;
    }

    static int[] finderUsingPointer(int[] array, int target){
        int[] answer = new int[2];
        Arrays.sort(array); //Void return type for the Arrays sort method!!!
        int i=0;
        int j = array.length-1;
        while(i <= j){
            if(target == array[i]+array[j]){
                answer[0] = array[i];
                answer[1] = array[j];
                return answer;
            }
            else if(target < array[i]+array[j]){
                j = j-1;
            }
            else if(target > array[i]+array[j]){
                i = i+1;
            }
        }
        return answer;
    }

    static int[] threeSum(int[] array, int target){ //O(n^2) solution.
        int[] answer = new int[3];
        for(int i=0; i<array.length; i++){
            int[] twoNumbers = finderUsingHash(Arrays.copyOfRange(array, i, array.length), target-array[i]);
            if(twoNumbers[0] !=0 && twoNumbers[1]!=0){
                answer[0] = array[i];
                answer[1] = twoNumbers[0];
                answer[2] = twoNumbers[1];
                return answer;
            }
        }
        return answer;
    }

    //Yet to Complete this functionality.
    static int[] findSumUsingRecursion(int[] array, int target, int reqNumbers){
        int[] answer = new int[reqNumbers];
        if(reqNumbers == 2){
            answer = finderUsingHash(array, target);
        }
        else{
            for(int i=0; i<array.length; i++){
                answer[0] = array[i];
                findSumUsingRecursion(Arrays.copyOfRange(array, i+1, array.length), target-array[i], reqNumbers-1);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        int[] array =  {1,4,6,8,3,7,5};
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the target number: ");
        int target = in.nextInt();
        int[] answer1 = bruteForce(array, target);
        int[]  answer2 = finderUsingHash(array, target);
        int[] answer3 = finderUsingPointer(array, target);
        System.out.println("The required pair: "+ Arrays.toString(answer1) +" "+ Arrays.toString(answer2)+ " "+ Arrays.toString(answer3) );
        int[] answer4 = threeSum(array,target);
        System.out.println("Three sum answer: " + Arrays.toString(answer4));
    }
}
