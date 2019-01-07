import java.util.ArrayList;
import java.util.Scanner;

public class Lucky9 {
    private Player playerYou;
    private Player computer;
    private Scanner reader;
    private ArrayList<Card> deck;

    public Lucky9(Player playerYou, Player computer) {
        this.playerYou = playerYou;
        this.computer = computer;
        this.reader = new Scanner(System.in);
        this.deck = new ArrayList<Card>(52);
    }

    public void start() {

        for (int suits = 0; suits < 4; suits++)
        {
            for (int values = 1; values < 14; values++)
                this.deck.add( new Card(values, suits) );
        }

        for (Card card : deck) {
            System.out.println(card);
        }

        System.out.println("Welcome to the Lucky 9 Game!");
        System.out.println();

        System.out.println("Drawing cards for you and the computer..");
        System.out.println();

        playerYou.draw(deck);
        computer.draw(deck);

        playerYou.displayYourCards();

        System.out.print("Do you want to draw a third card? (y/n): ");
        String command = this.reader.nextLine();

        if (command.equalsIgnoreCase("y")) {
            playerYou.drawThirdCard();
            playerYou.displayYourCards();
        }

        System.out.println();
        System.out.println("Computer's card: ");
        computer.displayYourCards();

        if ( playerYou.getValueOfCards() > computer.getValueOfCards() ) {
            System.out.println("You win!");
        } else if ( playerYou.getValueOfCards() < computer.getValueOfCards() ) {
            System.out.println("You lose!");
        } else {
            System.out.println("Draw!");
        }

        System.out.println();

        System.out.println("Cards left in the deck: " + this.deck.size());

        if (this.deck.size() <= 3) {
            System.out.println("Thanks for playing!");
        } else {
            askIfPlayAgain();
        }


    }

    public void askIfPlayAgain() {


        System.out.println("Wanna play again? (y/n): ");
        String command = this.reader.nextLine();

        if (command.equalsIgnoreCase("y")) {
            playerYou.resetCards();
            computer.resetCards();

            start();
        } else {
            System.out.println("Thanks!");
        }
    }


}
