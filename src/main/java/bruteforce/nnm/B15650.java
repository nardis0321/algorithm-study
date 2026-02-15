package bruteforce.nnm;

import java.util.Scanner;

public class B15650 {
    /**
     * N과 M (2)
     */

    // 1~N 중 M개 고른 수열
    // 중복 x
    // 오름차순

    static int[] permutation;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        permutation = new int[m];
        visited = new boolean[n];
        dfs(0, n, m);
        System.out.println(sb);
    }

    static void dfs(int depth, int n, int m){
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
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                if(depth >= 1 && permutation[depth-1] > i+1) continue;
                permutation[depth] = i+1;
                visited[i] = true;

                dfs(depth+1, n, m);

                visited[i] = false;
            }
        }

    }
}
