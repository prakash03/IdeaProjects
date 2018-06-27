package InterviewPractice;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Directions2 {

    static String findDirection(int x1,int y1, int x2, int y2){
        String direction = "";
        direction = (y2 > y1) ? direction+"N" : (y2 == y1) ? direction+"" : direction+"S";
        direction = (x2 > x1) ? direction+"E" : (x2 == x1) ? direction+"" : direction+"W";
        return direction;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/directions.txt"));
        String line;
        while((line = br.readLine()) != null){
            System.out.println("Points are: " + line);
            Pattern pattern = Pattern.compile("-?\\d+");
            Matcher matcher = pattern.matcher(line);

            int[] coord = new int[4];
            int i = 0;
            while(matcher.find()){
                coord[i] = Integer.valueOf(matcher.group());
                i++;
            }

            int x1 = coord[0];
            int y1 = coord[1];
            int x2 = coord[2];
            int y2 = coord[3];

            System.out.println("Position of 2 wrt 1 is: " + findDirection(x1,y1,x2,y2));
        }
    }
}
