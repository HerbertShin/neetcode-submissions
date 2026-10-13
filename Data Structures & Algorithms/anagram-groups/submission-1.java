class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            List<String> emptyList = new ArrayList<>();
            emptyList.add("");
            result.add(emptyList);
            return result; 
        }

        Map<String, List<String>> wordMap = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a'] ++;
            }   

            String key = Arrays.toString(freq);

            if (!wordMap.containsKey(key)) {
                wordMap.put(key, new ArrayList<>());
            }

            wordMap.get(key).add(str);
        }

        for (List<String> wordList : wordMap.values()) {
            result.add(wordList);
        }

        return result; 
    }
}
