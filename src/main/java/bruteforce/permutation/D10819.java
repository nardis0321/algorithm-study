package bruteforce.permutation;

import java.util.Arrays;
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

        // Next permutation 방식이나 백트래킹이나 메모리/시간차이 미약

        /* 백트래킹 풀이 */
        // 모든 순열 개수 = 8! = 40320 가능
        // 하나씩 다 바꿔서 최대값인지 확인하기
//        b = new int[n];
//        visited = new boolean[n];
//        dfs(0, 0);
//        System.out.println(max);

        /* Next Permutation 풀이 */
        Arrays.sort(a);
        max = Math.max(max, sum());

        boolean flag = true;
        while (flag){
            flag = findNextPermutation();
        }

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

    static boolean findNextPermutation(){
        // 순열 왼<오인 지점 찾기
        int pivotIdx = -1;
        for (int i = n-1; i > 0; i--) {
            if(a[i-1] < a[i]){
                pivotIdx = i-1;
                break;
            }
        }

        if(pivotIdx == -1){
            return false;
        }

        // swap : pivot의 오른쪽에서 Pivot보다 크고 제일 작은 수
        int swapIdx = pivotIdx;
        int swapA = Integer.MAX_VALUE;
        for (int i = pivotIdx+1; i < n; i++) {
            if(a[pivotIdx] > a[i]){
                continue;
            }

            if(a[i] < swapA){
                swapIdx = i;
                swapA = a[i];
            }
        }
        swap(pivotIdx, swapIdx);

        // pivot 오른쪽 반전
        int left = pivotIdx+1;
        int right = n-1;
        while(left<right){
            swap(left, right);
            left++;
            right--;
        }

        max = Math.max(max, sum());
        return true;
    }

    static void swap(int idx1, int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static int sum(){
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.abs(a[i-1] - a[i]);
        }
        return sum;
    }

}
