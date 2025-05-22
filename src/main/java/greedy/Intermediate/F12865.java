package greedy.Intermediate;

import java.util.*;

public class F12865 {

    public static void main(String[] args) {
        // 첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        // 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
        final int K = sc.nextInt();
        // 두 번째 줄부터 N개의 줄에 거쳐
        // 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
        //입력으로 주어지는 모든 수는 정수이다.
        int[] weights = new int[N+1];
        int[] values = new int[N+1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        // 배낭에 넣을 수 있는 물건들의 가치의 최댓값 출력하기
        // K보다 W의 총합이 작으면 되는데, 그런 경우의 수 중 최대의 V => 그리디만으로x DP

        // dp[i][j] = i번째 물건까지 고려했을 때, 무게 j에서의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {  // 물건 개수
            for (int j = 1; j <= K; j++) {  // 최대 무게
                // 현재 물건을 넣을 수 없는 경우 (i번째 물건의 무게 > 1~K)
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 현재 물건을 넣을 수 있는 경우
                else {
                    // 물건을 넣지 않는 경우와 넣는 경우 중 최댓값 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
