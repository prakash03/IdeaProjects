public class AddDigits {
    public static int addDigits(int num) {
//        char[] numbers = String.valueOf(num).toCharArray();
        String numbersString = Integer.toString(num);
        String[] numbers = numbersString.split("");
        System.out.println(numbers);

        int total = 0;
        for(int i=0; i< numbers.length; i++) {
            total += Integer.valueOf(numbers[i]);
        }

        if(Integer.toString(total).length() > 1) {
            total = addDigits(total);
        }

        return total;

    }

    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }

}
