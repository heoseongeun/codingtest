package 기출문제.이진탐색;

import java.util.Scanner;

public class P368 {
    static int N;
    static int[] arr;
    static int result = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        binarySearch(0, N - 1);
        System.out.println(result);
    }
    public static void binarySearch(int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            if(arr[mid] == mid) {
                result = mid;
                return;
            }
            binarySearch(start, mid);
            binarySearch(mid + 1, end);
        } else return;
    }
}
