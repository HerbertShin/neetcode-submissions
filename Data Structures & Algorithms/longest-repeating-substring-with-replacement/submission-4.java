class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int max = 0, currMax = 0, l = 0;

        for (int r = 0; r < s.length(); r++) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            currMax = Math.max(currMax, freq.get(s.charAt(r)));

            while ((r - l + 1) - currMax > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l ++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
