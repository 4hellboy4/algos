package fyi_features;

import java.io.*;
import java.util.*;

public class r3hab_rs {

    //<------------------------------------------Reader---------------------------------------->
    static class Reader {
        public BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nd() {
            return Double.parseDouble(next());
        }

        String nextl() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] arrin(long num) {
            int n = (int) num;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = ni();
            return a;
        }

        long[] arrnl(long num) {
            int n = (int) num;
            long[] l = new long[n];
            for (int i = 0; i < n; i++) l[i] = nl();
            return l;
        }
    }

    //<------------------------------------------------WRITER---------------------------->
    static class Writer {
        static PrintWriter out;

        public Writer() {
            this(System.out);
        }

        public Writer(OutputStream outs) {
            out = new PrintWriter(outs);
        }

        public void pl(int i) {
            out.println(i);
        }

        public void pl(long l) {
            out.println(l);
        }

        public void pl(double d) {
            out.println(d);
        }

        public void pl(String s) {
            out.println(s);
        }

        public void p(int i) {
            out.print(i);
        }

        public void p(long l) {
            out.print(l);
        }

        public void p(double d) {
            out.print(d);
        }

        public void p(String s) {
            out.print(s);
        }

        public void p() {
            out.println();
        }

        public void close() {
            out.close();
        }
    }
//----------------------------------------------------------------------------------->

    //--------------------------VARIABLES------------------------------------//
    static Reader in = new Reader();
    static OutputStream outputStream = System.out;
    static Writer out = new Writer(outputStream);
    static long lmax = Long.MAX_VALUE, lmin = Long.MIN_VALUE;
    static int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
    static long mod = 1000000007;
    //-----------------------------------------------------------------------//

    //--------------------------Red_Hair-----------------------------------//
    private static void Red_Hair() throws IOException {
        String FILE = "RED";
        try {FILE = System.getProperty("user.dir");}
        catch (Exception e) { }
        if(new File(FILE).getName().equals("CP")){
            out = new Writer(new FileOutputStream("output.txt"));
            in = new Reader(new FileInputStream("input.txt"));
        }
    }
    //-----------------------------------------------------------------------//

    public static void main(String[] args) throws IOException {
        Red_Hair();
        byte t = (byte) in.ni();
        while (t-- > 0)
            solve();
        out.close();
    }

    static void solve() throws IOException {

    }

}
