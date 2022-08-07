package hw2;

import java.util.*;

public class baseInf {

    private static ArrayList<Integer>[] graph;
    private static boolean[] used;
    public static void dfs (int V) {
        used[V] = true;
        for (int U : graph[V]) {
            if (used[U]) continue;
            dfs(U);
        }
    }

    public static long nod(long a, long b) {
        if (a == 0 || b == 0) {
            return a == 0 ? b : a;
        }
        return a > b ? nod(a % b, b) : nod(a, b % a);
    }
    public static long leastCommonMultiple(long a, long b) {
        return a / nod(a, b) * b;
    }

    public static boolean almostIsPrime(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (i!=n/i && (n/i) * i == n) {
                if (isPrime(i) && isPrime(n/i)) return true; //isPrime checks if a num is prime
            }
        }
        return false;
    }

    public static void sieveOfEratosthenes(int num1, int num2) {
        int start = num1;
        int end = num2;
        boolean[] sieve = new boolean[end+1];
        for (int i = start; i <= end; i++) {
            if (!sieve[i]) {
                System.out.println(i + " ");
                for (int j = i*2; j <= end; j+=i) {
                    sieve[j] = true;
                }
            }
        }
    }

    public static void factorization(int n) {
        for (int i = 2; i*i <= n; i++) {
            while (n%i==0) {
                System.out.print(i+" ");
                n/=i;
            }
        }

        if (n>1) System.out.print(n);
    }

    public static Integer[] binaryHeap(Integer[] arr) {
        //binaryHeapMax<Integer> binaryHeapMax = new binaryHeapMax<>(arr);
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = binaryHeapMax.extractMax();
        }
        return arr;
    }

    public static boolean isPrime(long n) {
        if (n == 1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static public int numsOfDivs(int n) {
        int cntDivs = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    cntDivs++;
                    continue;
                }
                cntDivs += 2;
            }
        }
        return cntDivs;
    }

    static public int bfs(ArrayList<Integer>[] graph, int S, int F) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        int[] dist = new int[n];
        int[] p = new int[n];
        Arrays.fill(p, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        while (!queue.isEmpty()) {
            int V = queue.poll();
            used[V] = true;
            for (int U : graph[V]) {
                if (used[U]) continue;
                p[U] = V;
                dist[U] = dist[V] + 1;
                queue.add(U);
            }
        }
        return dist[F];
    }

    public static boolean binarySearch(List<Integer> array, int X) {
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array.get(mid) == X) return true;
            if (X < array.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void merge(List<Integer> array, int left, int right) {
        int middle = (left + right) / 2;
        int postionLeft = 0;
        int positionRight = 0;
        List<Integer> temporary = new ArrayList<>(right - left);
        while (left + postionLeft < middle && middle + positionRight < right) {
            if (array.get(left + postionLeft) < array.get(middle + positionRight)) {
                temporary.add(array.get(left + postionLeft));
                postionLeft++;
            } else {
                temporary.add(array.get(middle + positionRight));
                positionRight++;
            }
        }
        while (left + postionLeft < middle) {
            temporary.add(array.get(left + postionLeft));
            postionLeft++;
        }
        while (middle + positionRight < right) {
            temporary.add(array.get(middle + positionRight));
            positionRight++;
        }
        for (int i = left; i < right; i++) {
            array.set(i, temporary.get(i - left));
        }
    }
    public static void mergeSort(List<Integer> array, int left, int right) {
        if (left + 1 >= right) return;
        mergeSort(array, left, (left + right) / 2);
        mergeSort(array, (left + right) / 2, right);
        merge(array, left, right);
    }

    public static List<Integer> insertionSort(List<Integer> array) {
        for (int k = 0; k < array.size(); k++) {
            for (int i = k; i > 0 && array.get(i - 1) > array.get(i); i--) {
                int chis = array.get(i);
                array.set(i, array.get(i - 1));
                array.set(i - 1, chis);
            }
        }
        return array;
    }

    public static void bubbleSort(List<Integer> array) {
        for (int k = 0; k < array.size(); k++) {
            for (int i = 0; i < array.size() - 1; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    int chis = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, chis);
                }
            }
        }
    }

    public static void selectionSort(List<Integer> array) {
        for (int k = 0; k < array.size() - 1; k++) {
            for (int i = k + 1; i < array.size(); i++) {
                if (array.get(k) > array.get(i)) {
                    int chis = array.get(k);
                    array.set(k, array.get(i));
                    array.set(i, chis);
                }
            }
        }
    }

    public static void countSort(List<Integer> array, int bondary) {
        ArrayList<Integer> sp = new ArrayList<>(bondary);
        for (int i = 0; i < bondary; i++) sp.add(0);
        array.forEach(a -> sp.set(a, sp.get(a) + 1));
        int index = 0;
        for (int i = 0; i < bondary; i++) {
            for (int j = 0; j < sp.get(i); j++) {
                array.set(index, i);
                index++;
            }
        }
    }

    /*
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }
     */
}
