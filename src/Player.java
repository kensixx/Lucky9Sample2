import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// TODO: make another object like "ComputerPlayer" that INHERITS in this class. (or interface?)
public class Player {
    private List<Card> cards;

    // will determine if player is computer or not.
    // not implemented in constructor && methods yet. =)
    private boolean isComputer; // WOW THANKS BOSS IAN JASPER CABALEN

    public Player() {
        this.cards = new ArrayList<Card>();
    }

    public void draw(ArrayList<Card> deck) {
        // add two random cards in the deck
        // deck should be decreased.

        // TODO: should mimic a real card game where the deck (ArrayList) "shuffles" and then pick a card on "top"
        // of it.
        int randomNumber1 = ThreadLocalRandom.current().nextInt(1, deck.size());
        int randomNumber2 = ThreadLocalRandom.current().nextInt(1, deck.size());

        cards.add(deck.get(randomNumber1));
        deck.remove(randomNumber1);

        cards.add(deck.get(randomNumber2));
        deck.remove(randomNumber2);
    }

    public void displayYourCards() {

        System.out.println("Your cards are: ");
        for (Card card : cards) {
            System.out.println(card);
        }

        int valueOfCards = this.getValueOfCards();

        System.out.println();

        System.out.print("Its value will be: " + valueOfCards);
        System.out.println();
        System.out.println();
    }

    public int getValueOfCards() {
        int value = 0;

        for (Card card : cards) {
            if (Card.VALUES[card.getValue()].equals("A")) {
                value += 1;
                continue;
            } else if (Card.VALUES[card.getValue()].equals("J") ||
                    Card.VALUES[card.getValue()].equals("Q") ||
                    Card.VALUES[card.getValue()].equals("K")) {
                value += 10;
                continue;
            }

            int valueToInt = Integer.parseInt(Card.VALUES[card.getValue()]);
            value += valueToInt;
        }

        // get second digit if value is 10 above
        // by using modulo to 10.
        if (value >= 10) {
            value = value % 10;
        }

        return value;
    }

    public void drawThirdCard() {
        // add third card in the card array list here
        System.out.println();
        System.out.println("Drawing third card..");
        System.out.println();

        int randomValue = ThreadLocalRandom.current().nextInt(1, 14);
        int randomSuit = ThreadLocalRandom.current().nextInt(0, 3);

        cards.add( new Card(randomValue, randomSuit) );
    }

    public void resetCards() {
        this.cards.clear();
    }

}
