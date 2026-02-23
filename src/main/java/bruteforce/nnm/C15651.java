package bruteforce.nnm;

import java.util.Scanner;

public class C15651 {
    /**
     * N과 M (3)
     */

    // 1~N 중 M개를 고른 순열
    // 중복O

    static int n, m;
    static int[] permutation;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        permutation = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        // 종료
        if(depth == m) {
            for (int i = 0; i < m - 1; i++) {
                sb.append(permutation[i]).append(" ");
            }
            sb.append(permutation[m - 1]);
            sb.append("\n");
            return;
        }

        // 선택, 재귀, 복구
        for (int i = 0; i < n; i++) {
            permutation[depth] = i+1;
            dfs(depth+1);
        }
    }

}
