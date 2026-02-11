package bruteforce.basic;

import java.util.Arrays;
import java.util.Scanner;

public class A2309For {
    public static void main(String[] args) {
        // 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며,
        // 일곱 난쟁이의 키의 합이 100이 됨
        // 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
        // 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

        Scanner sc = new Scanner(System.in);
        int candidates = 9;
        int[] heights = new int[candidates];
        for (int i = 0; i < candidates; i++) {
            heights[i] = sc.nextInt();
        }

        Arrays.sort(heights);
        int total = Arrays.stream(heights).sum();

        boolean found = false;
        for (int i = 0; i < candidates && !found; i++) {
            for (int j = i+1; j < candidates && !found; j++) {
                int sum = total - heights[i] - heights[j];
                if(sum == 100) {

                    // 출력
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < candidates; k++) {
                        if(k!=i && k!=j){
                            sb.append(heights[k]);
                            sb.append("\n");
                        }
                    }
                    System.out.println(sb);
                    found = true;
                }
            }
        }

    }
}
