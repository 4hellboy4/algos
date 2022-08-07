package hw;

import java.io.*;
import java.util.*;

public class myHw {

    public static void main(String[] args) throws IOException {
//        File file = new File("src/files27/27-2b.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            String[] strLists = str.split("W");
            int cnt = 0;
            for (String j : strLists) {
                if (j == "") {
                    cnt++;
                    continue;
                }
                boolean hasR = false;
                boolean hasB = false;
                for (int k = 0; k < j.length(); k++) {
                    char ch = j.charAt(k);
                    if (ch == 66) hasB = true;
                    if (ch == 82) hasR = true;
                }
                if (hasB && hasR) {
                    cnt++;
                }
            }
            if (cnt == strLists.length) {
                writer.write("YES" + "\n");
            } else {
                writer.write("NO" + "\n");
            }
        }

        writer.close();
        reader.close();
    }
}