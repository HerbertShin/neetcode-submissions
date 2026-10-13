class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();

        if (strs.length == 0) return anagrams;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = new String(strArr);
            
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>(Arrays.asList(str)));
            } else {
                map.get(sortedStr).add(str);
            }
        }

        map.values().forEach(anagramList -> anagrams.add(anagramList));

        return anagrams;
    }
}
