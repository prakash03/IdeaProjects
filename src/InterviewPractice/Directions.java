package InterviewPractice;

public class Directions {
    static String findDirection(int x1, int y1, int x2, int y2){
        //Finding direction of point 2 w.r.t point 1.

        String direction = "";
        direction = (y2 > y1) ? direction+"N" : (y2 == y1) ? direction+"" : direction+"S";
        direction = (x2 > x1) ? direction+"E" : (x2 == x1) ? direction+"" : direction+"W";

        return direction;
    }

    public static void main(String[] args) {
        /*
        (x1, y1) = (1,3);
        (x2, y2) = (0,3);
         */
        int x1 = 1;
        int y1 = 3;
        int x2 = 0;
        int y2 = 3;
        System.out.println(findDirection(x1,y1,x2,y2));
    }
}
