package binarysearch.basic;

import java.util.Arrays;
import java.util.Scanner;

public class B10816 {

    // 여전히 시간 초과... 카드가 50만 개 > 개수 탐색 > 해쉬맵 쓰면 O(1)
    static int upperBound(int[] a, int target){
        int left = 0;
        int right = a.length;   // 배열 바깥이 upper 값일 경우 고려해야 함

        while(left < right) {
            int mid = (left+right)/2;
            if(a[mid] <= target){
                left = mid + 1;
            } else { // a[mid] > target
                right = mid;
            }
        }
        return right;
    }

    static int lowerBound(int[] a, int target){
        int left = 0;
        int right = a.length-1;

        while(left < right) {
            int mid = (left+right)/2;
            if(a[mid] < target){
                left = mid + 1;
            } else { // a[mid] > target
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
        // 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
        // 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] integers = new int[N];
        for (int i = 0; i < N; i++) {
            integers[i] = sc.nextInt();
        }

        Arrays.sort(integers);

        //셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
        // 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며,
        // 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            // 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력
            int lower = lowerBound(integers, target);
            int upper = upperBound(integers, target);
            System.out.print(upper - lower + " ");
        }
    }
}
