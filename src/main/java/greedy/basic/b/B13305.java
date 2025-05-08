package greedy.basic.b;

import java.util.Scanner;

public class B13305 {
    public static void main(String[] args) {

// 첫 번째 줄에는 도시의 개수를 나타내는 정수 N(2 ≤ N ≤ 100,000)이 주어진다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
// 다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 N-1개의 자연수로 주어진다.
        int[] distance = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = sc.nextInt();
        }
// 다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다.
        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }
// 제일 왼쪽 도시부터 제일 오른쪽 도시까지의 거리는 1이상 1,000,000,000 이하의 자연수이다.
// 리터당 가격은 1 이상 1,000,000,000 이하의 자연수이다.

        // 표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다.
        // 처음 출발할 때 자동차에는 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다. 기름통의 크기는 무제한
        // 도로를 이용하여 이동할 때 1km마다 1리터의 기름을 사용한다.

        int minPrice = price[0];
        long total = (long) minPrice * distance[0];    // 첫번째에서는 꼭 넣어야 함
        for (int i = 1; i < N - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            total += (long) minPrice * distance[i];
        }

        System.out.println(total);

        // 1,000,000,000 * 1,000,000,000 = 1,000,000,000,000,000,000 => int로는 부족했다!! Overflow
    }
}
