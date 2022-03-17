import java.util.Objects;

/**
 * @author: Andreea Munteanu, group X
 */
public class Street implements Comparable<Street>{
    private String name;
    private int length; // in km

    // constructor
    public Street(String name, int length) {
        this.name = name; // A.getName() + B.getName();
        this.length = length;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // to string
    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Float.compare(street.length, length) == 0 && Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length);
    }

    @Override
    public int compareTo(Street o) {
        return 0;
    }
}
