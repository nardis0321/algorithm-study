package bruteforce.recursive;

import java.util.Scanner;

public class D14889 {
    /**
     * 14889 스타트와 링크
     * 실버 1
     */

    static int n; // (4 ≤ N ≤ 20, N은 짝수)
    static int[][] s;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // n명을 두 팀으로 나눈다
        // 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치
        // 두 팀의 능력치 차이를 최소로 하기

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        selected = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    static void dfs(int cnt, int start){
        // 종료
        if(cnt == n/2){
            calculateTeamStatus();
            return;
        }
        if(start == n) return;

        // 선택, dfs, 복구
        for (int i = start; i < n; i++) {
            selected[i] = true;
            dfs(cnt+1, i+1);
            selected[i] = false;
        }
    }

    // 능력치 계산
    static void calculateTeamStatus(){
        int start = 0;
        int link = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(selected[i] && selected[j]){
                    start += s[i][j];
                } else if(!selected[i] && !selected[j]){
                    link += s[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(start - link));
    }
}
