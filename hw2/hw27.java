package hw2;

import java.io.*;
import java.util.*;

//10
//2
//10 8
//9
//6 7
//7 5
//5 8
//8 1
//1 10
//10 3
//3 4
//4 9
//9 2

//1 4 1 2 1 3 2 0 3 0
//8 10 10 10 8 8 8 8 10 10

public class hw27 {

    public static ArrayList<Integer>[] graph;

    public static int bfs(int from, int to) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        int minDist = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            used[node] = true;
            for (Integer U : graph[node]) {
                if (used[U]) continue;
                if (U == to) {
                    minDist = Math.min(minDist, dist[node] + 1);
                }
                dist[U] = dist[node] + 1;
                queue.add(U);
            }
        }
        return minDist == Integer.MAX_VALUE ? 0 : minDist;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        //Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(reader.readLine());
        int[] time = new int[n];
        int[] nearest = new int[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        int k = Integer.parseInt(reader.readLine());
        int[] exits = new int[k];
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            exits[i] = num;
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
            int exit = exits[0];
            int path = Integer.MAX_VALUE;
            for (Integer i : exits) {
                int dist = bfs(node, i);
                if (path > dist) {
                    path = dist;
                    exit = i;
                }
                if (path == dist) {
                    if (i < exit) {
                        exit = i;
                    }
                }
            }
            nearest[node] = exit;
            time[node] = path;
        }

        for (Integer i : time) {
            writer.write(i + " ");
        }

        writer.write("\n");

        for (Integer i : nearest) {
            writer.write((i + 1) + " ");
        }

        writer.close();
        reader.close();

    }
}

//Ans1: 55251 23680
//78931

//Ans2:210042505 104783302
//314825807

////по каждому символу пройтись
////получить аски и перевсти в 16
////
//
//public class hw27 {
//
//    public static String mask;
//    public static HashMap<String, Integer> map16 = new HashMap<>();
//    public static HashMap<Integer, String> map = new HashMap<>();//строка
//    public static StringBuilder str = new StringBuilder();//итоговая строка
//    public static StringBuilder num16 = new StringBuilder();//шестнадцатеричная сс числа
//    public static StringBuilder num2 = new StringBuilder();//двоичная сс числа
//    public static int div;
//
//    public static void def16(int n) {
//        if (n == 0) return;
//        div = n % 16;
//        if (map.containsKey(div)) {
//            num16.append(map.get(div));
//        } else {
//            num16.append(div);
//        }
//        def16(n / 16);
//    }
//
//    public static void def2(int strNum16) {
//        if (strNum16 == 0) return;
//        div = strNum16 % 2;
//        num2.append(div);
//        def2(strNum16/2);
//    }
//
//    public static int pow(int value, int powValue) {
//        int result = 1;
//        for (int i = 1; i <= powValue; i++) {
//            result = result * value;
//        }
//        return result;
//    }
//
//    public static String charTransfer(int symChar) {
//        def16(symChar);
//        StringBuilder cipherText = new StringBuilder();
//        String strNum16 = num16.reverse().toString();
//        for (int i = strNum16.length() - 1; i >= 0; i--) {
//            char sym = strNum16.charAt(i);
//            if (Character.isDigit(sym)) {
//                def2(Integer.parseInt(String.valueOf(strNum16.charAt(i))));
//            } else {
//                int symInt = map16.get(String.valueOf(sym));
//                def2(symInt);
//            }
//            //def2(Integer.parseInt(String.valueOf(strNum16.charAt(i))));
//            if (num2.length()<4) {
//                while (num2.length()!=4) {
//                    num2.append(0);
//                }
//                continue;
//            }
//        }
//        if (num2.length() < 8) {
//            while (num2.length()!=8) {
//                num2.append(0);
//            }
//        }
//        String strNum2 = num2.reverse().toString();
//        int A;
//        int B;
//        for (int i = 0; i < strNum2.length(); i++) {
//            A = strNum2.charAt(i);
//            B = mask.charAt(i);
//            cipherText.append((A + B) % 2);
//        }
//        num2.setLength(0);
//        num16.setLength(0);
//        int ind = 1;
//        int sum = 0;
//        StringBuilder from4to16 = new StringBuilder();
//        cipherText.reverse();//00100101 -> 10100100
//        for (int i = 0; i < cipherText.length(); i++) {
//            if (ind % 5 == 0) {
//                ind = 1;
//                if (map.containsKey(sum)) {
//                    from4to16.append(map.get(sum));
//                } else {
//                    from4to16.append(sum);
//                }
//                sum=0;
//            }
//            if (Integer.parseInt(String.valueOf(cipherText.toString().charAt(i))) == 1) {
//                if (ind == 1) {
//                    sum+=1;
//                }
//                if (ind == 2) {
//                    sum+=2;
//                }
//                if (ind == 3) {
//                    sum+=4;
//                }
//                if (ind == 4) {
//                    sum+=8;
//                }
//            }
//            ind++;
//        }
//        if (map.containsKey(sum)) {
//            from4to16.append(map.get(sum));
//        } else {
//            from4to16.append(sum);
//        }
////        from4to16.append(sum);
//        ind = 0;
//        sum=0;
//        //from4to16.reverse();
//        for (int i = 0; i < from4to16.length(); i++) {
//            char sym = from4to16.toString().charAt(i);
//            if (Character.isDigit(sym)) {
//                sum+=Integer.parseInt(String.valueOf(sym)) * pow(16, ind);
//            } else {
//                sum+= map16.get(String.valueOf(sym)) * pow(16, ind);
//            }
//            ind++;
//        }
//        return String.valueOf(Character.toChars(sum));
//    }
//
//    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        System.out.print("Your string: ");
//        String string = scan.next();//"2*2=4";
//        System.out.print("Your mask: ");
//        mask = scan.next();//"00010111";
//
//        map.put(10, "A");
//        map.put(11, "B");
//        map.put(12, "C");
//        map.put(13, "D");
//        map.put(14, "E");
//        map.put(15, "F");
//
//        map16.put("A", 10);
//        map16.put("B", 11);
//        map16.put("C", 12);
//        map16.put("D", 13);
//        map16.put("E", 14);
//        map16.put("F", 15);
//
//        for (int i = 0; i < string.length(); i++) {
//            char ascySym = string.charAt(i);
//            str.append(charTransfer(ascySym));
//        }
//
//        System.out.println("Your string: " + str.toString());
////        System.out.println("Want to dehack again: \"Yes\" or \"No\"?");
////        System.out.print("Your answer: ");
////
////        String cont = scan.next();
////
////        if (cont=="No") {
////            System.out.println("The program is finished");
////        } else {
////            for (int i = 0; i < str.length(); i++) {
////                char ascySym = str.toString().charAt(i);
////                str.append(charTransfer(ascySym));
////            }
////        }
//
//    }
//}