import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player playerYou = new Player();
        Player computer = new Player();

        Lucky9 lucky9Game = new Lucky9(playerYou, computer);

        lucky9Game.start();
    }
}
