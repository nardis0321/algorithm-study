package greedy.Intermediate;

import java.util.*;

public class A1374 {
    public static void main(String[] args) {
        // 첫째 줄에 강의의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        // 둘째 줄부터 N개의 줄에 걸쳐 각 줄마다 세 개의 정수가 주어지는데,
        // 순서대로 강의 번호, 강의 시작 시간, 강의 종료 시간을 의미한다.
        // 강의 번호는 1부터 N까지 붙어 있으며, 입력에서 꼭 순서대로 주어지지 않을 수 있으나 한 번씩만 주어진다.
        // 강의 시작 시간과 강의 종료 시간은 0 이상 10억 이하의 정수이고, 시작 시간은 종료 시간보다 작다.
        int[][] lecture = new int[N][3];
        for (int i = 0; i < N; i++) {
            lecture[i][0] = sc.nextInt();   // num
            lecture[i][1] = sc.nextInt();   // start
            lecture[i][2] = sc.nextInt();   // end
        }


        // 필요한 최소 강의실 개수를 출력
        // 시작 순으로 정렬해서 Queue로 넣고 빼기?
        Arrays.sort(lecture, Comparator.comparingInt(o -> o[1]));

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(lecture[0][2]);
        for (int i = 1; i < N; i++) {
            if(!queue.isEmpty() && lecture[i][1] >= queue.peek()) { // 시작 시간이 끝나는 시간과 같거나 이후임
                queue.poll();   // 해당 방에 넣으면 됨
            }
            queue.offer(lecture[i][2]); // 끝나는 시간 저장
        }

        System.out.println(queue.size());
        // 시간이 지났다고 빼내지 않으니까 큐 사이즈가 최대임
    }
}
