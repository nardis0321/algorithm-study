package greedy.basic.a;

import java.util.Scanner;

public class G10162 {
    public static void main(String[] args) {
        // 입력: 첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.
        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();

        // 로직: 버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.
        // A, B, C 3개의 버튼을 적절히 눌러서 그 시간의 합이 정확히 T초가 되도록 해야 한다
        // 최소버튼 조작 방법을 구하는 프로그램

        if (T % 10 != 0) {
            System.out.println(-1);
            sc.close();
            return;
        }

        int A = T / 300;
        int B = (T % 300) / 60;
        int C = ((T % 300) % 60) / 10;

        // 출력: T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다. 각각의 횟수 사이에는 빈 칸을 둔다. 해당 버튼을 누르지 않는 경우에는 숫자 0을 출력해야한다. 만일 제시된 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 첫 줄에 출력해야 한다.
        System.out.printf("%d %d %d",A,B,C);
        sc.close();
    }
}
