package string;
import java.util.*;

public class compressedString {
    public static String shortenedString(String s){
        String answer = "";
        char[] input = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> charList = new ArrayList<>();
        int count = 1;
        for(int i= 1; i<input.length; i++){
            if((i == input.length-1) && input[i] == (input[i-1]) ){
                count ++;
                list.add(count);
                charList.add(input[i]);
            }
            if(input[i] == (input[i-1])){
                count++;
            }
            else{
                list.add(count);
                charList.add(input[i-1]);
                count = 1;
            }
        }


        for(int j=0; j<list.size(); j++){
            if(list.get(j) == 1){
                answer = answer + charList.get(j);
            }
            else if(list.get(j) == 2){
                answer = answer + charList.get(j) + charList.get(j);
            }
            else{
                answer = answer + charList.get(j) +list.get(j);  //a4..
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String s = "gaaaabbbbccccdeee";
        System.out.println(shortenedString(s));
    }
}
