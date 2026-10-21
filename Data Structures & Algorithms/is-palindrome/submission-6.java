class Solution {
    public boolean isPalindrome(String s) {
        int r = s.length() - 1;

        for (int l = 0; l < r; l++) {
            while (!validCharacter(s.charAt(l)) && l < r) l++;
            while (!validCharacter(s.charAt(r)) && r > l) r --;

            if (!equivalent(s.charAt(l), s.charAt(r))) return false;

            r --;
        }

        return true;
    }

    private boolean validCharacter(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

    private boolean equivalent(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2); 
    }
}
