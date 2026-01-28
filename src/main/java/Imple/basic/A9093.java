package Imple.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A9093 {
    // https://www.acmicpc.net/problem/9093
    // 주어진 문장을 단어 단위로 끊어서 단어를 뒤집는 문제

    public String[] reverseStrings(String[] strings){
        String[] reversed = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            reversed[i] = new StringBuilder(strings[i]).reverse().toString();
        }
        return reversed;
    }

    public String cutAndReverseWords (String string){
        String[] words = string.split(" ");
        String[] reversedStrings = reverseStrings(words);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reversedStrings.length-1; i++) {
            sb.append(reversedStrings[i]).append(" ");
        }
        sb.append(reversedStrings[reversedStrings.length-1]);
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] strings = new String[T];
        for (int i = 0; i < T; i++) {
            strings[i] = br.readLine();
        }

        A9093 main = new A9093();
        for (String string : strings) {
            System.out.println(main.cutAndReverseWords(string));
        }

    }
}
