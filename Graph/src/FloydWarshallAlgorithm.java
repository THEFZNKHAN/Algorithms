public class FloydWarshallAlgorithm {
    final static int INF = 99999; // Use a large value to represent infinity

    void floydWarshall(int graph[][]) {
        int V = graph.length;
        int dist[][] = new int[V][V];

        for (int i = 0; i < V; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, V);
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        int V = dist.length;
        System.out.println("Following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshallAlgorithm a = new FloydWarshallAlgorithm();
        int graph[][] = { { 0, 3, INF, 5 },
                { 2, 0, INF, 4 },
                { INF, 1, 0, INF },
                { INF, INF, 2, 0 } };

        a.floydWarshall(graph);
    }
}