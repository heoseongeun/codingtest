package 실전문제.DP;

import java.util.Scanner;

public class EfficientMoney {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();

        int[] result = new int[M + 1];
        for(int i = 1; i < M + 1; i++) result[i] = 10001;

        for(int i = 0; i < N; i++) {
            for(int j = arr[i]; j < M + 1; j++) {
                if(result[j - arr[i]] != 10001)
                    result[j] = Math.min(result[j], result[j - arr[i]] + 1);
            }
        }

        if(result[M] != 0) System.out.println(result[M]);
        else System.out.println(-1);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
