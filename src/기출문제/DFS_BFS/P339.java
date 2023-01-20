package 기출문제.DFS_BFS;

import java.util.*;

// 백준 18352 특정 거리의 도시 찾기
// bfs 이용 (간선 거리가 1이기 때문)
// https://subin-programming.tistory.com/219 참고
public class P339 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int X = scanner.nextInt();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int[] distance = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            arrayList.add(new ArrayList<>());
            distance[i] = -1;
        }
        for(int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            arrayList.get(A).add(B);
        }

        distance[X] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i = 0; i < arrayList.get(node).size(); i++) {
                int next = arrayList.get(node).get(i);
                if(distance[next] == -1) {
                    distance[next] = distance[node] + 1;
                    queue.add(next);
                }
            }
        }

        boolean check = false;
        for(int i = 0; i < N + 1; i++) {
            if(distance[i] == K) {
                System.out.println(i);
                check = true;
            }
        }
        if(!check) System.out.println(-1);
    }
}
