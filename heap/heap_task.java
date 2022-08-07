package heap;

import java.io.*;
import java.util.*;

public class heap_task {

    public static void main(String[] args) throws IOException {
        File fileIn = new File("src/heap/input");
        File fileOut = new File("src/heap/output");
//        File fileIn = new File("input.txt");
//        File fileOut = new File("output.txt");

        BufferedReader reader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut));

        StringTokenizer str = new StringTokenizer(reader.readLine());
        int capacity = Integer.parseInt(str.nextToken());
        int operations = Integer.parseInt(str.nextToken());
        BinaryHeapMax<Integer> binaryHeap = new BinaryHeapMax<>(capacity);

        for (int i = 0; i < operations; i++) {
            String[] stringList = reader.readLine().split(" ");
            if (stringList.length > 1) {
                int oper = Integer.parseInt(stringList[0]);
                int num = Integer.parseInt(stringList[1]);
                if (oper == 2) {
                    if (binaryHeap.getSize() == capacity) {
                        writer.write(-1 + "\n");
                    } else {
                        binaryHeap.insert(num);
                    }
                } else {
                    int index = num - 1;
                    if (index < binaryHeap.getSize() && index >= 0) {
                        binaryHeap.remove(index);
                    } else {
                        writer.write(-1 + "\n");
                    }
                }
            } else {
                if (binaryHeap.getSize() == 0) {
                    writer.write(-1 + "\n");
                } else {
                    writer.write(binaryHeap.extractMax() + "\n");
                }
            }
            if (binaryHeap.getSize() == 0) {
                writer.write(-1 + "\n");
            } else {
                for (int j = 0; j < binaryHeap.getSize(); j++) {
                    writer.write(binaryHeap.get(j) + " ");
                }
                writer.write("\n");
            }


        }

        writer.close();
        reader.close();

    }

}