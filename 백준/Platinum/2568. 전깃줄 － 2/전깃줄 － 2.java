import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    static class Wire implements Comparable<Wire> {
        int a, b;

        Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Wire o) {
            return Integer.compare(this.a, o.a);
        }
    }

    static int lowerBound(int[] arr, int size, int target) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        Wire[] wires = new Wire[n];
        for (int i = 0; i < n; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            wires[i] = new Wire(a, b);
        }

        Arrays.sort(wires);

        int[] tails = new int[n];      // 각 길이별 LIS 마지막 B의 최소값
        int[] tailIndex = new int[n];  // 각 길이별 LIS 마지막 원소의 인덱스
        int[] prev = new int[n];       // 복원용 이전 인덱스
        Arrays.fill(prev, -1);

        int lisLength = 0;

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tails, lisLength, wires[i].b);

            if (pos > 0) {
                prev[i] = tailIndex[pos - 1];
            }

            tails[pos] = wires[i].b;
            tailIndex[pos] = i;

            if (pos == lisLength) {
                lisLength++;
            }
        }

        boolean[] keep = new boolean[n];
        int idx = tailIndex[lisLength - 1];
        while (idx != -1) {
            keep[idx] = true;
            idx = prev[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n - lisLength).append('\n');

        for (int i = 0; i < n; i++) {
            if (!keep[i]) {
                sb.append(wires[i].a).append('\n');
            }
        }

        System.out.print(sb);
    }
}