class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> window = new HashMap<>();

        int l = 0;
        int max = 0;
        int localMax = 0;

        for (int r = 0; r < s.length(); r ++) {
            window.merge(s.charAt(r), 1, Integer::sum);

            for (int freq : window.values()) {
                localMax = Math.max(localMax, freq);
            }

            while ((r - l + 1) - localMax > k) {
                window.merge(s.charAt(l), 1, (oldVal, newVal) -> oldVal - newVal == 0 ? null : oldVal - newVal);
                
                for (int freq : window.values()) {
                    localMax = Math.max(localMax, freq);
                }
                
                l ++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
