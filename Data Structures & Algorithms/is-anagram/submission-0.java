class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return s == t;

        if (s.length() != t.length()) return false; 

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i ++) {
            alphabet[s.charAt(i) - 'a'] ++;
            alphabet[t.charAt(i) - 'a'] --;
        }

        for (int freq : alphabet) {
            if (freq != 0) return false;
        }

        return true; 
    }
}
