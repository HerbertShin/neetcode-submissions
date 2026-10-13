class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> freq = new HashSet<>();
        
        char[] arr = s.toCharArray();
        int l = 0, r = 0, max = 0;

        while (r < s.length()) {
            while (freq.contains(arr[r])) {
                freq.remove(arr[l]);
                l ++;
            }

            freq.add(arr[r]);
            
            max = Math.max(r - l + 1, max);
            
            r ++;
        }

        return max;
    }
}
