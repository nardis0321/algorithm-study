package greedy.Intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D4796 {

    public static void main(String[] args) {
        //캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다.
        // 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)

        // 입력은 여러 개의 테스트 케이스로 이루어져 있다.
        // 각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다.
        // 모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.

        Scanner sc = new Scanner(System.in);

        List<Integer> usableDays = new ArrayList<>();
        List<Integer> period = new ArrayList<>();
        List<Integer> vacationDays = new ArrayList<>();
        while (true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();

            if(L == 0 && P == 0 && V == 0) break;

            usableDays.add(L);
            period.add(P);
            vacationDays.add(V);
        }

        for (int i = 0; i < usableDays.size(); i++) {
            int L = usableDays.get(i);
            int P = period.get(i);
            int V = vacationDays.get(i);

            // P 중에 L일만 사용, V동안...
            int result = 0;

            result = V/P * L;
            result += Math.min(V % P, L);

            System.out.println("Case " + (i+1) + ": "+result);
        }

    }
}
