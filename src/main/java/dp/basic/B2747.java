package dp.basic;

import java.util.Scanner;

public class B2747 {

    // 완전 이진 트리 형태로 호출 -> 시간복잡도는 O(2^n) -> DP 사용 O(n)
    // 재귀 호출이 최대 n번까지 쌓일 수 있음 -> 함수 호출 스택이 n 깊이 -> 공간 복잡도는 O(n)

    public static void main(String[] args) {
        // 첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 첫째 줄에 n번째 피보나치 수를 출력한다.
        int[] dp = new int[46];

        // 기저 조건
        dp[0] = 0;
        dp[1] = 1;

        // 점화식
        for (int i = 2; i < 46; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        // 출력
        System.out.println(dp[n]);
    }
}
