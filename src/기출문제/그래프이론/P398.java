package 기출문제.그래프이론;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 백준 2887 행성 터널
public class P398 {
    static int N;
    static int parent[] = new int[100001];
    public static ArrayList<Graph> edges = new ArrayList<>();
    public static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for(int i = 1; i <= N; i++) parent[i] = i;
        ArrayList<Position> x = new ArrayList<>();
        ArrayList<Position> y = new ArrayList<>();
        ArrayList<Position> z = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            x.add(new Position(a, i));
            y.add(new Position(b, i));
            z.add(new Position(c, i));
        }

        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);

        for(int i = 0; i < N - 1; i++) {
            edges.add(new Graph(x.get(i + 1).getX() - x.get(i).getX(), x.get(i).getY(), x.get(i + 1).getY()));
            edges.add(new Graph(y.get(i + 1).getX() - y.get(i).getX(), y.get(i).getY(), y.get(i + 1).getY()));
            edges.add(new Graph(z.get(i + 1).getX() - z.get(i).getX(), z.get(i).getY(), z.get(i + 1).getY()));
        }

        Collections.sort(edges);

        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
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

class Graph implements Comparable<Graph> {
    private int distance;
    private int A;
    private int B;

    public Graph(int distance, int A, int B) {
        this.distance = distance;
        this.A = A;
        this.B = B;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getA() {
        return this.A;
    }

    public int getB() {
        return this.B;
    }

    @Override
    public int compareTo(Graph o) {
        if(this.distance < o.distance) return -1;
        return 1;
    }
}

class Position implements Comparable<Position> {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Position o) {
        if(this.x == o.x) return Integer.compare(this.y, o.y);
        return Integer.compare(this.x, o.x);
    }
}