class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        if (strs.isEmpty()) {
            return "";
        }

        for (String str : strs) {
            sb.append(str.length()).append("#");
            for (char c : str.toCharArray()) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));

            j++;

            decoded.add(str.substring(j, j + len));

            i = j + len;
        }
        
        return decoded;
    }
}
