package string;


public class AnagramCheck {
    static boolean validAnagram(String str1, String str2){
        int[] counter = new int[128]; //The Array length can always be 128, since the total number of ASCII characters is 128.
        if(str1.length() != str2.length())return false;
        for(int i=0; i<str1.length();i++){
            counter[str1.charAt(i) - ' ']++;
            counter[str2.charAt(i) - ' ']--;
            //ASCII  'a' = 97; 'A' = 65; [space] = 32; '0' =48; '9' = 57
            //The character being subtracted should always be the character with smallest ASCII value in the given string.
        }

        for(int count : counter){
            if(count!=0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s_1 = "Hot is Sun.";
        String s_2 = "Sun is HOt.";
        boolean answer = validAnagram(s_1.toLowerCase(), s_2.toLowerCase()); //Important to convert Strings to Lower case.
        System.out.println(answer);
    }
}
