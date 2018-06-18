package InterviewPractice;

public class ReverseWords {

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
        System.out.println(reverseWordsInSentence(sentence2));
    }
}
