package string;

public class LongestCommonPrefix {

    /**
     *
     * Leetcode question: https://leetcode.com/problems/longest-common-prefix/
     *
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string ""
     *
     */

//    static String longestCommonPrefi(String[] strs){
//        if (strs.length == 0) return "";
//        String prefix = strs[0];
//        for (int i = 1; i < strs.length; i++)
//            while (strs[i].indexOf(prefix) != 0) {
//                prefix = prefix.substring(0, prefix.length() - 1);
//                if (prefix.isEmpty()) return "";
//            }
//        return prefix;
//    }

    static String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            System.out.println("Prefix is: " + prefix);
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                System.out.println("Prefix is: " + prefix);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

//    static String longestCommonPrefix(String[] strs){
//        if(strs.length == 0) return "";
//
//        for(int i = 0; i < strs[0].length(); i++){
//            char c = strs[0].charAt(i);
//            for( int j = 1; j < strs.length; j++){
//                if(strs[j].charAt(i) != c){
//                    return "";
//                }
//                else {
//
//                }
//            }
//        }
//    }

    public static void main(String[] args){
        String[] input1 = new String[] {"flower","flow","flight"};

        String[] input2 = new String[] {"dog","racecar","car"};

        System.out.println("prakas".indexOf("prakash"));
        System.out.println("prak".substring(0, 3));

        System.out.println(longestCommonPrefix(input1));
//
//        System.out.println(longestCommonPrefix(input2));
    }
}
