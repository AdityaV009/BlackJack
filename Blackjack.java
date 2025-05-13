import java.util.*;

public class Blackjack{
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    ArrayListList<int> playerHand = new ArrayList<int>();
    ArrayList<int> dealerHand = new ArrayList<int>();

    playerHand.add(drawCard());
    playerHand.add(drawCard());
    dealerHand.add(drawCard());
    dealerHand.add(drawCard());
   
    private static int drawCard() {
        int card = random.nextInt(13) + 1;
        return Math.min(card, 10); // Face cards are worth 10
    }
     private static int handValue(List<Integer> hand) {
        int total = 0;
        int aces = 0;

        for (int card : hand) {
            total += card;
            if (card == 1) aces++;
        }

        while (total <= 11 && aces > 0) {
            total += 10; // Count Ace as 11 if possible
            aces--;
        }

        return total;
    }
}