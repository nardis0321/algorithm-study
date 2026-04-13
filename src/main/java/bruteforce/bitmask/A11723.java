package bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A11723 {
    /**
     * 집합
     * 실버 5
     *
     * 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
     *
     * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
     * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
     * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
     * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
     * all: S를 {1, 2, ..., 20} 으로 바꾼다.
     * empty: S를 공집합으로 바꾼다.
     */

    // 집합의 있고 없고를 0과 1로 표현
    // 비트마스크 풀이와 이전 풀이의 메모리/시간 차이 크지 않았으나 코드가 간결해졌고 효율도 더 좋긴 했다

    static int m; // 연산의 수 M (1 ≤ M ≤ 3,000,000)
    static int[] s = new int[21]; // 1있음 0없음, 처음에 공집합
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] operation = br.readLine().split(" ");

            String operator = operation[0];
            int operand = (operation.length > 1)? Integer.parseInt(operation[1]) : 0;

            operate(operator, operand);
        }

        System.out.println(sb);

    }

    static void operate (String operator, int operand){
        switch (operator){
            case "add":
                s[operand] = 1;
                break;

            case "remove":
                s[operand] = 0;
                break;

            case "check":
                sb.append(s[operand]).append("\n");
                break;

            case "toggle":
                s[operand] ^= 1;
                break;

            case "all":
                Arrays.fill(s, 1);
                break;

            case "empty":
                Arrays.fill(s, 0);
                break;
        }
    }

    static void operateWithoutBitmask (String operator, int operand){
        if(operator.equals("add")) s[operand] = 1;

        if(operator.equals("remove")) s[operand] = 0;

        if(operator.equals("check")) sb.append(s[operand]).append("\n");

        if(operator.equals("toggle")) {
            if(s[operand] == 1) s[operand] = 0;
            else s[operand] = 1;
        }

        if(operator.equals("all")){
            for (int i = 1; i < s.length; i++) {
                s[i] = 1;
            }
        }

        if(operator.equals("empty")){
            for (int i = 1; i < s.length; i++) {
                s[i] = 0;
            }
        }
    }
}
