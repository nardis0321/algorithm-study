package greedy.Intermediate;

import java.util.*;

public class B1461 {
    public static void main(String[] args) {
        // 첫째 줄에 책의 개수 N과, 세준이가 한 번에 들 수 있는 책의 개수 M이 주어진다.
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        // 둘째 줄에는 책의 위치가 주어진다. N과 M은 50보다 작거나 같은 자연수이다.
        // 책의 위치는 0이 아니며, 절댓값은 10,000보다 작거나 같은 정수이다.
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int location = sc.nextInt();
            if(location < 0){
                minusList.add(-location);
            } else {
                plusList.add(location);
            }
        }

        // 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수를 계산
        plusList.sort(Comparator.reverseOrder());
        minusList.sort(Comparator.reverseOrder());
        // 세준이는 현재 0에 있고, 사람들이 마구 놓은 책도 전부 0에 있다.
        // M번만큼 location 이동 가능.

        // N개의 위치를 M번씩 끊어서 이동하면 됨. 제일 먼 위치가 곧 걸음 수야.
        List<Integer> move = new ArrayList<>();
        for (int i = 0; i < plusList.size(); i++) {
            if(i%M == 0){
                move.add(plusList.get(i));
            }
        }
        for (int i = 0; i < minusList.size(); i++) {
            if(i%M == 0){
                move.add(minusList.get(i));
            }
        }


        int result = 0;

        move.sort(Comparator.reverseOrder());
        if (move.size() == 1){
            System.out.println(move.get(0));
        } else {
            for (int i = 1; i < move.size(); i++) {
                result += move.get(i);
            }
            result *= 2;
            result += move.get(0);

            System.out.println(result);
        }

    }
}
