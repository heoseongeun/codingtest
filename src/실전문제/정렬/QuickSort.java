package 실전문제.정렬;

import java.util.Arrays;

import static 실전문제.정렬.SelectionSort.swap;

// 평균적으로 O(NlongN)
// 최악의 경우 O(N^2)
// 삽입 정렬과 다르게 이미 데이터가 정렬되어 있는 경우 매우 느리게 동작
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 9, 0 , 3, 1, 6, 2, 4, 8};
        quickSort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int start, int end, int[] arr) {
        if(start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;
        while(left <= right) {
            // pivot 보다 큰 데이터 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) left++;
            // pivot 보다 작은 데이터 찾을 때까지 반복
            while(right > start && arr[right] >= arr[pivot]) right--;
            if(left > right) swap(pivot, right, arr);
            else swap(left, right, arr);
        }
        quickSort(start, right - 1, arr);
        quickSort(right + 1, end, arr);
    }
}
