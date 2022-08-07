
package informatics_school;

import java.util.*;


public class inf {

    public static int[][] graph;
    public static int M;
    public static int N;

    public static List<Integer> arrI = new ArrayList<>(List.of(-1, 1, 0, 0));
    public static List<Integer> arrJ = new ArrayList<>(List.of(0,0, -1, 1));

    public static void bfs(int x, int y, int[][] maze) {
        for (int i = 0; i < 4; i++) {
            int indI = x + arrI.get(i);
            int indJ = y + arrJ.get(i);
            if (indI >= 0 && indI < N && indJ >= 0 && indJ < M && maze[indI][indJ] == 0) {
                if (graph[indI][indJ] == -1 || graph[indI][indJ] > graph[x][y] + 1) {
                    graph[indI][indJ] = graph[x][y] + 1;
                    bfs(indI, indJ, maze);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        N = n;
        M = m;
        int[][] path = new int[n][m];
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                path[i][j] = scan.nextInt();
            }
        }

        graph[0][0] = 0;

        bfs(0, 0, path);

        System.out.println(graph[n - 1][m - 1]);


    }

}
