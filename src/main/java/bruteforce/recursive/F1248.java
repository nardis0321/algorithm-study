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
    static int[] sum; // sum[k] = a0 + a1 + ... + ak   (prefix sum), 0~k
    static int[] runningSum; // sum[j] = a_j + a_{j+1} + ... + a_depth, j~depth

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        signs = new char[n][n];
        integers = new int[n];
        runningSum = new int[n];

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

            boolean ok = true;
            integers[depth] = i;

            for (int j = depth; j >= 0; j--) {  // Sij보다 Sii가 더 강력한 조건이니까 j = depth로 시작
                runningSum[j] += i; // j-depth 합

                int sum = runningSum[j];
                int sign = signs[j][depth];

                if(sum > 0 && sign != '+') ok = false;
                if(sum < 0 && sign != '-') ok = false;
                if(sum == 0 && sign != '0') ok = false;

                if(!ok) break;
            }

            if(ok && dfs(depth+1)) return true;
        }
        return false;
    }

}