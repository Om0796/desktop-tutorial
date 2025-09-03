import java.util.*;

public class Main {
    static int[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void BFS(int[][] graph, int vertices, int startVertex) {
        visited = new int[vertices];
        queue.add(startVertex);
        visited[startVertex] = 1;
        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < vertices; i++) {
                if (graph[currentVertex][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Vertices: ");
        int vertices = sc.nextInt();
        int[][] graph = new int[vertices][vertices];
        System.out.println("Enter the Adjacency Matrix (" + vertices + " x " + vertices + "):");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the Starting Vertex: ");
        int start = sc.nextInt();
        BFS(graph, vertices, start);
        sc.close();
    }
}
