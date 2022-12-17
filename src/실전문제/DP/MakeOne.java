package 실전문제.DP;

import java.util.Scanner;

public class MakeOne {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N + 1];
        for(int i = 2; i < N + 1; i++) {
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            if(i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            if(i % 5 == 0) arr[i] = Math.min(arr[i], arr[i / 5] + 1);
        }

        System.out.println(arr[N]);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
