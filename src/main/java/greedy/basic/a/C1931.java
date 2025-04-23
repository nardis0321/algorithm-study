package greedy.basic.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C1931 {

    public static void main(String[] args) throws IOException {
        // 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        // 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데
        // 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
        // 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
        int[][] meetingSchedules = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] times = br.readLine().split(" ");
            meetingSchedules[i][0] = Integer.parseInt(times[0]);
            meetingSchedules[i][1] = Integer.parseInt(times[1]);
        }

        // 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수
        // 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
        // 회의의 시작시간과 끝나는 시간이 같을 수도 있다.

        // 정렬하기!
        // 정렬 전략 : 빨리 끝나는 순서대로 정렬 종료 시간 정렬 > 시작 시간
        // 정렬에 O N log N
        Arrays.sort(meetingSchedules, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // 종료 시간이 같으면 시작 시간이 빠른 순 정렬
            }
            return Integer.compare(a[1], b[1]);
        });

        // 비교하기
        // 반복문에 O N
        int cnt = 1;
        int lastEndTime = meetingSchedules[0][1];

        for (int i = 1; i < N; i++) {
            if (meetingSchedules[i][0] >= lastEndTime) {
                cnt++;
                lastEndTime = meetingSchedules[i][1];
            }
        }


        System.out.println(cnt);
    }
}
