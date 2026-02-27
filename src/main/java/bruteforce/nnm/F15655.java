package bruteforce.nnm;

import java.util.Arrays;
import java.util.Scanner;

public class F15655 {
    /**
     * N과 M (6)
     * Silver 3
     */

    // N개의 자연수 중에서 M개를 고른 수열
    // 고른 수열은 오름차순이어야 한다.
    // 중복n x

    static int n, m;
    static int[] ns;
    static int[] permutation;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ns = new int[n];
        permutation = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }

        Arrays.sort(ns);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start){
        // 종료
        if(depth == m){
            for (int i : permutation) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 선택, 재귀, 복구
        for (int i = start; i < n; i++) {
            if(!visited[i]){

                permutation[depth] = ns[i];
                visited[i] = true;
                dfs(depth+1, i+1);

                visited[i] = false;
            }
        }
    }
}
