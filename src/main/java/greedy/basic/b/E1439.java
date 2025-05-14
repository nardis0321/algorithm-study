package greedy.basic.b;

import java.util.Scanner;

public class E1439 {
    public static void main(String[] args) {
        // 첫째 줄에 0과 1로만 이루어진 문자열 S가 주어진다. S의 길이는 100만보다 작다.
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        // 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다
        // 뒤집기만 가능. 행동의 최소 횟수를 출력

        // => 가장 많이 연속된 인덱스를 알아내서 뒤집기
        char[] strings = S.toCharArray();
        int cnt = 0;
        for (int i = 0; i < strings.length-1; i++) {
            if(strings[i] != strings[i+1]){
                cnt++;
            }
        }

        if(cnt == 0){
            System.out.println(0);
        } else {
            System.out.println((cnt+1)/2);
        }
        // 0 > 0
        // 1 > 1
        // 2 > 1
        // 3 > 2
        // 4 > 2
        // 5 > 3
        // 6 > 3
        // 7 > 4
        // 8 > 4
        // 두 개로 분류해서 청크의 수를 세면 됨
    }
}
