package bruteforce.permutation;

import java.util.Scanner;

public class B10973 {

    // 1 - N 순열, 사전순 바로 이전 순열을 출력
    static int[] permutation;

    public static void main(String[] args) {
        // 1234 > 1243
        // 123564 > 123645
        // 1. 뒤에서부터 pivot 찾기 a[i-1] > a[i]
        // 2. pivot보다 작은 값 중 가장 큰 값 찾기 (오른쪽에서) swap
        // 3. pivot 오른쪽 reverse

        // 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = sc.nextInt();
        }

        // pivot 찾기
        int pivot = -1;
        int i = n-1;
        while(i>0){
            if(permutation[i-1] > permutation[i]){
                pivot = i-1;
                break;
            }
            i--;
        }

        if(pivot == -1){
            System.out.println(-1);
        } else{
            // swap
            i = pivot+1;
            int min = 0;
            int idx = 0;
            while(i < n){
                if(permutation[i] < permutation[pivot]
                        && permutation[i] > min){
                    min = permutation[i];
                    idx = i;
                }
                i++;
            }
            swap(pivot, idx);

            // pivot 오른쪽 reverse
            int left = pivot+1;
            int right = n-1;
            while(left < right){
                swap(left, right);
                left++;
                right--;
            }

            // 출력
            for (int p : permutation) {
                System.out.print(p + " ");
            }
        }



    }

    static void swap(int i, int j){
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }
}
