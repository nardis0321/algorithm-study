package greedy.basic.b;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A19598 {
    public static void main(String[] args) {
        // 첫째 줄에 배열의 크기 N(1 ≤ N ≤ 100,000)이 주어진다.
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        // 둘째 줄부터 N+1 줄까지 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231−1보다 작거나 같은 자연수 또는 0이다.
        int[][] meetingSchedule = new int[N][2];
        for (int i = 0; i < N; i++) {
            meetingSchedule[i][0] = sc.nextInt();
            meetingSchedule[i][1] = sc.nextInt();
        }

        // N개의 회의를 모두 진행할 수 있는 최소 회의실 개수
        // 한 회의실에서 동시에 두 개 이상의 회의가 진행될 수 없다.
        // 회의는 한번 시작되면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
        // 회의의 시작 시간은 끝나는 시간보다 항상 작다.

        // 정렬해서 필요한 회의실 개수를 찾기
        // 중복된 회의 시간 최대 개수를 찾기

        // 시작시간 순으로 정렬
        Arrays.sort(meetingSchedule, (a, b) -> Integer.compare(a[0], b[0]));


        // Priority Queue : Min-Heap 기반, 낮은 값이 높은 우선순위
        // 종료 시간을 저장
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(meetingSchedule[0][1]);
        for (int i = 1; i < N; i++) {
            if (meetingSchedule[i][0] < queue.peek()) {   // 다음 회의 시작 시간 < 큐에 저장된 가장 이른 회의 끝나는 시간
                queue.add(meetingSchedule[i][1]);  // 큐에 해당 회의 종료 시간 저장 (new)
            } else {    // 다음 회의는 큐에 저장된 회의 다음에 들어갈 수 있음
                queue.poll();   // 기존 회의실 사용
                queue.add(meetingSchedule[i][1]);
            }
        }

        System.out.println(queue.size());
    }
}
