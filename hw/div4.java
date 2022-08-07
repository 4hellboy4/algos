//package hw;

import java.io.*;
import java.util.*;

public class div4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        File file = new File("src/hw2/27_4-1b.txt");
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];
        ArrayList<int[]> array = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] list = new int[n];
            int ind = 0;
            for (int j = 0; j < n; j++) {
                list[ind] = matrix[j][i];
                ind++;
            }
            array.add(list);
        }


        for (int[] lists : array) {
            for (Integer num : lists) {
                writer.write(num + " ");
            }
            writer.write("\n");
        }

        writer.close();
        reader.close();

//        int n = scan.nextInt();
//        List<Integer>[] matrix = new List[n];
//        ArrayList<int[]> arr = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            String[] strList = scan.nextLine().split(" ");
//            List<Integer> list = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                list.add(Integer.parseInt(strList[j]));
//            }
//            matrix[i]=list;
//        }
//
//        for (int i = n - 1; i >= 0; i++) {
//            int[] matr = new int[n];
//            int ind = 0;
//            for (int j = 0; j < n; j++) {
//                matr[ind] = matrix[j].get(i);
//                ind++;
//            }
//            arr.add(matr);
//        }
//
//        for (int[] list : arr) {
//            for (Integer i : list){
//                System.out.println(i + " ");
//            }
//            System.out.println();
//        }
//
//        scan.close();

    }
}
//public class div4 {
//
//    public static long binarySearch(long w, long h, long n) {
//        long low = Math.max(w, h);
//        long high = Math.max(w, h) * n;
//        while (low < high - 1) {
//            long mid = (low + high) / 2;
//            long jit = (mid / w) * (mid / h);
//            if (jit < n) {
//                low = mid;
//            } else {
//                high = mid;
//            }
//        }
//        return high;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner scan = new Scanner(System.in);
//
//        int N = scan.nextInt();
//        int x1 = scan.nextInt() - 1, y1 = scan.nextInt() - 1;
//        int x2 = scan.nextInt() - 1, y2 = scan.nextInt() - 1;
//        int[][] matrix = new int[N][N];
//        matrix[0][0] = 1;
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                matrix[i+1][]
//            }
//        }
//    }
//
//}
