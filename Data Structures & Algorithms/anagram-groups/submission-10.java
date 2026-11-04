class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a'] ++;
            }

            String key = Arrays.toString(freq);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        anagrams.addAll(groups.values());

        return anagrams;
    }
}
