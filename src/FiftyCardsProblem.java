public class FiftyCardsProblem {
    /*
    There are 50 playing cards in a straight line next to each other, facing downwards. A man begin flipping all 50 cards.
    Next, he flips every second card in the line. Then, on the third pass, he flips every third card. The process continues for 50
    passes such that on a given pass n, the man flips every nth card in the line. On his 50th pass, he flips 50th card in the line.
    How any cards end up facing upwards after the 50 passes.
     */
    public static void main(String[] args) {
        //close card = false;
        //open card = true;
        boolean[] cards = new boolean[20];
        int range = cards.length;
        for(int i=1; i<=range; i++){
            for(int j=i-1; j<range; ){
                cards[j] = (cards[j]==false) ? true : false;
                //System.out.println(j);
                j = j + i;
            }
            //print(cards, i);
        }
        int count = 0;
        for(boolean card: cards){
            if(card == true){
                count++;
            }
        }
        System.out.println(count);
    }
}
