package dp.basic;

import java.util.Scanner;

public class A9095 {
    public static void main(String[] args) {
        // 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

        // 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
        // 정수 n이 주어진다. n은 양수이며 11보다 작다.
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();
        int[] cases = new int[T+1];
        for (int i = 1; i <= T; i++) {
            cases[i] = sc.nextInt();
        }


        // 큰 문제를 작은 문제로 나누기 : 1 2 3 으로 만들기 -> 마지막에 뭘 쓰는지
        // N -  1   2   3
        // 1    1   0   0
        // 2    1   1   0
        // 3    2   1   1
        // 4    4   2   1
        // 5    7   4   2
        // n    dp[n-1] dp[n-2] dp[n-3]
        int[][] dp = new int[12][4];    // n일 때 1만, 2까지, 3까지 사용
        for (int i = 0; i < 12; i++) {
            if(i == 1){
                dp[i][1] = 1;
                dp[i][2] = 0;
                dp[i][3] = 0;
            }
            if(i == 2){
                dp[i][1] = 1;
                dp[i][2] = 1;
                dp[i][3] = 0;
            }
            if(i == 3){
                dp[i][1] = 2;
                dp[i][2] = 1;
                dp[i][3] = 1;
            }
            if(i >= 4){
                for (int j = 1; j <= 3; j++) {
                    dp[i][1] += dp[i-1][j];
                    dp[i][2] += dp[i-2][j];
                    dp[i][3] += dp[i-3][j];
                }
            }
        }

        for (int i = 1; i < T+1; i++) {
            int n = cases[i];
            int result = 0;
            for (int j = 1; j < 4; j++) {
                result += dp[n][j];
            }
            System.out.println(result);
        }

    }
}
