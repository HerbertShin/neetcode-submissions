class MedianFinder {
    private List<Integer> nums;

    public MedianFinder() {
        nums = new ArrayList<>();       
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        int size = nums.size();
        
        Collections.sort(nums);

        if (size % 2 == 0) {
            return (nums.get(size / 2) + nums.get(size / 2 - 1)) / 2.0;
        } else {
            return nums.get((size / 2));
        }
    }
}
