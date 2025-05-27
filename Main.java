import java.util.Scanner;
import java.util.*;
import PokerV2.individualHand;
import PokerV2.Card;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome! Would you like to play Blackjack(b) or Poker(p)?");
        Scanner scan1 = new Scanner(System.in);
        String s = scan1.nextLine().toLowerCase();
        //If blackjack is chosen
        if(s.equals("b")){
            Scanner input = new Scanner(System.in);
            Blackjack game = new Blackjack();

            System.out.println("Welcome to Blackjack!");

            // Show player's hand
            System.out.println("Your hand: " + game.getPlayerHand());
            System.out.println("Your hand value: " + game.handValue(game.getPlayerHand()));

            // Show only one of the dealer's cards (like in real Blackjack)
            System.out.println("Dealer shows: [" + game.getDealerHand().get(0) + ", ?]");

            // Player turn
            while (true) {
                System.out.print("Do you want to hit or stand? (h/s): ");
                String choice = input.nextLine().toLowerCase();

                if (choice.equals("h")) {
                    game.playerHit();
                    System.out.println("Your hand: " + game.getPlayerHand());
                    int value = game.handValue(game.getPlayerHand());
                    System.out.println("Your hand value: " + value);
                    if (value > 21) {
                        System.out.println("You bust!");
                        break;
                    }
                } else if (choice.equals("s")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 'h' or 's'.");
                }
            }

            // Dealer's turn
            System.out.println("\nDealer's turn...");
            game.dealerPlay();

            // Show full dealer hand
            System.out.println("Dealer's hand: " + game.getDealerHand());
            System.out.println("Dealer's hand value: " + game.handValue(game.getDealerHand()));

            // Result
            System.out.println("\n" + game.getResult());
        } else if (s.equals("p")){
            Scanner input = new Scanner(System.in);
            PokerV2.individualHand[] players = new PokerV2.individualHand[3];

            System.out.println("Welcome to Poker!");

            //Define each individual player, give them 100 chips
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter name for Player " + (i + 1) + ": ");
                players[i] = new PokerV2.individualHand(input.nextLine(), 100);
            }

            while(true) { 
                //Create a new round (new deck of cards)
                PokerV2.Deck deck = new PokerV2.Deck();

                //Reset all attributes of players and give them 2 cards
                for(PokerV2.individualHand player: players){
                    player.myHand.clear();
                    player.hasFolded = false;
                    for(int i=0; i<2; i++){
                        player.myHand.add(deck.nextCard());
                    }
                }

                //Create the flop
                ArrayList<PokerV2.Card> flop = new ArrayList<>();
                for(int i=0; i<5; i++){
                    flop.add(deck.nextCard());
                }

                //All rounds of betting -- Before and after the flop
                System.out.println();
                System.out.println("--- Pre-Flop Betting Round ---");
                PokerV2.bet(players, input, 0);

                System.out.println();
                System.out.println("--- Community Cards ---");
                for (PokerV2.Card c : flop) {
                    System.out.println(c);
                }

                System.out.println();
                System.out.println("--- Post-Flop Betting Round ---");
                PokerV2.bet(players, input, 0);

                
            }

        }
    } 
}