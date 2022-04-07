import java.util.ArrayList;
import java.util.List;

/**
 * @author: Andreea Munteanu, group X
 */
public class Game {
    private final Bag bag = new Bag(tiles);
    private final Board board = new Board(words);
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        // player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
            Thread myThread = new Thread();
            myThread.start();
            try {
                Thread.sleep(10L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }

    public void getBag() {

    }
}