class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();

        if (strs.length == 0) return anagrams;

        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freqArr = new int[26];

            for (char arrChar : str.toCharArray()) {
                freqArr[arrChar - 'a'] ++;
            }

            Integer key = Arrays.hashCode(freqArr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        map.values().forEach(anagramList -> anagrams.add(anagramList));

        return anagrams;
    }
}
