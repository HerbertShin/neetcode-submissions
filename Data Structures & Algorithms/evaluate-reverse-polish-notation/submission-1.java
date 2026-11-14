class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);

        if (tokens.length == 2) return Integer.parseInt(tokens[1]);

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (!isOperator(s)) {
                stack.push(Integer.parseInt(s));
                continue;
            }

            int a = stack.pop();
            int b = stack.pop();

            stack.push(calculate(b, a, s));
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int calculate(int a, int b, String operation) {
        if (operation.equals("+")) return add(a, b);
        else if (operation.equals("-")) return subtract(a, b);
        else if (operation.equals("*")) return multiply(a, b);
        else if (operation.equals("/")) return divide(a, b);
        return 0;
    }
    
    private int add(int a, int b) { return a + b; }
    private int subtract(int a, int b) { return a - b; }
    private int multiply(int a, int b) { return a * b; }
    private int divide(int a, int b) { return a / b; }
}
