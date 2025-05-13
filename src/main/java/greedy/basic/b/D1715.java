package greedy.basic.b;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D1715 {
    public static void main(String[] args) {
        // 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100,000)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 이어서 N개의 줄에 걸쳐 숫자 카드 묶음의 각각의 크기가 주어진다.
        // 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수이다.
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cards.offer(sc.nextInt());
        }

        // 두 묶음씩 골라 서로 합쳐나간다면, 고르는 순서에 따라서 비교 횟수가 매우 달라진다. 최소 비교 횟수를 출력한다.
        // 합치는 건 A+B... 묶음이 가장 작아야 함.
        // PriorityQueue를 쓴다면

        int result = 0;
        while(cards.size() > 1) {
            int min = cards.poll();
            int nextMin = cards.poll();
            cards.offer(min + nextMin);
            result += min + nextMin;
        }

        System.out.println(result);

    }
}
