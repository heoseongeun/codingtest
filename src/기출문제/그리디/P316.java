package 기출문제.그리디;

import java.util.Scanner;

public class P316 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = 3;
        int[] food_times = new int[N];
        for(int i = 0; i < N; i++) food_times[i] = scanner.nextInt();
        int K = scanner.nextInt();

        int index = 0;
        for(int i = 0; i < K; i++) {
            while(food_times[index] == 0) index++;
            food_times[index++]--;
            if(index % (N - 2) == 0) index = 0;
        }
        System.out.println(index + 1);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
