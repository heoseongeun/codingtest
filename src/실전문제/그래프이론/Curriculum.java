package 실전문제.그래프이론;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] indegree = new int[N + 1]; // 진입 차수
        int[] time = new int[N + 1]; // 강의 시간
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<Integer>()); // 그래프 초기화

        for(int i = 1; i < N + 1; i++) {
            time[i] = scanner.nextInt();
            while(true) {
                int input = scanner.nextInt();
                if(input == -1) break;
                indegree[i]++;
                graph.get(input).add(i);
            }
        }

        topologySort(time, graph, indegree);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }

    public static void topologySort(int[] time, ArrayList<ArrayList<Integer>> graph, int[] indegree) {
        int[] result = time.clone();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < time.length; i++) if(indegree[i] == 0) queue.add(i);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)],
                        result[now] + time[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)] == 0) queue.add(graph.get(now).get(i));
            }
        }

        for(int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
