package array;

import java.util.*;

public class N皇后 {
    public static void main(String[] args) {
//        [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        N皇后 a = new N皇后();
        List<List<String>> res = a.solveNQueens(4);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        // 列
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        int[] row = new int[n];
        Arrays.fill(row, -1);

        dfs(res, row, n, 0, column, diagonals1, diagonals2);

        return res;
        /**
         *   0 1 2 3 4
         * 0 1 2 3 4 5
         * 1 1 2 3 4 5
         * 2 1 2 3 4 5
         * 3 1 2 3 4 5
         * 4 1 2 3 4 5
         *
         * Q...,
         * .Q..,
         * ..Q.,
         * ...Q
         */

    }

    public void dfs(List<List<String>> res, int[] rows, int n, int r, Set<Integer> column, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (r == n) {
            res.add(buildQueen(rows, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (column.contains(i)) {
                continue;
            }
            int diagonal1 = r - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = r + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }

            rows[r] = i;
            column.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);

            dfs(res, rows, n, r + 1, column, diagonals1, diagonals2);

            rows[r] = -1;
            column.remove(i);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public List<String> buildQueen(int[] rows, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[rows[i]] = 'Q';

            res.add(new String(c));
        }
        return res;
    }
}