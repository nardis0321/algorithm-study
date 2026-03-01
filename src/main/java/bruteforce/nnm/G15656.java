package bruteforce.nnm;

import java.util.Arrays;
import java.util.Scanner;

public class G15656 {
    /**
     * N과 M (7)
     * Silver 3
     */

    // N개의 자연수 중에서 M개를 고른 수열
    // 중복 o

    static int n, m;
    static int[] ns;
    static int[] permutation;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }

        Arrays.sort(ns);
        permutation = new int[m];
        
        dfs(0);
        System.out.println(sb);
    }
    
    static void dfs(int depth){
        if(depth == m){
            for (int i : permutation) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            permutation[depth] = ns[i];
            dfs(depth+1);
        }
    }
}
