package bruteforce.nnm;

import java.util.Scanner;

public class B15650 {
    /**
     * N과 M (2)
     */

    // 1~N 중 M개 고른 수열
    // 중복 x
    // 오름차순

    static int n, m;
    static int[] permutation;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        permutation = new int[m];
        dfs(0, 1);
        System.out.println(sb);
    }

    // Key : 이전보다 큰 것만 고르자
    // start : 다음에 고를 수 있는 최소 숫자
    static void dfs(int depth, int start){
        // 종료 조건
        if(depth == m){
            for (int i = 0; i < m-1; i++) {
                sb.append(permutation[i]).append(" ");
            }
            sb.append(permutation[m-1]);
            sb.append("\n");
            return;
        }

        // 선택, 재귀, 복구
        for (int i = start; i <= n; i++) { // n과 m (1): 일단 선택 후 버림 > (2): 가능한 것만 선택
            permutation[depth] = i;
            dfs(depth+1, i+1);
        }

    }
}
