package baekjoon.l1.byte_input;

import java.io.*;

// 지금까지 제일 빠르고 메모리 사용량도 적었음 ()
public class Main {
    static class FastIO {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        private byte[] outBuffer;
        private int outIndex;

        public FastIO() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
            outBuffer = new byte[BUFFER_SIZE];
            outIndex = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }

        public void print(int n) throws IOException {
            if(outIndex + 11 >= BUFFER_SIZE) flush();
            if(n == 0) {
                outBuffer[outIndex++] = '0';
                return;
            }
            int startIdx = outIndex;
            while(n > 0) {
                outBuffer[outIndex++] = (byte) ('0' + (n % 10));
                n /= 10;
            }
            for(int i = startIdx, j = outIndex-1; i < j; i++, j--) {
                byte temp = outBuffer[i];
                outBuffer[i] = outBuffer[j];
                outBuffer[j] = temp;
            }
        }

        public void flush() throws IOException {
            System.out.write(outBuffer, 0, outIndex);
            System.out.flush();
            outIndex = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        int T = io.nextInt();
        for (int i = 0; i < T; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            io.print(a + b);
            io.outBuffer[io.outIndex++] = '\n';
        }
        io.flush();
    }
}
