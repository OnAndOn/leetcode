public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals(magazine) || "".equals(ransomNote)) {
            return true;
        }
        if ("".equals(magazine) && !"".equals(ransomNote)) {
            return false;
        }

        int[] ransomNoteCharCount = new int[26];
        int[] magazineCharCount = new int[26];

        for(int i = 0 ; i < ransomNote.length() ; i++) {
            ransomNoteCharCount[ransomNote.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < magazine.length() ; i++) {
            magazineCharCount[magazine.charAt(i)-'a']++;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(ransomNoteCharCount[i] > magazineCharCount[i] ) {
                return false;
            }
        }
        return true;
    }
}