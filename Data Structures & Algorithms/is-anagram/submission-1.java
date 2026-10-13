class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        if (s.length() != t.length()) return false;

        for (Character c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
            } else {
                freqMap.put(c, 1);
            }
        }

        return freqMap.values().stream().allMatch(v -> v == 0);
    }
}
