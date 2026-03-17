package bruteforce.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class A10972 {

    // 1 - N 순열, 사전순으로 다음에 오는 순열 구하기
    // 백트래킹으로 사전순의 순열 생성 > 주어진 순열을 찾은 뒤 그 다음 순열을 출력

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

        boolean isLast = true;
        for (int i = 0; i < n; i++) {
            if(input[i] != n-i){
                isLast = false;
                break;
            }
        }
        if(isLast){
            System.out.println(-1);
        } else {
            dfs(0);
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