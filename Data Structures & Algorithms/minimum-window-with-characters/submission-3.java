class Solution {
    public String minWindow(String s, String t) {
        String minSubstring = "";
        
        if (s.length() < t.length()) return minSubstring;

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.merge(c, 1, Integer::sum);
        }

        int l = 0;
        int matches = 0;
        int requiredMatches = tCount.size();
        int minLength = 100001;

        for (int r = 0; r < s.length(); r ++) {
            if (tCount.containsKey(s.charAt(r))) {
                sCount.merge(s.charAt(r), 1, Integer::sum);

                if (sCount.get(s.charAt(r)).equals(tCount.get(s.charAt(r)))) matches ++;
            }

            while (matches == requiredMatches) {
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    minSubstring = s.substring(l, r + 1);
                }

                if (tCount.containsKey(s.charAt(l))) {
                    if (tCount.get(s.charAt(l)).equals(sCount.get(s.charAt(l)))) {
                        matches --;
                    }

                    sCount.merge(s.charAt(l), 1, (oldVal, newVal) -> oldVal - newVal);
                }

                l ++;
            }   

        }

        return minSubstring;
    }
}
