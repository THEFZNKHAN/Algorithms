import java.io.*;

public class Apartments {
    static class FastReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int k = fr.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fr.nextInt();
        }

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = fr.nextInt();
        }

        radixSort(a);
        radixSort(b);

        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            int desired = a[i];
            int current = b[j];
            if (current < desired - k) {
                j++;
            } else if (current > desired + k) {
                i++;
            } else {
                count++;
                i++;
                j++;
            }
        }

        System.out.println(count);
    }

    static void radixSort(int[] a) {
        int[] output = new int[a.length];
        for (int shift = 0; shift < 32; shift += 8) {
            int[] count = new int[256];
            for (int num : a) {
                int b = (num >>> shift) & 0xFF;
                count[b]++;
            }
            for (int i = 1; i < 256; i++) {
                count[i] += count[i - 1];
            }
            for (int i = a.length - 1; i >= 0; i--) {
                int b = (a[i] >>> shift) & 0xFF;
                output[--count[b]] = a[i];
            }
            System.arraycopy(output, 0, a, 0, a.length);
        }
    }
}