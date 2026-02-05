package math.basic;

import java.util.Scanner;

public class G1748 {

    // 1부터 N까지의 수를 이어서 써서 만든 숫자의 자릿수를 구하는 프로그램

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // (1 ≤ N ≤ 100,000,000)

        int cnt = 0;
        for (int i = n; i > 0; i--) {

            int left = i;
            while(left > 0){
                left /= 10;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
