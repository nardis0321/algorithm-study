package bruteforce.basic;

import java.util.Scanner;

public class D1107 {
    static int N;
    static int M;

    static int find(int[] broken){
        if(N == 100){
            return 0;
        }

        int cntGap;
        if(N < 100){
            cntGap = 100 - N;
        } else {
            cntGap = N - 100;
        }

        if(M == 10){
            return cntGap;
        }

        int n = N;
        int cntMinus = 0;
        int i = 0;
        while(i < M){   // 최악 시간 복잡도 : O(N × M × D) = O(500,000 × 10 × 6) = 약 30,000,000 (3천만) 연산
            String brokenStr = String.valueOf(broken[i]);
            if (Integer.toString(n).contains(brokenStr)) {
                n--;
                cntMinus++;
                i = 0;
            } else {
                i++;
            }
        }
        cntMinus += Integer.toString(n).length();

        int cntPlus = 0;
        n = N;
        i = 0;
        while(i < M){
            if(n == -1){
                break;
            }
            String brokenStr = String.valueOf(broken[i]);
            if (Integer.toString(n).contains(brokenStr)) {
                n++;
                cntPlus++;
                i = 0;
            } else {
                i++;
            }
        }
        cntPlus += Integer.toString(n).length();


        return Math.min(Math.min(cntMinus, cntPlus), cntGap);
    }


    public static void main(String[] args) {
        // 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
        //리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고,
        // -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
        //
        // 수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때,
        // 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
        //
        //수빈이가 지금 보고 있는 채널은 100번이다.

        // 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
        M = sc.nextInt();
        // 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.
        int[] broken = new int[M];
        for (int i = 0; i < M; i++) {
            broken[i] = sc.nextInt();
        }

        // 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
        int result = find(broken);
        System.out.println(result);
    }
}
