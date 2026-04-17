package bruteforce.bitmask;

import java.util.Scanner;

public class A11966 {
    // 2의 제곱인가? 브론즈 3
    // 자연수 N이 주어졌을 때,
    // 2의 제곱수면 1을 아니면 0을 출력하는 프로그램을 작성하시오.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // N(1 ≤ N ≤ 230)

        if(isTwoSquared(n)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    static boolean isTwoSquared(int n){
        // 2 0010
        // 4 0100
        // 8 1000
        // 2의 거듭제곱은 딱 1개의 비트만 켜져 있다

        return (n & (n-1)) == 0;
    }
}
