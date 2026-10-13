class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) left ++;
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) right --;

            char leftChar = Character.toUpperCase(s.charAt(left));
            char rightChar = Character.toUpperCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}
