package 실전문제.그래프이론;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UrbanDivision {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) parent[i] = i;

        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            edges.add(new Edge(C, A, B));
        }

        Collections.sort(edges);
        int result = 0;
        int max = 0;
        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            if(findParent(parent, a) != findParent(parent, b)) {
                unionParent(parent, a, b);
                result += cost;
                max = cost;
            }
        }
        System.out.println(result - max);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int findParent(int[] parent, int x) {
        if(parent[x] != x) parent[x] = findParent(parent, parent[x]);
        return parent[x];
    }
}

class Edge implements Comparable<Edge> {
    private int distance;
    private int A;
    private int B;

    public Edge(int distance, int A, int B) {
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
    public int compareTo(Edge o) {
        if(this.distance < o.distance) return -1;
        return 1;
    }
}