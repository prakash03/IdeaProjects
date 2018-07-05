package InterviewPractice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/*
A sequence of n > 0 integers is called a jolly jumper if the absolute values of the difference between
successive elements take on all the values 1 through n-1. For instance,
1 4 2 3
is a jolly jumper, because the absolutes differences are 3, 2, and 1 respectively.
The definition implies that any sequence of a single integer is a jolly jumper.
You are to write a program to determine whether or not each of a number of sequences is a jolly jumper.
*/

public class JollyJumper {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("src/jumperFile.txt"));
        String line;
        while((line = br.readLine()) != null){
            System.out.print(line + " - ");

            /*
            For each line read, calculate the absolute differences b/w successive numbers and save them in a HashSet.
            While doing this also keep track of the largest difference between successive numbers.
             */
            Set<Integer> set = new HashSet<>();
            String[] numbers = line.trim().split(" ");

            int max_difference = 0;
            for(int i=0; i<numbers.length-1; i++){
                int diff = Math.abs(Integer.valueOf(numbers[i]) - Integer.valueOf(numbers[i+1]));
                set.add(diff);
                if(diff > max_difference){
                    max_difference = diff;
                }
            }

            /*
            Iterate from 1 to the (max_difference-1), and find if all the consecutive numbers exist in the Set.
            If each of the numbers exist, then print "Jolly".
             */
            for(int i=1; i<max_difference; i++ ){
                if(!set.contains(i)){
                    System.out.println("Not Jolly");
                    break;
                }
                else if(set.contains(i) && i== max_difference-1){
                    System.out.println("Jolly");
                }
                set.remove(i);
            }
        }
    }
}
