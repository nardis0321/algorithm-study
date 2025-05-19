package greedy.Intermediate;

import java.util.*;

public class C1744 {
    private static int calculate(List<Integer> sequencePlus){

        if(sequencePlus.isEmpty()){
            return 0;
        } else if (sequencePlus.size() == 1) {
            return sequencePlus.get(0);
        } else {
            int result = 0;
            for (int i = 0; i < sequencePlus.size()-1; i++) {
                int a = sequencePlus.get(i);
                int b = sequencePlus.get(++i);
                if(b == 1){ // 1일 때는 곱하면 숫자가 작아짐... 내림차순 정렬했으니까 a만 1일 수는 없음
                    result += a + b;
                } else {
                    result += a * b;
                }
            }
            if(sequencePlus.size()%2 != 0){
                result += sequencePlus.get(sequencePlus.size()-1);
            }
            return result;
        }
    }

    private static int calculate(List<Integer> sequenceMinus, boolean zero){
        int result = 0;
        if(sequenceMinus.isEmpty()){
            return 0;
        } else if (sequenceMinus.size() == 1) {
            if(zero){
                return 0;
            } else {
                return sequenceMinus.get(0);
            }
        } else {
            for (int i = 0; i < sequenceMinus.size()-1; i++) {
                result += sequenceMinus.get(i) * sequenceMinus.get(++i);
            }
            if(sequenceMinus.size()%2 != 0 && !zero){
                result += sequenceMinus.getLast();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // 첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다. 수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
        // 음수도 나옴!!!
        List<Integer> sequencePlus = new ArrayList<>();
        List<Integer> sequenceMinus = new ArrayList<>();
        boolean zero = false;
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if(n > 0){
                sequencePlus.add(n);
            } else if (n < 0) {
                sequenceMinus.add(n);
            } else {
                zero = true;
            }
            // 더할 거니까 0은 무시
        }

        // 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다.
        // 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
        // 수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.
        sequencePlus.sort(Comparator.reverseOrder());
        Collections.sort(sequenceMinus);

        int result = calculate(sequencePlus);
        result += calculate(sequenceMinus, zero);

        System.out.println(result);
    }
}
