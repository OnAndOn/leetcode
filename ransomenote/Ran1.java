package ransomenote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyang on 16/11/1.
 */
public class Main {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

        List<Character> list = new ArrayList<Character>();
        for(char ch : mag) {
            list.add(ch);
        }

        for(Character ch : ransom) {
            if(!list.isEmpty() && list.contains(ch)) {
                list.remove(ch);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Main instance = new Main();
        System.out.println(instance.canConstruct("aac", "aab"));
    }
}
