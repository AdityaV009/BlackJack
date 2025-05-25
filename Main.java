import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
    }
}