package math.basic;

import java.util.Scanner;

public class A9713 {

    // https://www.acmicpc.net/problem/9713
    // 1~n 홀수 합 3가지 방법으로 풀어보기

    // 단순 반복문
    public int simpleSum(int n){
        int sum = 0;

        for (int i = 1; i <= n; i = i+2) {
            sum += i;
        }

        return sum;
    }

    // 재귀
    public int reculsiveSum(int n){

        if(n <= 1){
            return n;
        }

        if(n%2 == 0){
            n--;
        }

        return n + reculsiveSum(n-2);
    }

    // 수학적 원리
    public int math(int n){

        // 홀수가 K개일 때 n = 2k-1, 총합은 K제곱
        int k;
        if(n%2 == 0){
            k = n/2;
        } else {
            k = (n+1)/2;
        }

        return k*k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        A9713 main = new A9713();
        while (T-- > 0) {
            int n = sc.nextInt();
            // System.out.println(main.simpleSum(n));
            // System.out.println(main.reculsiveSum(n));
            System.out.println(main.math(n));
        }

    }
}
