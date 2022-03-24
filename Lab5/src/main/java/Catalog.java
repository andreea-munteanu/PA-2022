import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: Andreea Munteanu, group X
 */

public class Catalog implements Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();


    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
