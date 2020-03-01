package LeetCodeProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxProductOfWordLengths {
//    boolean wordsHaveCommonLetters(String word1, String word2){
//        Set<Character> letterSet = new HashSet<>();
//        for(Character c : word1.toCharArray()){
//            letterSet.add(c);
//        }
//
//        for(Character c : word2.toCharArray()) {
//            if (letterSet.contains(c)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int maxProduct(String[] words) {
//
//        int maxProduct = 0;
//
//        for(int i = 0; i < words.length-1; i++){
//            for(int j = i+1; j < words.length; j++){
//                if(!wordsHaveCommonLetters(words[i], words[j])){
//                    maxProduct = (maxProduct < words[i].length() * words[j].length()) ? words[i].length() * words[j].length() : maxProduct;
//                }
//            }
//        }
//
//        return maxProduct;
//    }

    public int maxProduct(String[] words) {
        int [] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            masks[i] = createMask(words[i]);
        }

        System.out.println(Arrays.toString(masks));
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private int createMask(String str) {
        int mask = 0;
        for (int i = 0; i < str.length(); i++) {

            mask |= (1 << charToInt(str.charAt(i)));
        }
        return mask;
    }

    private int charToInt(char ch) {
        return ch - 'a';
    }

    public static void main(String[] args){
        String[] words = new String[] {"abcw","baz","foo","bar","xtfn","abcdef"};

        String[] words2 = new String[] {"b", "bb", "bbb"};

        String[] words3 = new String[] {"a","ab","abc","d","cd","bcd","abcd"};

        MaxProductOfWordLengths mpwl = new MaxProductOfWordLengths();
//        System.out.println(mpwl.wordsHaveCommonLetters("bdr", "pmk"));
        System.out.println(mpwl.maxProduct(words3));
    }
}
