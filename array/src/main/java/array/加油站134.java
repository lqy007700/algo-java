package array;

public class 加油站134 {
    public static void main(String[] args) {
        System.out.println(1 % 4);
        加油站134 a = new 加油站134();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        int i = a.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;

        // 依次遍历，i 每次到上次访问不到的下标
        /**
         * i => 开始下标
         * cnt => 从开始下标模拟步数   cnt == n 表示走完一圈
         * j => 模拟下标
         */
        while (i < n) {
            int cnt = 0;
            int sumGas = 0, sumCost = 0;

            while (cnt < n) {
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];

                if (sumGas < sumCost) {
                    break;
                }
                cnt++;
            }

            if (cnt == n) {
                return i;
            } else {
                i += cnt + 1;
            }
        }
        return i;
    }
}
