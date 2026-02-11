package bruteforce.basic;

import java.util.Arrays;
import java.util.Scanner;

public class A2309DFS {

    static int[] dwarves = new int[9];
    static int[] select = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            dwarves[i] = sc.nextInt(); // 난쟁이들의 키
        }

        // 일곱 난쟁이의 키의 합이 100
        // 일곱 난쟁이의 키를 오름차순으로 출력
        findFake(0, 0, 0);

    }

    static void findFake(int idx, int count, int sum){

        // 종료 조건
        if(count == 7 && sum == 100){
            Arrays.sort(select);
            for (int x : select) {
                System.out.println(x);
            }
            System.exit(0); // 여기서 return 시, 재귀 상태라 상위 dfs로 돌아갈 가능성 있음
        }

        // 조건 안 맞음, 실패 pruning
        if(idx == 9) return;
        if(count == 7) return;
        if(sum > 100) return;

        select[count] = dwarves[idx];
        // 분기 1. 넣기
        findFake(idx+1, count+1, sum + select[count]);
        // 분기 2. 안 넣기
        findFake(idx+1, count, sum);
    }
}
