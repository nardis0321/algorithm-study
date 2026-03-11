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
    static int[] integers;
    static char[][] signs;
    static String sign;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sign = br.readLine();
        signs = new char[n][n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                signs[i][j] = sign.charAt(idx++);
            }
        }
        integers = new int[n];

        dfs(0);
    }

    static boolean dfs(int depth){
        if(depth == n){
            for (int integer : integers) {
                System.out.println(integer+" ");
            }
            return true;
        }

        // 만들고, pruning
        for (int i = -10; i <= 10; i++) {

            boolean flag = true;
            integers[depth] = i;
            for (int j = 0; j <= depth; j++) {

                int sum = sum(j, depth);

                if(sum > 0 && signs[j][depth] == '+'){
                } else if (sum < 0 && signs[j][depth] == '-'){
                } else if(sum == 0 && signs[j][depth] == '0'){
                } else {
                    flag = false;
                }
            }

            if(flag){
                if(dfs(depth+1)) return true;
            }
        }
        return false;
    }

    static int sum(int i, int j){
        int result = 0;
        for (int k = i; k <= j; k++) {
            result += integers[k];
        }
        return result;
    }

}
