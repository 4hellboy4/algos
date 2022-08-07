//package informatics_school;
//
//import java.util.*;
//
//public class inf2 {
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int n = scan.nextInt();
//        Stack<HashMap<Integer, Integer>> stack = new Stack<>();
//        int cnt = 0;
//
//        for (int i = 0; i < n; i++) {
//            int num = scan.nextInt();
//            HashMap<Integer, Integer> hash = new HashMap<>();
//            if (stack.isEmpty()) {
//                hash.put(num, 1);
//                stack.add(hash);
//            } else {
//                if (stack.peek().containsKey(num)) {
//                    var pop = stack.pop();
//                    pop.put(num, pop.get(num) + 1);
//                    stack.add(pop);
//
//                } else {
//                    if (stack.size() > 1 && stack.peek().get()) {
//
//                    }
//                    hash.put(num, 1);
//                    stack.add(hash);
//                }
//            }
//        }
//    }
//
//}
