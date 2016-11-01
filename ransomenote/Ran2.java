package ransomenote2;

import java.util.Arrays;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

        Arrays.sort(ransom);
        Arrays.sort(mag);

        if(mag.length < ransom.length) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < ransom.length && j < mag.length) {
            if(ransom[i] == mag[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == ransom.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Solution instance = new Solution();
        System.out.println(instance.canConstruct("aa", "aac"));

    }
}
