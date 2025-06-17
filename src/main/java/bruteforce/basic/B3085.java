package bruteforce.basic;

import java.util.Scanner;

public class B3085 {

    public static void main(String[] args) {

        //첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
        //다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
        //사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();  // 개행 처리
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
        // 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다. > LIS?
        // 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

        // 모든 인접한 두 칸을 바꿔보고, 그때마다 최대 연속 길이를 구해보기
        int LIS = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                // 인접한 두 칸을 교환 - 가로
                char temp = board[i][j];
                board[i][j] = board[i][j-1];
                board[i][j-1] = temp;

                // 최대 연속 길이 계산
                for (int k = 0; k < N; k++) {
                    int cnt = 1;
                    int cnt2 = 1;
                    for (int l = 0; l < N-1; l++) {
                        if(board[k][l] == board[k][l+1]){
                            cnt++;
                        } else {
                            LIS = Math.max(LIS, cnt);
                            cnt = 1;
                        }

                        if(board[l][k] == board[l+1][k]){
                            cnt2++;
                        } else {
                            LIS = Math.max(LIS, cnt2);
                            cnt2 = 1;
                        }
                    }
                    LIS = Math.max(LIS, cnt);
                    LIS = Math.max(LIS, cnt2);
                }

                // 인접한 두 칸을 교환 - 가로 - 를 원상복구
                board[i][j-1] = board[i][j];
                board[i][j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                // 인접한 두 칸을 교환 - 세로
                char temp = board[j][i];
                board[j][i] = board[j-1][i];
                board[j-1][i] = temp;

                // 최대 연속 길이 계산
                for (int k = 0; k < N; k++) {
                    int cnt = 1;
                    int cnt2 = 1;
                    for (int l = 0; l < N-1; l++) {
                        if(board[k][l] == board[k][l+1]){
                            cnt++;
                        } else {
                            LIS = Math.max(LIS, cnt);
                            cnt = 1;
                        }

                        if(board[l][k] == board[l+1][k]){
                            cnt2++;
                        } else {
                            LIS = Math.max(LIS, cnt2);
                            cnt2 = 1;
                        }
                    }
                    LIS = Math.max(LIS, cnt);
                    LIS = Math.max(LIS, cnt2);
                }

                // 인접한 두 칸을 교환 - 세로 - 를 원상복구
                board[j-1][i] = board[j][i];
                board[j][i] = temp;
            }
        }
        System.out.println(LIS);
    }
}
