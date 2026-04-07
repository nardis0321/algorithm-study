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

    // next permutation
    // 0을 선택 1을 비선택으로 설정, Next permutation 찾기로 사전순 보장
    // 메모리, 시간 더 많이 씀 (dfs와 큰 차이 x)
    static int[] selected;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        /* dfs */
//        while(k != 0){
//            s = new int[k];
//            for (int i = 0; i < k; i++) {
//                s[i] = sc.nextInt();
//            }
//            visited = new boolean[k];
//
//            dfs(0, 0);
//
//            sb.append("\n");
//            k = sc.nextInt();
//        }


        /* next permutation */
        while(k != 0){
            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }

            selected = new int[k];
            for (int i = 6; i < k; i++) {
                selected[i] = 1;
            }

            do {
                for (int i = 0; i < k; i++) {
                    if(selected[i] == 0){
                        sb.append(s[i]).append(" ");
                    }
                }
                sb.append("\n");
            } while (findNextLotto());
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

    static boolean findNextLotto(){
        // 0 0 0 1 1 1 1 1 1 이렇게 시작해서
        // 0 0 1 0 1 1 1 1 1
        // 0 0 1 1 0 1 1 1 1
        // ...
        // 0 0 1 1 1 1 1 1 0 reverse 필요한 예시
        // 0 1 0 0 1 1 1 1 1
        // ...
        // 0 1 1 1 1 0 1 0 0
        // 0 1 1 1 1 1 0 0 0
        // 1 1 1 1 1 0 0 0 1
        // 1 1 1 1 1 0 0 1 0
        // 1 1 1 1 1 0 1 0 0
        // 1 1 1 1 1 1 0 0 0 으로 끝내기

        // pivot : 오른쪽부터 찾아서 < 지점 찾기
        int pivotIdx = -1;
        for (int i = selected.length-1; i > 0; i--) {
            if(selected[i-1] < selected[i]){
                pivotIdx = i-1;
                break;
            }
        }

        if(pivotIdx == -1){
            return false;
        }

        // swap : 오른쪽에서 Pivot보다 큰 값 중에 제일 작은 거 - 여기서는 오른쪽 젤 가까운 1이면 ㅇㅋ
        swap(pivotIdx, pivotIdx+1);

        // reverse : 오른쪽 reverse
        int left = pivotIdx+2;
        int right = k-1;
        while(left < right){
            swap(left, right);
            left++;
            right--;
        }

        return true;
    }

    static void swap(int idx1, int idx2){
        int temp = selected[idx1];
        selected[idx1] = selected[idx2];
        selected[idx2] = temp;
    }
}
