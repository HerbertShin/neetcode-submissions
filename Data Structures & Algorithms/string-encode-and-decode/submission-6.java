class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int l = 0;

        for (int r = 0; r < str.length(); r ++) {
            while (str.charAt(r) != '#') {
                r ++;
            }

            int length = Integer.parseInt(str.substring(l, r));

            l = r + 1;
            r = l + length; 

            result.add(str.substring(l, r));

            l = r;
        }

        return result;
    }
}
