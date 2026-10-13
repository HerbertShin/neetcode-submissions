class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1; 

        while(left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) left ++;
            while (!Character.isLetterOrDigit(s.charAt(right)) && right > left) right --;

            Character leftChar = Character.toLowerCase(s.charAt(left));
            Character rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) return false;

            left ++;
            right --;
        }

        return true;
    }
}
