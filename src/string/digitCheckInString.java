package string;

//check if a String contains only digits

public class digitCheckInString {
    //ASCII 'a' = 97; '0' = 48; '9' = 57. 'a'-'0' = 49; 'a'-'9' = 40
    static boolean finder(String str){
        for(int i=0; i<str.length(); i++){
            int value = 'a'- str.charAt(i);
            if(value < 40 || value > 49){
                System.out.println("Contains characters other than digits");
                return false;
            }
        }
        System.out.println("Contains only digits");
        return true;
    }
    public static void main(String[] args) {
        String str = "09387410";
        System.out.println(finder(str));
    }
}
