import java.util.ArrayList;
import java.util.Arrays;
class Edge {
    int destination;
    int weight;
    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    private ArrayList<Edge>[] adjList;
    private int vertices;
    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    public void addEdge(int source, int destination, int weight) {
        adjList[source].add(new Edge(destination, weight));
        adjList[destination].add(new Edge(source, weight));
    }
    public void dijkstra(int start) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            visited[u] = true;
            for (Edge edge : adjList[u]) {
                int v = edge.destination;
                int weight = edge.weight;
                if (!visited[v] &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;
                }
            }
        }
        System.out.println("Shortest distances from vertex " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(start + " -> " + i + " = " + dist[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);
        g.dijkstra(0);
    }
}