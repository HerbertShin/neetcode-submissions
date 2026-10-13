class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length())
            .append("#")
            .append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (j < str.length() && str.charAt(j) != '#') j++;

            Integer length = Integer.parseInt(str.substring(i, j));

            i = j + 1;

            int end = i + length;

            result.add(str.substring(i, end));

            i = end;
        }

        return result;
    }
}
