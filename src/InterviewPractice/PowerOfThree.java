package InterviewPractice;

public class PowerOfThree {
    public static boolean isPowerOfThree(int n){

        if(n == 1){
            return true;
        } else if(n== 0 || n%3 != 0){
            return false;
        }

        return isPowerOfThree(n/3);
    }

    public static void main(String[] args){
        int n = 0;
        System.out.println(isPowerOfThree(n));
    }
}
