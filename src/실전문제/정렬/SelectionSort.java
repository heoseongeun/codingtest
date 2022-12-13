package 실전문제.정렬;

import java.util.Arrays;

// O(N^2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 9, 0 , 3, 1, 6, 2, 4, 8};

        for(int i = 0; i < arr.length; i++) {
            int min_index = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[min_index] > arr[j]) min_index = j;
            }
            swap(min_index, i, arr);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
