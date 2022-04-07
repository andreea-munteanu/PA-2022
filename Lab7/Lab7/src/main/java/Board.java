import java.util.List;

/**
 * @author: Andreea Munteanu, group X
 */
public class Board {
    private final List<String> words; //a collection for words;

    public Board(List<String> words) {
        this.words = words;
    }

    public void addWord(Player player, String word) {
        // add the word to the collection;
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {
        return words.toString();
    }
}
