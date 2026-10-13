class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> freq = new HashSet<>();
        
        char[] arr = s.toCharArray();
        int l = 0, max = 0;

        for (int r = 0; r < s.length(); r ++) {
            while (freq.contains(arr[r])) {
                freq.remove(arr[l]);
                l ++;
            }

            freq.add(arr[r]);
            
            max = Math.max(r - l + 1, max);
        }

        return max;
    }
}
