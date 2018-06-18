package Testing;

public class StringUtilities {

     private StringBuilder sBuilder = new StringBuilder();
     private int charsAdded = 0;

     public void addChar(StringBuilder sBuilder, char c){
         sBuilder.append(c);
         charsAdded++;
     }

     public String upperAndPrefix(String str){
         String upper = str.toUpperCase();
         return "Prefix_"+ upper;
     }

     public String addSuffix(String str){
         return str + "__Suffix";
     }

    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
         while(sb.length()<10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

         String str = "abcdefg";
         String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}
