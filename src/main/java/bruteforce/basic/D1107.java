package bruteforce.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D1107 {
    static int N;
    static int M;

    static int find(Set<Integer> brokenSet){
        if(N == 100){
            return 0;
        }

        int result = Math.abs(N - 100); // +,- 버튼만 사용

        // 고장 안 난 숫자 선택해서
        // + - 하기
        // 다음 루프 최대 100만 번 반복
        for (int i = 0; i <= 999999 ; i++) {    // N은 최대 500000이므로 999999로부터 이동하는 케이스까지 있을 수 있음
            String str = String.valueOf(i);
            boolean isValid = true;
            for(char c : str.toCharArray()){    // 최대 6자리에 대한 O(6)
                if(brokenSet.contains(c - '0')){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                int cnt = str.length() + Math.abs(N - i);
                result = Math.min(result, cnt);
            }
        }

        return result;
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
        Set<Integer> brokenSet = new HashSet<>(M);
        for (int i = 0; i < M; i++) {
            brokenSet.add(sc.nextInt());
        }

        // 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
        int result = find(brokenSet);
        System.out.println(result);
    }
}
