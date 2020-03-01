package Arrays.Practice;

public class FindOccurences {

    /**
     * No reference question for this one.
     *
     * Question:
     *      Given a sorted array of integers containing duplicates, find the number of occurences of given element.
     *
     * Example:
     *
     * input: [1,2,3,7, 9,10,11, 12,15,15,15,16]
     *
     * target: 15
     *
     * output: 3
     *
     */

    /*
    [1,2,3,7, 9,10,11, 12,15,15,15,16]

                          8      10

      [2,3,4,4,6]
      [   ] [   ] occurence  = 2
      findFirst(left) --> 0 if there is no element or a index of the first
      findLast(right) --> 0 if there is no element or a index of the last

      [2,3,4,4,5,5,6] 5
      4 < 5 binarySearch in [5,5,6]

        mid = (start+end)/2 == 5
        occurence = 5
        findFirst(left)
        findLast(right)


     */

    static int findLastOccurence(int[] nums, int target, int start, int end){
        if(start > end) return 0;
        if(start == end){
            return (nums[start] == target) ? start : 0;
        }

        int mid = (start+end)/2;

        if(nums[mid] == target){
            if(mid == nums.length-1 || nums[mid+1] > target){
                return mid;
            }
        } else if(nums[mid] > target){
            findLastOccurence(nums, target, start, mid-1);
        }
        return findLastOccurence(nums, target, mid+1, end);
    }


    static int findFirstOccurence(int[] nums, int target, int start, int end){
        if(start > end) return 0;
        if(start == end){
            return (nums[start] == target) ? start : 0;
        }

        int mid = (start+end)/2;

        if(nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] < target) { //can the mid-1 here cause  A problem when mid itself is 0?
                return mid;
            }
        } else if(nums[mid] < target){
            return findFirstOccurence(nums, target, mid+1, end);
        }
        return findFirstOccurence(nums, target, start, mid-1);
    }

    static int findOccurences(int[] nums, int target, int start, int end){
        if(start> end) return 0;
        if(start == end) return (nums[start] == target) ? 1 : 0;
        int mid = (start+end)/2;

        if(nums[mid] == target){
            //handle left condition in base case

            int occurence = mid;
            int first_occurence = findFirstOccurence(nums, target, start, mid-1);
            int last_occurence = findLastOccurence(nums, target, mid+1, end);

//            System.out.println("first occur: "+ first_occurence);
//            System.out.println("last occur:" +  last_occurence);
            if(first_occurence != 0 && last_occurence != 0) {
                return last_occurence + 1 - first_occurence;
            } else if(first_occurence != 0){
                return occurence+1 - first_occurence;
            } else if(last_occurence != 0){
                return last_occurence+1 - occurence;
            } else return 1;

        }
        else if(nums[mid] > target){
            return findOccurences(nums, target, start, mid-1);
        }
        else return findOccurences(nums, target, mid+1, end);
    }

    static int findOccurences(int[] nums, int target){

        return findOccurences(nums, target, 0, nums.length-1);
    }

    public static void main(String[] args){
        int[] input = new int[] {1,2,3,7, 9,10,11, 12,15,15,15,16,16};
        int target = 15;

        System.out.println(findOccurences(input, 1));

//        int[] input2 = new int[] {2,3,4,4,5};
//        System.out.println(findOccurences(input2, 2));
//        System.out.println(findLastOccurence(input, 15, 0, input.length-1));
//        System.out.println(findFirstOccurence(input, 15, 0, input.length-1));
//        System.out.println(findLastOccurence(input, 15, 0, input.length-1) - findFirstOccurence(input, 15, 0, input.length-1));

    }
}
