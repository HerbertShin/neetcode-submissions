class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mapping = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        mapping.put(']', '[');
        mapping.put('}', '{');
        mapping.put(')', '(');

        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.peek()) {
                    return false;
                }

                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
