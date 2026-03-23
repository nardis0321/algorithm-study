package bruteforce.permutation;

import java.util.Scanner;

public class C10974 {
    /**
     * 모든 순열
     * 실버 3
     * 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력
     */

    // 백트래킹 : 메모리 53,104KB	시간 1,652ms
    // Next Permutation : 백트래킹이랑 비교해서 코드길이 두 배, 메모리 절반, 시간 1/5
    static int n;
    static int[] permutation;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        permutation = new int[n];
//        visited = new boolean[n];
//
//        dfs(0);


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            permutation[i] = i+1;
        }

        boolean flag = true;
        while (flag){
            for (int i = 0; i < n; i++) {
                sb.append(permutation[i]).append(" ");
            }
            sb.append("\n");
            flag = findNextPermutation();
        }

        System.out.println(sb);
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

    static boolean findNextPermutation(){
        int pivot = findPivot();
        if(pivot == -1) return false;

        int idx = n-1;
        int min = n+1;
        int minIdx = 0;
        // 오른쪽에서 제일 작은거, 자신보다 큰 거
        while(idx > pivot){
            if(permutation[idx] < permutation[pivot]){
                idx--;
                continue;
            }
            if(permutation[idx] < min){
                min = permutation[idx];
                minIdx = idx;
            }
            idx--;
        }
        swap(pivot, minIdx);

        // reverse 오른쪽
        int left = pivot+1;
        int right = n-1;
        while(left < right){
            swap(left, right);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int a, int b){
        int temp = permutation[a];
        permutation[a] = permutation[b];
        permutation[b] = temp;
    }

    static int findPivot(){
        int pivot = -1;
        int idx = n-1;
        while(idx > 0){
            if(permutation[idx-1] < permutation[idx]){
                pivot = idx-1;
                break;
            }
            idx--;
        }
        return pivot;
    }
}