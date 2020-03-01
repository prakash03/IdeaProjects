package string;

public class MaskingPersonalInformation {

    /*
    Leetcode problem: https://leetcode.com/problems/masking-personal-information/;

    Example emails:
    1. pk@Gmail.com --> p*****k@gmail.com
    2. THONG@doR.com --> t*****g@dor.com


    Example phone numbers:
    phone number contains 10 - 13 digits
    +5556667777 --> 5556667777 --> ***-***-7777
    12223334444 --> +*-***-***-4444
    +910002220101 --> +**-***-***-0101

    +444-333+8888 --> ?


    // Using String builder

    // Using regex in java

    // Using String methods
     */

    static String maskEmail(String s){
        String[] input_string = s.split("@", 2);

        String name1 = input_string[0].toLowerCase();
        name1 = name1.charAt(0) + "*****" + name1.charAt(name1.length()-1);
        return name1 + "@" + input_string[1].toLowerCase();
    }

    static String maskPhoneNumber(String s){

        String cleanedUpString = "";
//        for(int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '+' || ("" + s.charAt(i)).matches("^[0-9]")) {
//                cleanedUpString += s.charAt(i);
//            }
//        }
        for(char c : s.toCharArray()){
            int diff = c - '0';
            if(diff >= 0 && diff <= 9){
                cleanedUpString += c;
            }
        }

//        String finalString = (cleanedUpString.charAt(0) == '+') ? cleanedUpString : ("+" + cleanedUpString);
        String finalString = "+" + cleanedUpString;

        int lengthFinal = finalString.length();
//        String unmaskedPortion = finalString.
        String unmaskedPortion = finalString.substring(lengthFinal-4, lengthFinal);
//        String unmaskedPortion = "" + finalString.charAt(lengthFinal - 4) + finalString.charAt(lengthFinal - 3) + finalString.charAt(lengthFinal - 2) + finalString.charAt(lengthFinal - 1);
        if(lengthFinal == 11){
            finalString = "***-***-" + unmaskedPortion;
        }
        else if(lengthFinal == 12){
            finalString = "+*-***-***-" + unmaskedPortion;
        }
        else if(lengthFinal ==13){
            finalString = "+**-***-***-" + unmaskedPortion;
        }
        else finalString = "+***-***-***-" + unmaskedPortion;

        return finalString;
    }

    public static String maskPII(String S) {

        // learn basic regex
//        String check_str = "" + S.charAt(0);

        if(S.indexOf('@') > 0){
            return maskEmail(S);
        }
        else return maskPhoneNumber(S);
    }

    public static void main(String[] args){
        String input_email_1 = "Pk@Gmail.com";
        System.out.println(maskPII(input_email_1));

        String input_phone_1 = "86-(10)12345678";
        System.out.println(maskPII(input_phone_1));
    }

    /*
    String maskEmail(String S){
        // split S at @
        // split [1] at .
        String[] split_string = S.split("@", 2);

        String name1 = split_string[0].toLowerCase();

        String maskedString = "";
        maskedString += name1.charAt(0);
        maskedString += "*****";
        maskedString += name1.charAt(name1.length()-1);
//         for(int i=0; i< name1.length(); i++){
//             if(i == 0 || i == name1.length()-1){
//                 maskedString += name1.charAt(i);
//             }
//             else maskedString += "*";
//         }

        return maskedString + "@" + split_string[1].toLowerCase();
    }

    String maskPhoneNumber(String S){
        String maskedPhone = "";
        for(int i = 0; i< S.length(); i++){
            if(i == 0 && S.charAt(i) == '+'){
                maskedPhone += "+";
            }
            else if((""+ S.charAt(i)).matches("^[0-9]")){
                maskedPhone += S.charAt(i);
            }
        }

        // String[] maskedPhoneItems = maskedPhone.split("\\+");

        String resultMask = "";
        int lengthOfPhone = maskedPhone.length();
        String unmasked = "" + maskedPhone.charAt(lengthOfPhone-4) + maskedPhone.charAt(lengthOfPhone-3) + maskedPhone.charAt(lengthOfPhone-2) + maskedPhone.charAt(lengthOfPhone-1);
        if(lengthOfPhone == 10){
            return "***-***-" + unmasked;
        }
        else if(lengthOfPhone == 11 && maskedPhone.charAt(0) == '+' ){
            return "***-***-" + unmasked;
        }

        if(maskedPhone.charAt(0) == '+'){
            if(lengthOfPhone == 12){
                resultMask = "+*-***-***-" + unmasked;
            }
            else if(lengthOfPhone == 13){
                resultMask = "+**-***-***-" + unmasked;
            }
            else{
                resultMask = "+***-***-***-" + unmasked;
            }
        }
        else {
            if(lengthOfPhone == 11){
                System.out.println("here");
                resultMask = "+*-***-***-" + unmasked;
            }
            else if(lengthOfPhone == 12){
                resultMask = "+**-***-***-" + unmasked;
            }
            else{
                resultMask = "+***-***-***-" + unmasked;
            }
        }
        return resultMask;
    }
     */
}
