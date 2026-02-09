package bruteforce.basic;

import java.util.Scanner;

public class F2798 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드의 개수 N(3 ≤ N ≤ 100)
        int m = sc.nextInt(); // M(10 ≤ M ≤ 300,000

        int[] card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = sc.nextInt(); // 100,000을 넘지 않는 양의 정수이다.
        }

        // M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력
        int result = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 1; j < n-1; j++) {
                for (int k = 2; k < n; k++) {

                    if(i==j || j ==k || i==k) continue;

                    int sum = card[i] + card[j] + card[k];
                    if(result<sum && sum<=m)
                        result = sum;
                }
            }
        }

        System.out.println(result);
    }
}
