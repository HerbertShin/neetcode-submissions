class MinStack {
    private List<Integer> stack;
    private List<Integer> minArr;
    
    public MinStack() {
        this.stack = new ArrayList<>();
        this.minArr = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        
        if (this.minArr.size() == 0) {
            this.minArr.add(val);
        } else {
            int min = Math.min(val, this.minArr.get(this.minArr.size() - 1));
            this.minArr.add(min);
        }
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
        this.minArr.remove(this.minArr.size() - 1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }
    
    public int getMin() {
        return this.minArr.get(this.minArr.size() - 1);
    }
}
