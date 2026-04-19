package bruteforce.bitmask;
import java.util.Scanner;

public class B1182 {
    // N개의 정수로 이루어진 수열이 있을 때,
    // 크기가 양수인 부분수열 중에서
    // 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

    static int n, s; // (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
    static int[] sequence; // 정수의 절댓값은 100,000을 넘지 않는다.
    static int cnt;

    public static void main(String[] args){
        /* 입력 */
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }

        /* dfs 풀이*/
        dfs(0, 0);
        if(s == 0) cnt--; // 부분수열의 크기가 양수가 아닌 경우 1회
        int dfsAnswer = cnt;

        /* bitmask 풀이*/
        // n개의 숫자에서 선택1하거나 안0 하거나
        cnt = 0;
        for (int mask = 1; mask < (1 << n); mask++) { // 크기가 양수니까 1에서 시작
            int sum = 0;

            for (int i = 0; i < n; i++) {
                // mask의 i번째 비트가 1이면 → i번째 숫자 포함
                if((mask & (1 << i)) != 0){ // == 1로 표현하면 안 됨!
                    sum += sequence[i];
                }
            }

            if(sum == s) cnt++;
        }


        /* 출력 */
        System.out.println(cnt);
    }

    static void dfs(int depth, int sum){
        if(depth == n){
            if(sum == s) cnt++;
            return;
        }

        dfs(depth+1, sum + sequence[depth]);
        dfs(depth+1, sum);
    }
}