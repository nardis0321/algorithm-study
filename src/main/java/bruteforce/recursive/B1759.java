package bruteforce.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1759 {

    // C개 문자 중에 L개 문자 순열
    // 한 개 이상의 모음, 두 개 이상의 자음
    // 오름차순 소문자 중복없음

    static int l, c;
    static char[] pool;
    static StringBuilder sb = new StringBuilder();
    static char[] selected;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        l = Integer.parseInt(split[0]);
        c = Integer.parseInt(split[1]);
        // (3 ≤ L ≤ C ≤ 15)

        pool = new char[c];
        selected = new char[l];

        line = br.readLine();
        split = line.split(" ");
        for (int i = 0; i < c; i++) {
            pool[i] = split[i].charAt(0);
        }

        Arrays.sort(pool);

        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int depth, int start){
        int vowelCnt = 0;

        if(depth == l){
            for (char c : selected) {
                for (char vowel : vowels) {
                    if (c == vowel) {
                        vowelCnt++;
                    }
                }
            }

            if(vowelCnt >= 1 && vowelCnt <= l-2){
                for (char c : selected) {
                    sb.append(c);
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = start; i < c; i++) {
            selected[depth] = pool[i];

            dfs(depth+1, i+1);
        }
    }
}
