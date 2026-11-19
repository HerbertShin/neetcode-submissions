class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;

        int[] subarray = findSubarray(matrix, target);

        if (subarray != null) {
            return targetElementExists(subarray, target);
        }

        return false; 
    }

    private int[] findSubarray(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int firstElement = matrix[m][0];
            int lastElement = matrix[m][matrix[m].length - 1];

            if (target <= lastElement && target >= firstElement) {
                return matrix[m];
            } else if (target > lastElement) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return null;
    }

    private boolean targetElementExists(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == target) {
                return true;
            } else if (target > arr[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
