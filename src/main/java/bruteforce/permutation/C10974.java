package bruteforce.permutation;

import java.util.Scanner;

public class C10974 {
    /**
     * 모든 순열
     * 실버 3
     * 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력
     */

    // 백트래킹
    // 메모리 53,104KB	시간 1,652ms
    static int n;
    static int[] permutation;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        permutation = new int[n];
        visited = new boolean[n];

        dfs(0);
    }

    static void dfs(int depth){
        if(depth == n){
            for (int i = 0; i < n; i++) {
                System.out.print(permutation[i] +" ");
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                permutation[depth] = i+1;
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
