package array;

public class 单词搜索79 {
    public static void main(String[] args) {
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        see
        单词搜索79 a = new 单词搜索79();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean see = a.exist(board, "SEE");
        System.out.println(see);
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        // 标记位
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 尝试从每个节点开始进行匹配
                boolean checked = check(board, visited, i, j, word, 0);
                if (checked) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }

        int[][] addr = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        boolean res = false;
        visited[i][j] = true;
        for (int[] ad : addr) {
            int newI = i + ad[0], newJ = j + ad[1];
            if (newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length) {
                if (!visited[newI][newJ]) {
                    boolean checked = check(board, visited, newI, newJ, word, k + 1);
                    if (checked) {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
