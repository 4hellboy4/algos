package stack_deck;

//import stack_deck.Interface;

import java.io.*;
import java.util.*;

public class stack_task {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int cnt = 0;
        boolean ans = false;

        while (true) {
            if (!stack1.isEmpty()) {
                int num = stack1.peek();

            } else {

            }
        }

        //writer.close();
        //reader.close();

    }

}