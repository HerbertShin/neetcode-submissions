class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return true;

        int n = board.length;

        HashMap<String, Set<Character>> sections = new HashMap<>();
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();

        for (int row = 0; row < n; row ++) {
            rows.put(row, new HashSet<>());

            for (int col = 0; col < n; col ++) {
                if (board[row][col] == '.') continue;

                String key = (row / 3) + "" + (col / 3);

                if (cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) ||
                sections.computeIfAbsent(key, k -> new HashSet<>()).contains(board[row][col])) {
                    return false;
                }

                cols.get(col).add(board[row][col]);
                rows.get(row).add(board[row][col]);
                sections.get(key).add(board[row][col]);
            }    
        }
        
        return true;
    }
}
