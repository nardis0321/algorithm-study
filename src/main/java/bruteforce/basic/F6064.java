package bruteforce.basic;

import java.util.Scanner;

public class F6064 {
    // 시간초과

    // 1 ≤ M, N ≤ 40,000
    // M * N = 1,600,000,000 (16억)
    public static void main(String[] args) {
        // 입력 데이터는 표준 입력을 사용한다.
        // 입력은 T개의 테스트 데이터로 구성된다.
        // 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // 각 테스트 데이터는 한 줄로 구성된다.
        // 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다.
        // (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N) 여기서 <M:N>은 카잉 달력의 마지막 해를 나타낸다.
        int[] M = new int[T];
        int[] N = new int[T];
        int[] x = new int[T];
        int[] y = new int[T];
        for (int i = 0; i < T; i++) {
            M[i] = sc.nextInt();
            N[i] = sc.nextInt();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 출력은 표준 출력을 사용한다. 각 테스트 데이터에 대해, 정수 k를 한 줄에 출력한다.
        // 여기서 k는 <x:y>가 k번째 해를 나타내는 것을 의미한다.
        // 만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.

        //  M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현
        // 예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다.
        // <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다.

        // <x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자. 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다. 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다.
        // <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다.
        // 네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.

        for (int i = 0; i < T; i++) {
            int result = -1;
            for (int j = 1; j <= M[i]*N[i]; j++) {
                boolean rightX = false;
                if(x[i] == M[i]){
                    if(j%M[i] == 0){
                        rightX = true;
                    }
                } else if (j%M[i] == x[i]) {
                    rightX = true;
                } else {
                    continue;
                }

                boolean rightY = false;
                if(y[i] == N[i]){
                    if(j%N[i] == 0){
                        rightY = true;
                    }
                } else if (j%N[i] == y[i]) {
                    rightY = true;
                }

                if(rightX && rightY){
                    result = j;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
