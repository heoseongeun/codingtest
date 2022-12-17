package 실전문제.DP;

import java.util.Scanner;

public class FloorConstruction {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N + 1];
        arr[1] = 1;
        arr[2] = 3;
        for(int i = 3; i < N + 1; i++) {
            arr[i] = (arr[i - 2] * 2) + arr[i - 1];
        }
        System.out.println(arr[N] % 796796);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
