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
    static int[] path;

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

        /* dfs 풀이 */
//        visited[0] = true;
//        dfs(1, 0, 0);
//        System.out.println(min);

        /* next permutation 풀이
        1부터 n-1까지의 순열 만들기 */
        path = new int[n-1];
        for (int i = 1; i < n; i++) {
            path[i-1] = i;
        }

        do {
            min = Math.min(min, calculateCost(path));
        } while (findNextPermutation(path));

        System.out.println(min);
    }


    static int calculateCost(int[] path) {
        int sum = 0;
        if (w[0][path[0]] == 0) return Integer.MAX_VALUE;
        sum += w[0][path[0]];

        for (int i = 0; i < n-2; i++) {
            int curr = path[i];
            int next = path[i+1];
            if(w[curr][next] == 0) return Integer.MAX_VALUE;
            sum += w[curr][next];
        }

        if(w[path[n-2]][0] == 0) return Integer.MAX_VALUE;
        sum += w[path[n-2]][0];

        return sum;
    }

    static boolean findNextPermutation(int[] arr){
        // pivot
        int pivotIdx = -1;
        for (int i = arr.length-1; i > 0 ; i--) {
            if(arr[i-1] < arr[i]){
                pivotIdx = i-1;
                break;
            }
        }

        if(pivotIdx == -1) return false;

        // swap
        for (int i = arr.length-1; i > pivotIdx; i--) {
            if(arr[pivotIdx] < arr[i]){
                swap(i, pivotIdx);
                break;
            }
        }

        // reverse
        int left = pivotIdx+1;
        int right = arr.length-1;
        while(left < right){
            swap(left, right);
            left++;
            right--;
        }

        return true;
    }

    static void swap(int idx1, int idx2) {
        int temp = path[idx1];
        path[idx1] = path[idx2];
        path[idx2] = temp;
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
