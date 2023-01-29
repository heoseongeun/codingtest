package 기출문제.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 프로그래머스 42889 실패율
// https://velog.io/@jinmin2216/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-42889%EC%8B%A4%ED%8C%A8%EC%9C%A8-JAVA
// 참고
public class P361 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        List<Info> infos = new ArrayList<>();
        int[] arr = new int[N + 2];
        int player = stages.length;
        for(int stage: stages) arr[stage]++;
        for(int i = 1; i < N + 1; i++) {
            if(player == 0) infos.add(new Info(0.0, i));
            else {
                infos.add(new Info((double) arr[i] / player, i));
                player -= arr[i];
            }
        }
        Collections.sort(infos);
        for(int i = 0; i < N; i++) result[i] = infos.get(i).index;
        return result;
    }

    private static class Info implements Comparable<Info> {
        double value;
        int index;
        public Info(double value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Info o) {
            if(this.value == o.value) return this.index - o.index;
            return (-1) * Double.compare(this.value, o.value);
        }
    }
}
