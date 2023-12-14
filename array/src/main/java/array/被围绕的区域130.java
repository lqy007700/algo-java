package array;

public class 被围绕的区域130 {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m - 1, n, m);
        }

        for (int j = 1; j < m - 1; j++) {
            dfs(board, 0, j, n, m);
            dfs(board, n - 1, j, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y, n, m);
        dfs(board, x - 1, y, n, m);
        dfs(board, x, y + 1, n, m);
        dfs(board, x, y - 1, n, m);
    }
}
