package 기출문제.그래프이론;

import java.util.*;

// 백준 3665 최종 순위
public class P399 {
    static int testCase, n, m;
    static int[] indegree = new int[501];
    static boolean[][] graph = new boolean[501][501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        testCase = scanner.nextInt();
        for(int tc = 0; tc < testCase; tc++) {
            Arrays.fill(indegree, 0);
            for(int i = 0; i < 501; i++) Arrays.fill(graph[i], false);

            n = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                arrayList.add(x);
            }

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    graph[arrayList.get(i)][arrayList.get(j)] = true;
                    indegree[arrayList.get(j)]++;
                }
            }

            m = scanner.nextInt();
            for(int i = 0; i < m; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if(graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            // Topology Sort
            ArrayList<Integer> result = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= arrayList.size(); i++) {
                if(indegree[i] == 0) q.offer(i);
            }

            boolean cycle = false;
            boolean check = true;
            for(int i = 0; i < n; i++) {
                if(q.isEmpty()) {
                    cycle = true;
                    break;
                }
                if(q.size() > 1) { // 가능한 결과가 여러 가지
                    check = false;
                    break;
                }
                int now = q.poll();
                result.add(now);
                for(int j = 1; j <= n; j++) {
                    if(graph[now][j]) {
                        indegree[j]--;
                        if(indegree[j] == 0) q.offer(j);
                    }
                }
            }

            if(cycle) System.out.println("IMPOSSIBLE");
            else if(!check) System.out.println("?");
            else {
                for(int i = 0; i < result.size(); i++)
                    System.out.print(result.get(i) + " ");
                System.out.println();
            }
        }
    }
}
