package 실전문제.이진탐색;

// 이미 정렬된 데이터
// O(logN)
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println(binarySearch(arr, 11, 0, arr.length - 1));
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end) / 2;

        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else return binarySearch(arr, target, mid + 1, end);
    }
}
