package bruteforce.basic;

import java.util.Scanner;

public class G9095DFS {

    // 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

    static int count;
    static void dfs(int sum, int n){
        // 합이 n이 될 때까지 123 붙여보기

        // 종료
        if(sum == n) {
            count++;
            return;
        }

        // Pruning
        if(sum > n) return;

        // 분기
        dfs(sum + 1, n);
        dfs(sum + 2, n);
        dfs(sum + 3, n);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스의 개수 T
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // 정수 n이 주어진다. n은 양수이며 11보다 작다.

            dfs(0, n);
            System.out.println(count);
            count = 0;
        }
    }

}
