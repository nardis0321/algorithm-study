package bruteforce.bitmask;

import java.util.Scanner;

public class C14889 {

    // DFS 풀이       : 21,204kb	372ms
    // bitmask 풀이   : 20,692kb	404ms

    static int n; // (4 ≤ N ≤ 20, N은 짝수)
    static int[][] s; // i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji

    static boolean[] teamA;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        /* 입력 */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        teamA = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        // n명을 둘로 나눴을 때 Sij 총합 차이의 최솟값 구하기
        for (int mask = 0; mask < (1 << n); mask++) {
            if(Integer.bitCount(mask) != n/2) continue;

            int sumA = 0, sumB = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {

                    // i랑 j번째 비트가 둘다 on이면 sum
                    boolean isIA = (mask &(1 << i)) != 0; // == 1로 표현하면 안 됨!
                    boolean isJA = (mask &(1 << j)) != 0;

                    if(isIA && isJA) sumA += s[i][j] + s[j][i];
                    else if (!isIA && !isJA) sumB += s[i][j] + s[j][i];
                }
            }

            min = Math.min(min, Math.abs(sumA - sumB));
        }

        /* 출력 */
        System.out.println(min);

    }

    static void dfs(int depth, int start){
        if(depth == n/2){
            calculateS();
            return;
        }

        if(start == n) return;

        for (int i = start; i < n; i++) {
            if(!teamA[i]){
                teamA[i] = true;
                dfs(depth+1, i+1);
                teamA[i] = false;
            }
        }
    }

    static void calculateS(){
        int sumA = 0, sumB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(teamA[i] && teamA[j]){
                    sumA += s[i][j];
                } else if (!teamA[i] && !teamA[j]){
                    sumB += s[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(sumA - sumB));
    }

}
