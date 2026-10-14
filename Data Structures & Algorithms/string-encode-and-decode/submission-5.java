class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        
        if (str.isEmpty()) return decodedList;

        int l = 0;

        for (int r = 0; r < str.length(); r ++) {
            while (str.charAt(r) != '#') {
                r ++;
            }

            int length = Integer.parseInt(str.substring(l, r));

            l = r + 1;
            r = l + length;

            decodedList.add(str.substring(l, r));

            l = r;
        }
        
        return decodedList;
    }
}
