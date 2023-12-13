package array;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角118 {
    public static void main(String[] args) {

    }

    /**
     *
     *

                [1]
               [1,1]
              [1,2,1]
             [1,3,3,1]
            [1,4,6,4,1]

     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
