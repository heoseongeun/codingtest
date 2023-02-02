package 기출문제.정렬;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2110 공유기 설치
// https://hidelookit.tistory.com/168 참고
public class P369 {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 집의 개수
        C = scanner.nextInt(); // 공유기의 개수
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);

        int left = 1;
        int right = arr[N - 1] - arr[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = arr[0];
            int count = 1;
            for (int i = 1; i < N; ++i) {
                // 집마다 거리 체크
                if (arr[i] - start >= mid) {  // 공유기 설치 가능한지 여부 체크
                    count++;
                    start = arr[i]; // 설치 했다면 여기 집 부터 다시 거리 체크
                }
            }

            if (count >= C) {
                result = mid;
                left = mid + 1;  // 공유기 사이 거리 더 늘릴 수 있는지 확인
            } else { // 공유기 추가 설치 필요
                right = mid - 1; // 공유기 사이 거리 더 좁힐 수 있는지 확인
            }
        }

        System.out.println(result);
    }
}
