package 실전문제.최단경로;

import java.util.*;

public class Telegram {
    static int INF = 9999999;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int C = scanner.nextInt();

        int time = 0;
        int count = 0;

        int[] distance = new int[N + 1]; // 최단거리 테이블
        Arrays.fill(distance, INF);
        ArrayList[] arr = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList();
        }
        for(int i = 0; i < M; i++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int Z = scanner.nextInt();
            arr[X].add(new int[]{Y, Z});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{C, 0});
        distance[C] = 0;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int dist = temp[1];
            int city = temp[0];

            if(distance[city] < dist) continue;
            for(int i = 0; i < arr[city].size(); i++) {
                ArrayList<int[]> node = arr[city];
                int cost = distance[city] + node.get(i)[1];
                if(cost < distance[node.get(i)[0]]) {
                    distance[node.get(i)[0]] = cost;
                    queue.add(new int[]{node.get(i)[0], cost});
                }
            }
        }

        for(int i : distance) {
            if(i != INF) {
                count++;
                time = Math.max(i, time);
            }
        }
        System.out.println(count - 1 + " " + time);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
