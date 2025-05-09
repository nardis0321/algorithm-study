package dp.basic;

import java.util.Scanner;

public class A9095 {
    public static void main(String[] args) {
        // 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

        // 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
        // 정수 n이 주어진다. n은 양수이며 11보다 작다.
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 큰 문제를 작은 문제로 나누기 : 1 2 3 으로 만들기 -> 마지막에 뭘 쓰는지
        // N -  1   2   3
        // 1    1   0   0
        // 2    1   1   0
        // 3    2   1   1
        // 4    4   2   1
        // 5    7   4   2
        // n    dp[n-1] dp[n-2] dp[n-3]

        // 기저 조건
        int[] dp = new int[12];
        dp[0] = 1;  // 편의상
        dp[1] = 1;
        dp[2] = 2;
        dp[4] = 4;

        // 점화식 (바텀업)
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        // 입력 > 출력
        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
