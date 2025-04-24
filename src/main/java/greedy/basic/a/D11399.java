package greedy.basic.a;

import java.util.Arrays;
import java.util.Scanner;

public class D11399 {
    public static void main(String[] args) {

        // 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다.
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        // 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
        int[] pi = new int[N];
        for (int i = 0; i < N; i++) {   // O n
            pi[i] = sc.nextInt();
        }

        // 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값, ATM은 1대
        // 오름차순 정렬해야 최소값이 나옴
        Arrays.sort(pi);    // O n log n

        int result = pi[0];
        for (int i = 1; i < N; i++) {   // O n
            pi[i] += pi[i-1];
            result += pi[i];
        }

        System.out.println(result);
    }
}
