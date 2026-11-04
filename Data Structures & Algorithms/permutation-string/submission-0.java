class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a'] += 1;
        }

        String s1Key = Arrays.toString(freq);

        for (int r = 0; r < s2.length(); r ++) {
            if (freq[s2.charAt(r) - 'a'] > 0 && r + s1.length() <= s2.length()) {
                int[] freqArr2 = new int[26];

                for (char c : s2.substring(r, r + s1.length()).toCharArray()) {
                    freqArr2[c - 'a'] += 1;
                }

                if (Arrays.toString(freqArr2).equals(s1Key)) return true;
            }
        }

        return false;
    }
}
