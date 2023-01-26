package 기출문제.DFS_BFS;

import java.util.*;

// 백준 16234 인구 이동
// https://easybrother0103.tistory.com/88 참고
public class P353 {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        while(true) {
            if(movePopulation() == 0) break;
            else result++;
        }
        System.out.println(result);
    }

    public static int movePopulation() {
        int union = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    visited[i][j] = true;
                    int sum = arr[i][j];
                    while(!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int x = now[0] + dx[k];
                            int y = now[1] + dy[k];
                            if(x >= 0 && x < N && y >= 0 && y < N) {
                                int gap = Math.abs(arr[now[0]][now[1]] - arr[x][y]);
                                if(!visited[x][y] && (gap >= L && gap <= R)) {
                                    queue.add(new int[]{x, y});
                                    list.add(new int[]{x, y});
                                    visited[x][y] = true;
                                    union++;
                                    sum += arr[x][y];
                                }
                            }
                        }
                    }

                    if(union > 0) {
                        int avg = sum / list.size();
                        for(int[] position: list) arr[position[0]][position[1]] = avg;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) Arrays.fill(visited[i], false);
        return union;
    }
}
