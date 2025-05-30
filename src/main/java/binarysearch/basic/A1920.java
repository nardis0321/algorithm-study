package binarysearch.basic;

import java.util.Arrays;
import java.util.Scanner;

public class A1920 {

    static int search(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right){
            int mid = (left+right) / 2;
            if(a[mid] == target){
                return 1;
            } else if (a[mid] < target){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        // 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        // 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
        int M = sc.nextInt();
        // 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
        // M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
        Arrays.sort(a);
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            if (search(a, target) == 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
    // 그냥 이거 쓰면 됨 : Arrays.binarySearch(a, target);
}
