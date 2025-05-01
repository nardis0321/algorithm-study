package greedy.basic.a;

import java.util.Arrays;
import java.util.Scanner;

public class F2217 {
    public static void main(String[] args) {
        // 첫째 줄에 정수 N이 주어진다.
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        // 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.
        int[] maxWeight = new int[N];
        for (int i = 0; i < N; i++) {
            maxWeight[i] = sc.nextInt();
        }

        // k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
        // 들어올릴 수 있는 물체의 최대 중량, 로프를 전부 사용하지 않아도 됨.
        Arrays.sort(maxWeight);
        // 수학적으로 +w하는 것보다 /k+1할 때 줄어드는 지점을 찾으면 될 것 가튼뎅
        // <= 틀린 해답 왜냐면 가장 작은 중량을 w/k가 넘지 않아야만 함
        // 들 수 있는 최대 중량이 w, 한 개에 걸리는 중량은 w/k
        // 큰 것부터 시작해서 w*k가 제일 큰 것!
        int max = 0;
        // 각 로프를 사용할 때의 최대 중량 계산
        for (int i = 0; i < N; i++) {
            int weight = maxWeight[i] * (N - i); // n-i개 사용했을 때 maxWeight[i]가 그 중 버틸 수 있는 기준이 되는 지점임
            max = Math.max(max, weight);
        }

        System.out.println(max);
    }
}
