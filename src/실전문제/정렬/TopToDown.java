package 실전문제.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class TopToDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        arr = Arrays.stream(arr).sorted().toArray();
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
}
