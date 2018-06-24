package InterviewPractice;

public class Palindrome {

    //Given an Integer, reverse the numbers in it.
    static int reversedInt(int num){
        String number = Integer.toString(num);
        String reversedNumber = "";
        for(int i=number.length()-1; i>=0; i--){
            reversedNumber += number.charAt(i);
        }
        return Integer.valueOf(reversedNumber);

    }

    //Finds if a given Integer input is a Palindrome or not.
    static boolean isPalindrome(int num){
        String number = Integer.toString(num);
        for(int i=0; i<=number.length()/2; i++){
            if(number.charAt(i) != number.charAt(number.length()-i-1)){
                 return false;
            }
        }
        return true;
    }

    /* Given an initial number, reverse it and add back to initial. Check if new number if palindrome.
     If not repeat till it is, if yes display how many iterations it took and the number. */
    static int[] finder(int num){
        int[] answer = new int[2]; //Array to store the number of iteration and the Palindrome number.
        int result = num + reversedInt(num);
        int count = 1;
        if(isPalindrome(result)){
            answer[0] = result; //0th index contains the Palindrome number
            answer[1] = count; //1st index contains the number of times we had to do the iteration.
        }

        while(!isPalindrome(result)){
            result = result + reversedInt(result);
            count += 1;
            if(isPalindrome(result)){
                answer[0] = result;
                answer[1] = count;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int number = 48;

        System.out.println(isPalindrome(number));
        System.out.println(reversedInt(number));
        int[] result = finder(number);
        System.out.printf("The Palindrome number formed is %d and it took %d iterations",result[0],result[1]);
        System.out.println(" ");
        int[] max_iterations = new int[3];
        for(int i=1;i<50;i++){
            int[] new_result = finder(i);
            if(new_result[1] > max_iterations[1]){
                max_iterations[0] = new_result[0];
                max_iterations[1] = new_result[1];
                max_iterations[2] = i;
            }
        }
        System.out.printf("The Palindrome number formed is %d and it took %d iterations for the number %d",max_iterations[0],max_iterations[1],max_iterations[2]);


    }
}
