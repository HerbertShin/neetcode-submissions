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

                cols.computeIfAbsent(col, k -> new HashSet<>());

                // Check column validity
                if (cols.get(col).contains(board[row][col])) {
                    return false;
                }

                cols.get(col).add(board[row][col]);

                // Check row validity
                if (rows.get(row).contains(board[row][col])) {
                    return false;
                }

                rows.get(row).add(board[row][col]);

                String key = (row / 3) + "" + (col / 3);

                sections.computeIfAbsent(key, k -> new HashSet<>());

                // Check section validity
                if (sections.get(key).contains(board[row][col])) {
                    return false;
                }

                sections.get(key).add(board[row][col]);
            }    
        }
        
        return true;
    }
}
