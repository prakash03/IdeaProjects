package InterviewPractice;

public class ReverseWords {

    //This function reverse every letter in the given sentence
    static String reverseSentence(String str){
         String answer = "";
         int length = str.length();
         for(int i=length-1; i>=0; i--){
             answer += str.charAt(i);
         }
         return answer;
    }

    //This function reverses the words in given sentence.
    static String reverseWordsInSentence(String str){
        String answer = "";
        String[] inputArray = str.split(" ");
        for(int i=inputArray.length-1; i>=0; i--){
            answer += inputArray[i] + " ";
        }
        return answer;
    }


    public static void main(String[] args){
        String sentence1 = "Going good! Reverse this sentence";
        String sentence2 = " ";
        System.out.println(reverseWordsInSentence(sentence1));
        System.out.println(reverseSentence(sentence1));
    }

}
