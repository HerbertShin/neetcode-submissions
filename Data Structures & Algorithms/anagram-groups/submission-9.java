class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            int[] freqArr = new int[26];

            for (char c : str.toCharArray()) {
                freqArr[c - 'a'] += 1;
            }

            String key = Arrays.toString(freqArr);

            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        result.addAll(anagramMap.values());

        return result;
    }
}
