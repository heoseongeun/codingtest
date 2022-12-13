package 실전문제.정렬;

import java.util.Arrays;

// 매우 빠른 알고리즘
// 데이터 개수 N, 데이터 중 최댓값 K일 때 O(N + K)
// 가장 큰 데이터와 가장 작은 데이터의 차이가 너무 크면 사용 불가능
// 모든 범위를 담을 수 있는 크기의 배열 선언해야하기 때문
// 위치 변경 방식 X
public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] count = new int[Arrays.stream(arr).max().getAsInt() + 1]; // 가장 큰 수 9 + 1

        for(int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }

        for(int i = 0; i < count.length; i++) {
            for(int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
