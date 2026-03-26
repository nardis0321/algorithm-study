package bruteforce.permutation;

import java.util.Scanner;

public class D10819 {
    /**
     * 차이를 최대로
     * 실버 2
     */

    // N개의 정수로 이루어진 배열 A
    static int n; // (3 ≤ N ≤ 8)
    static int[] a; // 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
    static int[] b;

    // 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
    // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
    static int max;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 모든 순열 개수 = 8! = 40320 가능
        // 하나씩 다 바꿔서 최대값인지 확인하기
        b = new int[n];
        visited = new boolean[n];
        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int depth, int sum){
        if(depth == n){
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                b[depth] = a[i];
                visited[i] = true;
                dfs(depth+1, depth == 0? 0 : sum + Math.abs(b[depth-1] - b[depth]));
                visited[i] = false;
            }
        }
    }

}
