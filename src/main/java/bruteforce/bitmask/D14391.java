package bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    static int[][] nums;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        /* input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        n = firstLine.charAt(0) - '0';
        m = firstLine.charAt(2) - '0';
        nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                nums[i][j] = line.charAt(j) - '0';
            }
        }

        // bitmask, 0을 가로 1을 세로로 표현하기
        for (int mask = 0; mask < (1 << n*m); mask++) {
            int sum = 0, total = 0;

            // 가로 계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(isHorizontal(mask, i, j)){
                        sum = sum*10 + nums[i][j];

                        if(j == m-1){
                            total += sum;
                            sum = 0;
                        }
                    } else {
                        total += sum;
                        sum = 0;
                    }
                }
            }

            // 세로 계산
            // 주의점 : mask는 가로 방향으로 늘어남
            // 세로 크기 최대 4
            int[] verticalSum = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if(isVertical(mask, i, j)){
                        if(i >= 1 && isVertical(mask, i-1, j)){ // 연속된 세로인지
                            verticalSum[j] = verticalSum[j]*10 + nums[i][j];
                        } else {
                            verticalSum[j] += nums[i][j];
                        }

                        if(i == n-1){ // 마지막 행
                            total += verticalSum[j];
                            verticalSum[j] = 0;
                        }
                    } else { // 가로
                        total += verticalSum[j];
                        verticalSum[j] = 0;
                    }
                }
            }

            max = Math.max(max, total);
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
