package 기출문제.최단경로;

import java.util.*;

public class P388 {
    static final int INF = 99999;
    static int[][] arr = new int[125][125];
    static int[][] d = new int[125][125];
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int T, N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for(int test = 0; test < T; test++) {
            N = scanner.nextInt();
            for(int i = 0; i < N; i++) {
                Arrays.fill(d[i], INF);
                for(int j = 0; j < N; j++)
                    arr[i][j] = scanner.nextInt();
            }
            int x = 0, y = 0;
//            PriorityQueue<Node> pq = new PriorityQueue<>();
            Queue<Node> pq = new LinkedList<>();
            pq.offer(new Node(x, y, arr[x][y]));
            d[x][y] = arr[x][y];
            while(!pq.isEmpty()) {
                Node node = pq.poll();
                int distance = node.getDistance();
                x = node.getX();
                y = node.getY();
                if(d[x][y] < distance) continue;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    int cost = distance + arr[nx][ny];
                    if(cost < d[nx][ny]) {
                        d[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
            System.out.println(d[N - 1][N - 1]);
        }
    }
}

class Node {
    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }

//    @Override
//    public int compareTo(Node o) {
//        if(this.distance < o.distance) return -1;
//        return 1;
//    }
}