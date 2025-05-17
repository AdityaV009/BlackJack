public class main{
    public static void Main(String[] args){
        System.out.println("Welcome to blackjack. The dealer deals the cards to you.");
        Blackjack game = new Blackjack();
        System.out.println("The value of your hand is: " + game.handValue());
    }
}