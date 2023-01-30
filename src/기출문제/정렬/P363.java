package 기출문제.정렬;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 백준 1715 카드 정렬하기
public class P363 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) queue.add(scanner.nextInt());
        int result = 0;
        while(queue.size() > 1) {
            // 배열 중에서 가장 작은 2개의 수 더하기
            int temp = queue.poll() + queue.poll();
            queue.add(temp);
            result += temp;
        }
        System.out.println(result);
    }
}
