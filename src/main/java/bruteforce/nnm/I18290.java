package bruteforce.nnm;

import java.util.Scanner;

public class I18290 {
    /**
     * NM과 K (1)
     * Silver 1
     */

    // N×M인 격자판에서 K칸 선택
    // 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값 구하기

    // 선택한 두 칸이 인접하면 안된다 (4방)
    // 1 ≤ N, M ≤ 10
    // 1 ≤ K ≤ min(4, N×M)
    // 격자판에 들어있는 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
    // 항상 K개의 칸을 선택할 수 있는 경우만 입력으로 주어진다.
    
    static int n, m, k;
    static int[][] grid;
    static int[] selected;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE; // 0 초기화 조심
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][m];
        selected = new int[k];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth){
        if(depth == k){
            int sum = 0;
            for (int i : selected) {
                sum += i;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                if(i >= 1 && visited[i-1][j]) continue;
                if(i < n-1 && visited[i+1][j]) continue;
                if(j >=1 && visited[i][j-1]) continue;
                if(j < m-1 && visited[i][j+1]) continue;

                selected[depth] = grid[i][j];
                visited[i][j] = true;
                dfs(depth+1);
                visited[i][j] = false;
            }
        }
    }
}
