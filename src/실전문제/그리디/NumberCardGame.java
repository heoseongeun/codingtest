package 실전문제.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[M];
        int[] mins = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[j] = scanner.nextInt();
            }
            mins[i] = Arrays.stream(arr).min().getAsInt();
        }

        System.out.println(Arrays.stream(mins).max().getAsInt());
        scanner.close();
    }
}
