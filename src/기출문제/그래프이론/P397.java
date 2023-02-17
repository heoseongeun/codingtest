package 기출문제.그래프이론;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P397 {
    static int N, M;
    static int[] parent = new int[200001];
    static ArrayList<Edge> edges = new ArrayList<Edge>();
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for(int i = 1; i <= N; i++) parent[i] = i;

        for(int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            edges.add(new Edge(z, x, y));
        }

        Collections.sort(edges);
        int total = 0;
        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int x = edges.get(i).getX();
            int y = edges.get(i).getY();
            total += cost;
            if(findParent(x) != findParent(y)) {
                unionParent(x, y);
                result += cost;
            }
        }
        System.out.println(total - result);
    }

    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}

class Edge implements Comparable<Edge> {
    private int distance;
    private int X;
    private int Y;

    public Edge(int distance, int X, int Y) {
        this.distance = distance;
        this.X = X;
        this.Y = Y;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.distance < o.distance) return -1;
        return 1;
    }
}
