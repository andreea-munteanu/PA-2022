import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Andreea Munteanu, group X
 */
public class Dictionary {
    ArrayList<String> dictionary = new ArrayList<String>();

    public void readFromFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                // each word is on a new line
                String ar[] = line.split("\n");
                Collections.addAll(dictionary, ar);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean isWord(String str) {
        for (String word : dictionary) {
            if (word.equals(str)) return true;
        }
        return false;
    }
}

