package InterviewPractice;
import java.io.BufferedReader;
import java.io.FileReader;

/*
Given 3 coins of value 1,3, 5. Also given a total to arrive at. Find the number of coins to arrive at it.
 */
public class Coins {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader("src/coins.txt"));
        String line;
        while((line = br.readLine()) != null){
            int total = Integer.valueOf(line);
            System.out.println("For the given total "+ total + " we need:");
            int numberOfFives = total/5;
            total = total%5;
            int numberOfThrees = total/3;
            total = total%3;
            int numberOfOnes = total;
            System.out.println(numberOfFives + " 5's, " + numberOfThrees + " 3's, " + numberOfOnes + " 1's");
        }
//        int total = 43;
//        System.out.println("Total is :"+ total);
//        int fives = 0;
//
//        while(total-5 >= 0){
//            total = total-5;
//            fives += 1;
//        }
//
//        int threes = 0;
//        while(total -3 >= 0){
//            total = total-3;
//            threes += 1;
//        }
//
//        int ones = total;
//        System.out.printf("Number of coins required is %d ones %d threes and %d fives",ones, threes, fives);

    }
}
