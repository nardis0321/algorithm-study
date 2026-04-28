package bruteforce.bitmask;

import java.math.BigInteger;
import java.util.Scanner;

public class A19946 {
    /**
     * 2의 제곱수 계산하기
     * 브론즈 2
     * 2씩 곱하는 와중에 1을 빼버리는 실수를 딱 한 번 해버리고 말았다.
     * 예를 들어, 21 = 2로 계산을 잘 하다가 22 = 3으로 계산해버리는 어이없는 실수를 해버리는 것이다.
     * 태영이가 구한 264인 N이 주어졌을 때, 태영이가 처음으로 실수한 구간을 찾아주자.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger(); // 2 ≤ N ≤ 18,446,744,073,709,551,615 = 2의64승 - 1

        int k = 64;

        while(n.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
            n = n.divide(BigInteger.TWO);
            k--;
        }

        System.out.println(k);
    }
}
