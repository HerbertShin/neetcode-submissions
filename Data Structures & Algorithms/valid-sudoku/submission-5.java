class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] sections = new int[9];

        int n = board.length;

        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < n; col ++) {
                if (board[row][col] == '.') continue;

                int bit = 1 << (board[row][col] - '1');
                int section = (row / 3) * 3 + (col / 3);
                
                if (((rows[row] | cols[col] | sections[section]) & bit) != 0) {
                    return false;
                }

                rows[row] |= bit;
                cols[col] |= bit;
                sections[section] |= bit;
            }
        }

        return true;
    }
}
