package InterviewPractice;
import java.util.*;


public class ArmstrongNumber {

    //Function to find if the number is an Armstrong number.
    static boolean isArmstrong(int number){
        String num = Integer.toString(number); //Converting Integers to Strings
        int finalNumber = 0;
        for(int i=num.length()-1; i>=0;i--){  //This for loop can be both incremental or decremental
            int digit = Integer.valueOf(""+num.charAt(i)); //Converting Integers back to String.
            finalNumber += Math.pow(digit,3); //math.pow function for achieving exponent.
        }

        return finalNumber == number ? true: false;
    }

    //Finding Armstrong numbers in a given range i.e.999
    static List<Integer> armstrongNumbers(int range){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++){  //The number of loops increases as the range grows, so does the complexity.
            for(int j=0; j<10; j++){
                for(int k=0; k<10; k++){
                    int number = i * 100 + j*10 + k;
                    int cubicSum = (int) Math.pow(i,3) + (int) Math.pow(j,3) + (int) Math.pow(k,3);
                    if(number == cubicSum) list.add(cubicSum);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int number = 372;
        System.out.println(isArmstrong(number));

        List<Integer> answer = armstrongNumbers(999);
        for(Integer num: answer){
            System.out.print(num +" ");
        }
    }


}
