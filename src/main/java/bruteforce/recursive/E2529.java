package bruteforce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2529 {
    /**
     * 부등호
     * 실버 1
     */

    // 0~9에서 K+1개 뽑은 순열
    // 중복 x
    // k개의 앞뒤 부등호를 만족
    // (k+1)자리의 정수 중에서 최댓값과 최솟값 찾기

    static int k;
    static boolean[] signFlag; // true면 < false면 >
    static char[] numArray;
    static String max = ""; // int로 다루기 1) 초과함 2) 포맷 안정성 bad
    static String min = "9999999999";
    static boolean[] selected = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine()); // 2 ≤ k ≤ 9
        numArray = new char[k+1];
        signFlag = new boolean[k];

        String[] signArray = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            if(signArray[i].equals("<")){
                signFlag[i] = true;
            }
        }

        dfs(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth){
        if(depth == k+1){
            String num = new String(numArray);
            if(num.compareTo(max) > 0) max = num;
            if(num.compareTo(min) < 0) min = num;

            // String.compareTo():
            // 사전순(lexicographical) 비교
            // '1' < '9'
            // "100" < "99"
            return;
        }


        for (int i = 0; i <= 9; i++) {
            if(selected[i]) continue;

            if(depth == 0
                    || signFlag[depth-1] && i > numArray[depth-1] - '0'
                    || !signFlag[depth-1] && i < numArray[depth-1] - '0')
            {
                selected[i] = true;
                numArray[depth] = (char) (i + '0');
                dfs(depth+1);
                selected[i] = false;
            }
        }

    }
}
