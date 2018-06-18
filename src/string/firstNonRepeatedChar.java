package string;

//program to print first non repeated character from String
//Read more: http://javarevisited.blogspot.com/2015/01/top-20-string-coding-interview-question-programming-interview.html#ixzz55u9cc4cI

public class firstNonRepeatedChar {
    static char findChar(String str){
        int[] counter = new int[26];
        for(int i=0; i<str.length(); i++){
            counter[str.charAt(i) - 'a']++;
        }
        for(int i=0; i<str.length(); i++){
            if(counter[str.charAt(i) - 'a'] == 1) { //Now going over the characters in the actual order again.
                return str.charAt(i);
            }
        }
        System.out.println("No non repeating characters");
        return ' ';
    }

    public static void main(String[] args) {
        String str = "Pbrakash";
        char answer = findChar(str.toLowerCase());
        System.out.println(answer);
    }
}
