package bruteforce.permutation;

import java.util.Scanner;

public class E10971 {
    /**
     * 외판원 순회 2
     * Traveling Salesman problem (TSP)
     * 실버 2
     */

    static int n; // (2 ≤ N ≤ 10)
    static int[][] w; // 1,000,000 이하의 양의 정수
    // w[j][j] = 도시 i에서 j로 가는 비용
    // 외판원의 순회에 필요한 최소 비용을 출력

    // i->j로 이동해서 출발 도시로 돌아가야함
    // 중복 불가
    // 갈 수 없는 경우 0임
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = sc.nextInt();
            }
        }

        visited[0] = true;
        dfs(1, 0, 0);
        System.out.println(min);
    }

    static void dfs(int depth, int cost, int formerCity){
        if(cost >= min){
            return;
        }

        if(depth == n){
            if(w[formerCity][0] != 0){
                min = Math.min(min, cost+w[formerCity][0]);
            }
            return;
        }

        for (int j = 0; j < n; j++) {
                if(w[formerCity][j] == 0) continue;

                if(!visited[j]){
                    visited[j] = true;
                    dfs(depth+1, cost + w[formerCity][j], j);
                    visited[j] = false;
                }
            }
    }
}
