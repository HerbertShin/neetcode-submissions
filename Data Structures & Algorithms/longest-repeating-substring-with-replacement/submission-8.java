class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> seen = new HashSet<>();
        int[] freq = new int[26];
        int l = 0;
        int max = 0;
        int localMax = 0;

        for (int r = 0; r < s.length(); r ++) {
            freq[s.charAt(r) - 'A'] += 1;
            
            if (!seen.contains(s.charAt(r))) seen.add(s.charAt(r));

            for (char c : seen) {
                localMax = Math.max(localMax, freq[c - 'A']);
            }

            while ((r - l + 1) - localMax > k) {
                freq[s.charAt(l) - 'A'] -= 1;

                if (freq[s.charAt(l) - 'A'] == 0) seen.remove(s.charAt(l));
                
                for (char c : seen) {
                    localMax = Math.max(localMax, freq[c - 'A']);
                }
                
                l ++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
