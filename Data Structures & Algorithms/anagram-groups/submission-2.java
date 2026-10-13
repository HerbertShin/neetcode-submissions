class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            int[] arr = new int[26];

            for (char c : str.toCharArray()) {
                arr[c - 'a'] ++;
            }

            String key = Arrays.toString(arr);

            resultMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(resultMap.values());
    }
}
