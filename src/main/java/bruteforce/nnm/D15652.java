package bruteforce.nnm;

import java.util.Scanner;

public class D15652 {
    /**
     * N과 M (4)
     */

    // 1부터 N까지 자연수 중에서 M개를 고른 수열
    // 중복 o
    // 수열은 비내림차순(non-decreasing)
    // 비내림차순? 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족
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
        for (int i = start; i <= n; i++) {
            permutation[depth] = i;
            dfs(depth+1, i);
        }
    }
}
