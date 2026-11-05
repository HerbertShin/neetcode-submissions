class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Window = new int[26];
        int matches = 0;
        int l = 0;

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a'] ++;
            s2Window[s2.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < 26; i ++) {
            if (s1Count[i] == s2Window[i]) matches ++;
        }

        for (int r = s1.length(); r < s2.length(); r ++) {
            if (matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            
            s2Window[index] ++;
            
            if (s1Count[index] == s2Window[index]) {
                matches ++;
            } else if (s1Count[index] + 1 == s2Window[index]) {
                matches --;
            }
            
            index = s2.charAt(l) - 'a';

            s2Window[index] --;

            if (s1Count[index] == s2Window[index]) {
                matches ++;
            } else if (s1Count[index] - 1 == s2Window[index]) {
                matches --;
            }

            l ++;
        }

        return matches == 26;
    }
}
