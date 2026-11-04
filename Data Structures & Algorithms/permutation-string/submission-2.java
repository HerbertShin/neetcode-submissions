class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int[] window = new int[26];
        int l = 0;

        if (s1.length() > s2.length()) return false;

        for (char c : s1.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        String s1Key = Arrays.toString(freq);

        for (int i = 0; i < s1.length() - 1; i ++) {
            window[s2.charAt(i) - 'a'] += 1;
        }

        for (int r = s1.length() - 1; r < s2.length(); r ++) {
            window[s2.charAt(r) - 'a'] += 1;
            
            if (s1Key.equals(Arrays.toString(window))) return true;

            window[s2.charAt(l) - 'a'] -= 1;

            l ++;
        }

        return false;
    }
}
