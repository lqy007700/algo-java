package array;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角II119 {
    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> preRow = new ArrayList<>();

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            preRow = row;
        }

        return preRow;
    }
}
