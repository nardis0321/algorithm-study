package greedy.basic.b;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C1781 {
    public static void main(String[] args) {
        // 첫 줄에 숙제의 개수 N (1 ≤ N ≤ 200,000)이 들어온다.
        Scanner sc = new Scanner(System.in);
        System.out.println("입력 ㄱㄱ");
        int N = sc.nextInt();
        // 다음 줄부터 N+1번째 줄까지 i+1번째 줄에
        // i번째 문제에 대한 데드라인과 풀면 받을 수 있는 컵라면 수가 공백으로 구분되어 입력된다.

        int[][] deadlineAndReward = new int[N][2];
        for (int i = 0; i < N; i++) {
            deadlineAndReward[i][0] = sc.nextInt();
            deadlineAndReward[i][1] = sc.nextInt();
        }

        // 문제를 푸는데는 단위 시간 1이 걸리며
        // 문제를 시간 내에 풀어 동호가 받을 수 있는 최대 컵라면 수

        Arrays.sort(deadlineAndReward, Comparator.comparingInt(o -> o[0])); // 데드라인이 빠른 순서대로 정렬

        // 1 2 5 6 4 3 7
        // 1 1 2 2 3 3 6
        // 6 7 4 5 1 2 1
        //   1   2   3 4
        // 넣었다가 비교해서 빼고 넣고 ...
        PriorityQueue<Integer> rewards = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if(deadlineAndReward[i][0] <= rewards.size() && !rewards.isEmpty()){   // 시간이 부족함
                if(rewards.peek() < deadlineAndReward[i][1]){
                    rewards.poll();
                    rewards.offer(deadlineAndReward[i][1]);
                } // else 시 스킵
            } else {
                rewards.offer(deadlineAndReward[i][1]);   // 컵라면 저장
            }
        }

        System.out.println(rewards.stream().mapToInt(Integer::intValue).sum());
    }
}
