class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> found = new HashSet<>();

        if (s.length() <= 1) return s.length();

        char[] sArr = s.toCharArray();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            Character curr = sArr[right];

            while (found.contains(curr)) {
                found.remove(sArr[left]);
                left ++; 
            }

            found.add(curr);
            max = Math.max(max, right - left + 1);
        }

        return max; 
    }
}
