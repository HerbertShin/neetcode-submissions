class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] sArr = s.toCharArray();

        int left = 0;
        int right = sArr.length - 1;

        while (left < right) {
            if (Character.toLowerCase(sArr[left]) != Character.toLowerCase(sArr[right])) return false;

            left ++;
            right --;
        }

        return true; 
    }
}
