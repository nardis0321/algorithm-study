package binarysearch.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B10816 {

    public static void main(String[] args) {
        // 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
        // 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
        // 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
//            map.merge(n, 1, Integer::sum);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
        // 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며,
        // 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            // 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력
            sb.append(map.getOrDefault(target, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
