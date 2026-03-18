package bruteforce.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class A10972 {

    // 1 - N 순열, 사전순으로 다음에 오는 순열 구하기

    // 1. 백트래킹으로 사전순의 순열 생성 > 주어진 순열을 찾은 뒤 그 다음 순열을 출력
    // 2. Next permutation algorithm : 지금 순열보다 크면서 가장 가까운 순열 찾기

    static int n;
    static int[] input;
    static int[] permutation;
    static boolean[] visited;
    static boolean found;
    static boolean finished;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n];
        permutation = new int[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

//        boolean isLast = true;
//        for (int i = 0; i < n; i++) {
//            if(input[i] != n-i){
//                isLast = false;
//                break;
//            }
//        }
//        if(isLast){
//            System.out.println(-1);
//        } else {
//            dfs(0);
//        }

        // 뒤에서부터 확인. 이미 내림차순이면 어떻게 바꿔도 더 큰 순열을 만들 수 없다
        // 뒤에서부터 보면서 처음으로 증가하는 지점은 어디일까?
        int targetIdx = -1;
        for (int i = n-1; i >= 1; i--) {
            if(permutation[i-1] < permutation[i]){
                targetIdx = i-1;
                break;
            }
        }

        if(targetIdx == -1){
            System.out.println(-1);

            // pivot을 찾았으면 오른쪽에서 pivot보다 큰 값 중에 가장 작은 값 선택해서 스왑하기
        } else {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;

            for (int i = targetIdx+1; i < n; i++) {
                if(permutation[targetIdx] < permutation[i]){
                    if(permutation[i] < min){
                        min = permutation[i];
                        minIdx = i;
                    }
                }
            }

            permutation[minIdx] = permutation[targetIdx];
            permutation[targetIdx] = min;

            // pivot 오른쪽 suffix 반전
            int left = targetIdx+1;
            int right = n-1;
            while(left<right){
                int temp = permutation[left];
                permutation[left] = permutation[right];
                permutation[right] = temp;

                left++;
                right--;
            }

            for (int i : permutation) {
                System.out.print(i+" ");
            }
        }
    }
    
    static void dfs(int depth) {
        if(finished) return;

        if(depth == n){
            if(found){
                for (int i : permutation) {
                    System.out.print(i + " ");
                }
                finished = true;
                return;
            }

            if(Arrays.equals(permutation, input)) found = true;
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