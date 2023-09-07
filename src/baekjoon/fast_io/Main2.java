package baekjoon.fast_io;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int maxScore = 0;
        int totalScore = 0;
        for (int i = 0; i < n; ++i) {
            int score = readInt();
            totalScore += score;
            maxScore = maxScore > score ? maxScore : score;
        }
        System.out.println(100.0d * totalScore / maxScore / n);
    }
    
    static int readInt() throws IOException {
        int retValue = 0;
        boolean negative = false;
        while (true) {
            int i = System.in.read();
            if (i == '\r') continue;
            if (i == ' ' || i == '\n') {
                break;
            }
            else {
                if (i == '-') negative = true;
                else {
                    retValue = retValue * 10 + i - '0';
                }
            }
        }
        return negative ? -1 * retValue : retValue;
    }      
}