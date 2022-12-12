package 실전문제.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        for(int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < K; i++) {
            if(A[i] < B[N - 1 - i]) {
                int temp = A[i];
                A[i] = B[N - 1 - i];
                B[N - 1 - i] = temp;
            } else break;
        }
        System.out.println(Arrays.stream(A).sum());
    }
}
