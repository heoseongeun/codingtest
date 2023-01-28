package 기출문제.정렬;

import java.util.Arrays;
import java.util.Scanner;

// 백준 18310 안테나
public class P360 {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        System.out.println(arr[(N - 1) / 2]);
    }
}
