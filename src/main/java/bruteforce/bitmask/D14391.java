package bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D14391 {
    /**
     * 종이 조각
     * 골드 3
     * 숫자가 적힌 직사각형을 가로줄/세로줄로 잘라 가장 큰 합을 만드는 문제
     *
     * 풀이
     * 비트마스크로 0을 가로 1로 세로로 표현하여 총합 브루트포스
     * 백준 서비스 종료로 맞췄는지 모르겠지만 예제 4개 모두 통과.
     */

    static int n, m;
    static int[][] grid;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        /* input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 기준으로 토큰 분리 > 이전 방식보다 안전
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        // bitmask, 0을 가로 1을 세로로 표현하기
        for (int mask = 0; mask < (1 << n*m); mask++) {
            int currentSum = 0, totalSum = 0;

            // 가로 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(isHorizontal(mask, i, j)){
                        currentSum = currentSum*10 + grid[i][j];
                    } else {
                        totalSum += currentSum;
                        currentSum = 0;
                    }
                }
                totalSum += currentSum;
                currentSum = 0;
            }

            // 세로 계산
            for (int j = 0; j < m; j++) {
                for (int i = 0; i < n; i++) {

                    if(isVertical(mask, i, j)){
                        currentSum = currentSum*10 + grid[i][j];
                    } else {
                        totalSum += currentSum;
                        currentSum = 0;
                    }
                }
                totalSum += currentSum;
                currentSum = 0;
            }

            max = Math.max(max, totalSum);
        }

        System.out.println(max);
    }

    static boolean isHorizontal(int mask, int i, int j){
        return (mask & (1 << (i*m + j))) == 0;
    }
    static boolean isVertical(int mask, int i, int j){
        return !isHorizontal(mask, i, j);
    }

}
