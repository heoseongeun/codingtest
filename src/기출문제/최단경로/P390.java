package 기출문제.최단경로;

import java.util.*;

public class P390 {
    static final int INF = 99999;
    static int N, M;
    static int start = 1;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<ArrayList<int[]>>();
    static int[] d = new int[20001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<int[]>());
        for(int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            graph.get(A).add(new int[]{B, 1});
            graph.get(B).add(new int[]{A, 1});
        }
        Arrays.fill(d, INF);
        dijkstra(start);

        int maxNode = 0;
        int maxDistance = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            if(maxDistance < d[i]) {
                maxNode = i;
                maxDistance = d[i];
                result.clear();
                result.add(maxNode);
            } else if (maxDistance == d[i]) {
                result.add(i);
            }
        }
        System.out.println(maxNode + " " + maxDistance + " " + result.size());
    }

    public static void dijkstra(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        d[start] = 0;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int dist = node[1];
            int now = node[0];
            if(d[now] < dist) continue;
            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i)[1];
                if(cost < d[graph.get(now).get(i)[0]]) {
                    d[graph.get(now).get(i)[0]] = cost;
                    q.offer(new int[]{graph.get(now).get(i)[0], cost});
                }
            }
        }
    }
}