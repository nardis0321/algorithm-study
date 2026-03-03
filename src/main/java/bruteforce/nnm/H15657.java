package bruteforce.nnm;

import java.util.Arrays;
import java.util.Scanner;

public class H15657 {
    /**
     * N과 M (8)
     * Silver 3
     */

    // N개의 자연수 중에서 M개를 고른 수열
    // 같은 수를 여러 번 골라도 된다.
    // 비내림차순 : non-decreasing, <= 가능한 오름차순

    static int n, m;
    static int[] ns;
    static int[] permutation;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ns = new int[n];
        permutation = new int[m];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }
        Arrays.sort(ns);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start){
        if(depth == m){
            for (int i = 0; i < m-1; i++) {
                sb.append(permutation[i]).append(" ");
            }
            sb.append(permutation[m-1]).append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if(ns[i] < ns[start]) continue;
            permutation[depth] = ns[i];
            dfs(depth+1, i);
        }
    }
}
