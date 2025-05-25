import java.util.*;

public class Blackjack{
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private ArrayList<Integer> playerHand;
    private ArrayList<Integer> dealerHand;

    public Blackjack(){
        playerHand = new ArrayList<Integer>();
        dealerHand = new ArrayList<Integer>();
        playerHand.add(drawCard());
        playerHand.add(drawCard());
        dealerHand.add(drawCard());
        dealerHand.add(drawCard());
    }
   
    public int drawCard() {
        int card = random.nextInt(13) + 1;
        return Math.min(card, 10); // Face cards are worth 10
    }
     public int handValue(List<Integer> hand) {
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
     public ArrayList<Integer> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Integer> getDealerHand() {
        return dealerHand;
    }

    public void playerHit() {
        playerHand.add(drawCard());
    }

     public void dealerPlay() {
        while (handValue(dealerHand) < 17) {
            dealerHand.add(drawCard());
        }
    }

    public String getResult() {
        int playerTotal = handValue(playerHand);
        int dealerTotal = handValue(dealerHand);

        if (playerTotal > 21) return "You bust! Dealer wins.";
        if (dealerTotal > 21) return "Dealer busts! You win!";
        if (playerTotal > dealerTotal) return "You win!";
        if (playerTotal < dealerTotal) return "Dealer wins.";
        return "Its a tie!";
    }
}