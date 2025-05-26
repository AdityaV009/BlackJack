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
            shuffle9);
        }

        //make sure we can shuffle multiple times
        void suffle() {
            Collections.shuffle(fullDeck);
        }

        public Card nextCard(){
            return fullDeck.remove(0);
        }
    }

    class individualHand{
        String playerName;
        ArrayList<Card> myHand;
        int chips;
        boolean hasFolded;

        individualHand(String newName, int currChips){
            playerName=newName;
            chips=currChips;
            myHand = new ArrayList<>();
            hasFolded=false;
        }

        void displayHand() {
            for(Card c: myHand){
                System.out.println(c);
            }
        }

        //check for what is the strongest hand possible
        int checkStrongest(ArrayList<Card> allCards) {
            ArrayList<Integer> values = new ArrayList<>();
            ArrayList<String> suits = new ArrayList<>();
            for(Card c: allCards){
                values.add(c.num);
                suits.add(c.suit);
            }
            //sorts in ascending order
            Collections.sort(values);
            int[] cnt = countCards(values);
            boolean isStraight=false;
            for(int i=0; i<values.size()-5; i++){
                ArrayList<Integer> checkHand = new ArrayList<>();
                for(int j=i; j<i+5; j++){
                    checkHand.add(values.get(i));
                }
                if(checkStraight(checkHand)==true){
                    isStraight=true;
                }
            }

            boolean isFlush=false;
            for(int i=0; i<suits.size()-5; i++){
                ArrayList<String> checkHand = new ArrayList<>();
                for(int j=i; j<i+5; j++){
                    checkHand.add(suits.get(i));
                }
                if(checkFlush(checkHand)==true){
                    isFlush=true;
                }
            }

            

        }

        int[] countCards (ArrayList<Integer> vals){
            int[] cnt = new int[15];
            for(Integer v: vals){
                cnt[(int)v]++;
            }
            return cnt;
        }

        boolean checkStraight(ArrayList<Integer> vals){
            for(int i=0; i<vals.size()-1; i++){
                if(vals.get(i)!=vals.get(i+1)-1){
                    return false;
                }
            }
            return true;
        }

        boolean checkFlush(ArrayList<String> vals){
            for(int i=0; i<vals.size()-1; i++){
                if(vals.get(i)!=vals.get(i+1)){
                    return false;
                }
            }
            return true;
        }
    }
}
