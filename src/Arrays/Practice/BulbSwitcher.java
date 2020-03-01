package Arrays.Practice;

import java.util.Arrays;

public class BulbSwitcher {
    //    BulbSwitcher problem leetcode problem number: 319

    static int countNumberOfBulbsSwitchedOn(boolean[] bulbs){
        int count = 0;
        for(int i=0; i < bulbs.length; i++){
            if(bulbs[i] ==  true) {
                count++;
            }
        }
        return count;
    }

    public static int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];

        for(int round = 1; round <= n; round++){
            for(int i = round-1; i < bulbs.length; i = i+round){

                if(bulbs[i] == true){
                    bulbs[i] = false;
                }
                else bulbs[i] = true;
            }
            round++;
        }

//        System.out.println(Arrays.toString(bulbs));
        return countNumberOfBulbsSwitchedOn(bulbs);
    }

    public static void main(String[] args){
        System.out.println(bulbSwitch(9999999));
    }

}
