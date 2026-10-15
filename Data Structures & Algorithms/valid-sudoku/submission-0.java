class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Brute Force

        if (board == null) return true;

        int n = board.length;

        for (int i = 0; i < n; i ++) {
            Set<Character> exists = new HashSet<>();

            for (int j = 0; j < n; j ++) {
                if (board[i][j] == '.') continue;

                if (exists.contains(board[i][j])) {
                    return false;
                }

                exists.add(board[i][j]);
            }
        }

        for (int i = 0; i < n; i ++) {
            Set<Character> exists = new HashSet<>();

            for (int j = 0; j < n; j ++) {
                if (board[j][i] == '.') continue;

                if (exists.contains(board[j][i])) {
                    return false;
                }

                exists.add(board[j][i]);
            }
        }

        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                Set<Character> exists = new HashSet<>();

                for (int row = i; row < i + 3; row ++) {
                    for (int col = j; col < j + 3; col ++) {
                        if (board[row][col] == '.') continue;

                        if (exists.contains(board[row][col])) {
                            return false;
                        }

                        exists.add(board[row][col]);
                    }   
                }    
            }
        }
        
        return true;
    }
}
