import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Andreea Munteanu, group X
 */
public abstract class Item implements Serializable {
    private String id;
    private String title;
    private String location; //file name or Web page

    private Map<String, Object> tags = new HashMap<>();

    // constructor
    public Item(String id, String title, String location, Map<String, Object> tags) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = tags;
    }

    // getters and setters:


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}

