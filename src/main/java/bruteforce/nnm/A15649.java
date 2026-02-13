package bruteforce.nnm;

import java.util.*;

public class A15649 {
    /**
     * N과 M (1)
     * Silver 3
     */

    // 1~N 중에 M개 고른 순열
    // 중복 x

    static int[] sequence;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    // 마지막 출력 sout > sb 차이
    // 메모리 78,824 kb	시간 1,724 ms
    // 메모리 27,692 kb	시간   268 ms

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 모두 출력
        // 오름차순
        sequence = new int[m];
        visited = new boolean[n];
        dfs(0, n, m);
        System.out.println(sb);
    }

    // 시도 1 고친 점
    // | 항목 | 지금 코드 | 바꾸기      |
    // |  -- | -----   | ---------- |
    // | 기준 | 숫자 x   | depth      |
    // | 분기 | 포함/제외 | 모든 수 시도  |
    // | 중복 | 제어 없음 | visited 필요 |
    // | 순서 | 고정     | 자유         |

    // dfs(depth) : depth번째 자리에 넣을 숫자 고르기
    static void dfs(int depth, int n, int m){
        // 종료
        if(depth == m){
            for (int i = 0; i < m-1; i++) {
                sb.append(sequence[i]).append(" ");
            }
            sb.append(sequence[m-1]);
            sb.append("\n");
            // 여기 초기화 하는 실수 x
            return;
        }

        // 분기x 전부방문
        for (int i = 1; i <= n; i++) {
            if(!visited[i-1]){
                // 선택
                sequence[depth] = i;
                visited[i-1] = true;
                // 재귀
                dfs(depth+1, n, m);
                // 복구
                visited[i-1] = false;
            }
        }
    }
}
