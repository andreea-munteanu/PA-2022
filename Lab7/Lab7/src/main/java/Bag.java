import java.util.ArrayList;
import java.util.List;

/**
 * @author: Andreea Munteanu, group X
 */
public class Bag {
    private final List<Character> tiles;

    public Bag(List<Character> tiles) {
        this.tiles = tiles;
        for (char c = 'a'; c < 'z'; c++) {
            // add a new tile to the collection;
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            extracted.add();
        }
        return extracted;
    }
}
