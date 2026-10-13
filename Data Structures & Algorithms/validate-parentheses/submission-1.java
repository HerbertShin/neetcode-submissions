class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c.equals('{')) {
                stack.push('}');
            } else if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('[')) {
                stack.push(']');
            } else if (!stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
