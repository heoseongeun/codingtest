package 기출문제.이진탐색;

import java.util.Scanner;

public class P367 {
    static int[] arr;
    static int N, x;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        x = scanner.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        binarySearch(0, N - 1);
        if(count != 0) System.out.println(count);
        System.out.println(-1);
    }

    public static void binarySearch(int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] == x) count++;
            binarySearch(start, mid);
            binarySearch(mid + 1, end);
        }
        else return;
    }
}
