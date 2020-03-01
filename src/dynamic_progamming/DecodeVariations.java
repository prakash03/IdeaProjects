package dynamic_progamming;

import org.w3c.dom.ls.LSOutput;

public class DecodeVariations {
    /**
     * A letter can be encoded to a number in the following way:
     *              'A' -> '1', 'B' -> '2', 'C' -> '3', ..., 'Z' -> '26'
     *
     *  A message is a string of uppercase letters, and it is encoded first using this scheme. For example, 'AZB' -> '1262'
     *  Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.
     *
     *  Example:
     *      input:  S = '1262'
     *      output: 3
     *      explanation: There are 3 messages that encode to '1262': 'AZB', 'ABFB', and 'LFB'.
     *
     *  Constraints:
     *
     *      [time limit] 5000ms
     *
     *      [input] string S
     *              1≤ S.length ≤ 12
     *      [output] integer
     *
     */

    /*
    25603
    10, 20 acceptable

    0^[1-9] --> not acceptable

    s = 1262
    0 +         fun('1', 1, s) + fun("12", 2, s)
                  /
             fun('12

     */

    static int decodeVariations(String sub_string, int index, String s){

        if(index > s.length()-1) return 0;

        if(index == s.length()-1){
            if(Integer.valueOf(sub_string) < 27 && Integer.valueOf(sub_string) > 0) {
                return 1;
            }
            else return 0;
        }



        return decodeVariations(("" + s.charAt(index)), index +1, s) + decodeVariations(("" + s.charAt(index) + s.charAt(index+1)), index +2, s);
    }

    static int decodeVariations(String s){
        return decodeVariations("", 0, s);
    }

    public static void main(String[] args){
        System.out.println(decodeVariations("12623"));
    }

}
