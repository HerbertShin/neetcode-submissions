class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0, left = 0, best = 0;
        int[] arr = new int[26];

        for (int right = 0; right < s.length(); right ++) {
            int pos = s.charAt(right) - 'A';
            arr[pos] ++;

            max = Math.max(max, arr[pos]);

            while (right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A'] --;
                left ++;
            }

            best = Math.max(best, right - left + 1);
        }

        return best;
    }
}
