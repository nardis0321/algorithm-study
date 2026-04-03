package bruteforce.permutation;

import java.util.Scanner;

public class F6603 {
    /**
     * 로또
     * 실버 2
     *
     */

    static int k; // (6 < k < 13)
    static int[] s; // 오름차순
    // k개의 집합 s에서 6개의 숫자를 고르는 모든 방법
    
    static int[] lotto = new int[6];
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        while(k != 0){
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }
            visited = new boolean[k];

            dfs(0, 0);

            sb.append("\n");
            k = sc.nextInt();
        }
        System.out.println(sb);
    }
    
    static void dfs(int depth, int start){
        if(depth == lotto.length){
            for (int i : lotto) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if(!visited[i]){
                visited[i] = true;
                lotto[depth] = s[i];
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
        
    }
}
