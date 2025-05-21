package greedy.Intermediate;

import java.util.*;

public class E1202 {

    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 보석 개수
        int K = sc.nextInt();   // 가방 개수
        //다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int Mi = sc.nextInt();
            int Vi = sc.nextInt();
            jewels.add(new Jewel(Mi, Vi));
        }
        //다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            int Ci = sc.nextInt();
            bags[i] = Ci;
        }
        //모든 숫자는 양의 정수이다.
        // 보석 최대 가격 : 1,000,000 * 최대 개수 : 300,000 => 최대 결과 : 300,000,000,000 int 초과

        // 보석이 총 N개 있다.
        // 각 보석은 무게 Mi와 가격 Vi를 가지고 있다.
        // 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다.
        // 가방에는 최대 한 개의 보석만 넣을 수 있다.
        // 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.

        // 무게가 가방 무게를 넘지 말아야 하고, 가격은 높을 수록 좋아!
        // => 가격으로 정렬해서 비싼 것부터 넣자!! => 시간 초과... 엔제곱(이중포문) 말고 다른 방법 찾기
        // => 무게로 정렬해서... 어케 해보기
        Arrays.sort(bags);
        jewels.sort(Comparator.comparingInt(j -> j.weight));

        long result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        for (int bag : bags) {
            while (index < jewels.size() && jewels.get(index).weight <= bag) {
                queue.add(jewels.get(index).value);
                index++;
            }

            if (!queue.isEmpty()) {
                result += queue.poll();
            }
        }

        System.out.println(result);

    }
}
