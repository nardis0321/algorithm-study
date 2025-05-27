package dp.basic;

import java.util.Scanner;

public class B2747 {

    static class Recursive {

        int fibonacci(int a){
            if(a <= 1)  return a;
            return fibonacci(a-1) + fibonacci(a-2);
        }
        // 완전 이진 트리 형태로 호출 -> 시간복잡도는 O(2^n)
        // 재귀 호출이 최대 n번까지 쌓일 수 있음 -> 함수 호출 스택이 n 깊이 -> 공간 복잡도는 O(n)

    }

    public static void main(String[] args) {
        // 첫째 줄에 n이 주어진다. n은 45보다 작거나 같은 자연수이다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //첫째 줄에 n번째 피보나치 수를 출력한다.
        Recursive r = new Recursive();
        System.out.println(r.fibonacci(n));
    }
}
