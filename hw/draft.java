package hw;


import java.io.*;
import java.util.*;

public class draft {

    public static int[] path;

    public static ArrayList<Integer>[] graph;

    public static int bfs(int from, int to) {
        int n = graph.length;
        int minDist = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(path, -1);
        boolean[] used = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            used[node] = true;
            for (Integer U : graph[node]) {
                if (used[U]) continue;
                if (U == to) {
                    minDist = Math.min(dist[node] + 1, minDist);
                }
                path[U] = node;
                dist[U] = dist[node] + 1;
                queue.add(U);
            }
        }
        return minDist;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(reader.readLine());
        int extraNode = n;
        int[] time = new int[n+1];
        int[] nearest = new int[n+1];
        graph = new ArrayList[n+1];
        path = new int[n+1];

        for (int i = 0; i < n+1; i++) graph[i] = new ArrayList<>();

        int k = Integer.parseInt(reader.readLine());
        int[] exits = new int[k];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            exits[i] = num;
            graph[extraNode].add(num);
            graph[num].add(extraNode);
        }

        int bunkersNum = Integer.parseInt(reader.readLine());//M

        for (int i = 0; i < bunkersNum; i++) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(stringTokenizer2.nextToken()) - 1;
            int b = Integer.parseInt(stringTokenizer2.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int node = 0; node < n; node++) {
            int dist = bfs(node, extraNode) - 1;
            time[node] = dist;
            nearest[node] = path[extraNode];
        }

//        for (int node = 0; node < n; node++) {
//            int exit = exits[0];
//            int path = Integer.MAX_VALUE;
//            for (Integer i : exits) {
//                int dist = bfs(node, i);
//                if (path > dist) {
//                    path = dist;
//                    exit = i;
//                }
//                if (path == dist) {
//                    if (i < exit) {
//                        exit = i;
//                    }
//                }
//            }
//            nearest[node] = exit;
//            time[node] = path;
//        }

        for (int i = 0; i < time.length - 1; i++) {
            writer.write(time[i] + " ");
        }

        writer.write("\n");

        for (int i = 0; i < nearest.length - 1; i++) {
            writer.write((nearest[i] + 1) + " ");
        }

        writer.close();
        reader.close();

    }

}