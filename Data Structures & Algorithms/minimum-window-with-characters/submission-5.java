class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.merge(c, 1, Integer::sum);
        }

        int[] res = {-1, -1};

        int l = 0;
        int matches = 0;
        int requiredMatches = tCount.size();
        int minLength = 100001;

        for (int r = 0; r < s.length(); r ++) {
            sCount.merge(s.charAt(r), 1, Integer::sum);

            if (tCount.containsKey(s.charAt(r)) && sCount.get(s.charAt(r)).equals(tCount.get(s.charAt(r)))) {
                matches ++;
            }

            while (matches == requiredMatches) {
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    res[0] = l;
                    res[1] = r + 1;
                }

                if (tCount.containsKey(s.charAt(l)) && tCount.get(s.charAt(l)).equals(sCount.get(s.charAt(l)))) {
                        matches --;
                }

                sCount.merge(s.charAt(l), 1, (oldVal, newVal) -> oldVal - newVal);

                l ++;
            }   
        }

        return minLength == 100001 ? "" : s.substring(res[0], res[1]);
    }
}
