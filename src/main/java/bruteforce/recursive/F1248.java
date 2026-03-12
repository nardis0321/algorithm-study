package bruteforce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F1248 {
    /**
     * Guess
     * 골드 3
     */

    // Sij= ai부터 aj까지의 합에 따라 + 0 -
    static int n;
    static char[][] signs;
    static int[] integers;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        signs = new char[n][n];
        integers = new int[n];
        sum = new int[n];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                signs[i][j] = line.charAt(idx++);
            }
        }

        dfs(0);
    }

    static boolean dfs(int depth){
        if(depth == n){
            for (int integer : integers) {
                System.out.print(integer+" ");
            }
            return true;
        }

        // 만들고, pruning
        for (int i = -10; i <= 10; i++) {

            boolean flag = true;
            integers[depth] = i;
            sum[depth] = i;
            if(depth > 0) sum[depth] += sum[depth-1];

            for (int j = 0; j <= depth; j++) {
                if(sum(j, depth) > 0 && signs[j][depth] != '+'
                || sum(j, depth) < 0 && signs[j][depth] != '-'
                || sum(j, depth) == 0 && signs[j][depth] != '0') {
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(dfs(depth+1)) return true;
            }
        }
        return false;
    }

    static int sum(int start, int last){
        if(start>0){
            return sum[last] - sum[start-1];
        }
        return sum[last];
    }

}