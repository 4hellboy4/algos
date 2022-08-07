//package hw2;
//
//import java.awt.image.DataBufferDouble;
//import java.io.*;
//import java.math.BigInteger;
//
//import java.util.*;
//
//public class draft {
//
//    public static void main(String[] args) {
//        solve();
//    }
//
//    public static void solve() {
//        FastReader sc = new FastReader();
//
//        int t = sc.nextInt();
//
//        for (int j = 0; j < t; j++) {
//            int n = sc.nextInt();
//            int[] arr = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//
//            int val = arr[0];
//
//            boolean flag = true;
//            for (int i = 1; i < n; i++) {
//                if (arr[i] % val != 0) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            System.out.println(flag ? "YES" : "NO");
//        }
//
//    }
//
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader() {
//            br = new BufferedReader(new
//                    InputStreamReader(System.in));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int ni() {
//            return Integer.parseInt(next());
//        }
//
//        long nl() {
//            return Long.parseLong(next());
//        }
//
//        double nd() {
//            return Double.parseDouble(next());
//        }
//
//        String nextl() {
//            String str = "";
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//
//    }
//
//}