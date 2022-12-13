package 실전문제.정렬;

import java.util.Arrays;

import static 실전문제.정렬.SelectionSort.swap;

/**
 * 시간복잡도 O(N^2)
 * 정렬이 거의 되어 있는 상태, 최선의 경우 O(N)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 9, 0 , 3, 1, 6, 2, 4, 8};

        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j - 1] > arr[j]) swap(j, j - 1, arr);
                else break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
