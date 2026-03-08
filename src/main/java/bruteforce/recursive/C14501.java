package bruteforce.recursive;

import java.util.Scanner;

public class C14501 {
    /**
     * 14501 퇴사
     * 실버 3
     */

    // N+1일째에 퇴사, n일 동안 최대한 많은 상담
    // 상담 = 상담을 완료하는데 걸리는 기간 Ti + 상담을 했을 때 받을 수 있는 금액 Pi
    // 상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다.
    // 최대 수익을 구하는 프로그램
    static int n;
    static int[] t, p;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // (1 ≤ N ≤ 15)
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {   // (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        dfs(1, 0);
        System.out.println(max);
    }

    /**
     * dqy: 오늘 날짜
     * n+1: 퇴사 다음날
     */
    static void dfs(int day, int income){
        // 종료 : 퇴사 다음날
        if(day > n){
            max = Math.max(income, max);
            return;
        }

        // 선택, dfs, 복구
        if(t[day-1] + day <= n+1){
            dfs(day + t[day-1], income + p[day-1]);
        }
        dfs(day+1, income);
    }
}
