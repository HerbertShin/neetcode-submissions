class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();

        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            int maxFreq = 0;

            for (int freq : window.values()) {
                maxFreq = Math.max(maxFreq, freq);
            }

            while ((r - l + 1) - maxFreq > k) {
                char left = s.charAt(l);

                window.put(left, window.get(left) - 1);

                if (window.get(left) == 0) {
                    window.remove(left);
                }

                l++;

                maxFreq = 0;
                for (int freq : window.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                }
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
