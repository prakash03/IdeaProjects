package string;

import java.util.*;

public class ReorderLogFile {

    /**
     * Leetcode problem: https://leetcode.com/problems/reorder-data-in-log-files/solution/
     *
     * //priority queue implementation https://leetcode.com/problems/reorder-data-in-log-files/discuss/509490/Java-Priority-queue
     */

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) ->{
            System.out.println("Comparing: " + log1 + " , " + log2);
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ",2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if( !isDigit1 && !isDigit2 ) {
                int cmp = split1[1].compareTo(split2[1]);
                System.out.println("Result for: " + log1 + " , " + log2 + " is " + cmp);
                if(cmp != 0) return cmp;

                int result = split1[0].compareTo(split2[0]);
                System.out.println("Result for: " + log1 + " , " + log2 + " is " + result);
                return split1[0].compareTo(split2[0]);
            }

            int digit_result = isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            System.out.println("Result for: " + log1 + " , " + log2 + " is " + digit_result);
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

        });

        return logs;
    }

    public static void main(String[] args){
        String[] input = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        System.out.println(reorderLogFiles(input));


    }
}

