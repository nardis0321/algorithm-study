package greedy.basic.a;

import java.util.Scanner;

public class A5585 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int change = 1000 - amount;

        int[] coins = {500, 100, 50, 10, 5, 1}; // 공간 복잡도 O(1)

        int result = 0;
        for (int coin : coins){     // 시간 복잡도 O(1)
            result += change / coin;
            change %= coin;
        }

        System.out.println(result);
    }
}
