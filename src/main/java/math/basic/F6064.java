package math.basic;

import java.util.Scanner;

public class F6064 {

    static int gcd(int a, int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }

        return euclidean(a,b);
    }

    static int euclidean(int a, int b){
        int r = a%b;

        if(r == 0){
            return b;
        }

        return euclidean(b, r);
    }

    static int lcm(int a, int b){
        return a*b/gcd(a, b);
    }

    public static void main(String[] args) {
        // <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 k를 출력하라
        // 만일 <x:y>가 유효하지 않은 표현이면, -1을 출력

        // x는 k를 M으로 나눈 나머지, y는 k를 N으로 나눈 나머지

        // 정수론

        // 1. 합동식 일반해
        // k ≡ x (mod M) 의 모든 해 : k = x + M*t
        // k는 무조건 x, x+M, x+2M, ...

        // 2. CRT 존재 조건
        // k ≡ x (mod M)
        // k ≡ y (mod N)
        // 해를 가지려면 반드시 x ≡ y (mod gcd(m, n))
        // (x - y) % gcd(M,N) == 0

        // 3. 해의 주기
        // 주기 = lcm(m,n)



        Scanner sc = new Scanner(System.in);    // 표준 입력
        int T = sc.nextInt();   // 입력 데이터의 수를 나타내는 정수 T

        // (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N)
        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 1. 최대공약수 없으면 -1
            // 유클리드 호제법 : 두 수의 최대공약수는 큰 수를 작은 수로 나눈 나머지 수와 원래 작은 수의 최대공약수와 같다
            int gcd = gcd(m, n);
            if( (x - y) % gcd != 0){
                System.out.println(-1);
                continue;
            }

            // 2. k = x + tm
            int k = x;
            boolean found = false;
            while(k <= lcm(m,n)){
                if((k-y)%n == 0){
                    System.out.println(k);
                    found = true;
                    break;
                }
                k += m;
            }

            if(!found){
                System.out.println(-1);
            }
        }

    }
}
