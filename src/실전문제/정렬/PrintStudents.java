package 실전문제.정렬;

import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            map.put(score, name);
        }

        Object[] arr = map.keySet().toArray();
        Arrays.sort(map.keySet().toArray()); // key 배열 정렬

        for(Object key: arr) {
            System.out.print(map.get(key) + " ");
        }
    }
}
