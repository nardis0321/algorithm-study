package greedy.basic.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
        String input = br.readLine();
        String[] inputs = input.split(" ");

        final int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        // 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
        ArrayList<Integer> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        coins.sort(Comparator.reverseOrder());  // 시간 복잡도 O N log N
        // 정렬하지 않고, 동전을 배열에 저장해서 뒤에서부터 사용하면 더 나은 코드가 된다.

        int result = 0;
        for (int coin : coins) {
            if(K == 0) {
                break;
            }

            if (K >= coin) { // 실수 포인트
                result += K / coin;
                K %= coin;
            }
        }

        System.out.println(result);
    }
}
