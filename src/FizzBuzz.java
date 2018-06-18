import java.util.*;

/*
Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
    static List<String> solution(Integer n){
        List<String> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            String value = (i%3 == 0 && i%5 == 0) ? "FizzBuzz" : (i%3 == 0) ? "Fizz" : (i%5 == 0) ? "Buzz" : Integer.toString(i);
            list.add(value);
        }
        return list;
    }

    //without using % operator
    static List<String> diffSolution(Integer n){
        List<String> list = new ArrayList<>();
        for(int i=1, fizz=0, buzz=0; i<=n; i++){
            fizz++;
            buzz++;
            if(fizz == 3 && buzz ==5){
                list.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }
            else if(fizz ==3){
                list.add("Fizz");
                fizz = 0;
            }
            else if(buzz ==5){
                list.add("Buzz");
                buzz=0;
            }
            else list.add(Integer.toString(i));
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println("Enter the range:");
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        List<String> answer = diffSolution(input);
        System.out.println(answer.toString());
    }
}

