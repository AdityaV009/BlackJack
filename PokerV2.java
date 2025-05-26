import java.util.*;

public class PokerV2 {
    class Card {
        String suit, rank;
        int num;

        Card(String newRank, String newSuit, int newNum){
            rank=newRank;
            suit=newSuit;
            num=newNum;
        }
    }

    class Deck {
        ArrayList<Card> fullDeck;

        Deck() {
            fullDeck = new ArrayList<Card>();
            String[] suits = {"Spades", "Diamonds", "Clubs", "Spades"};
            String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
            for (int i=0; i<suits.length; i++){
                for(int j=0; j<ranks.length; j++){
                    fullDeck.add(new Card(ranks[j], suits[i], i+2));
                }
            }
        }
    }
}
