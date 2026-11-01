class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();     
        
        int max = 0;
        int l = 0, r = 0;   

        while (r < s.length()) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l ++;
            }

            seen.add(s.charAt(r));

            max = Math.max(max, r - l + 1);

            r ++;
        }

        return max;
    }
}
