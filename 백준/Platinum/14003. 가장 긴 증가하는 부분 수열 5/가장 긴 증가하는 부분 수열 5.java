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

        int[] input = new int[n];
        int[] lis = new int[n];
        int[] lisIndex = new int[n]; // 각 길이의 마지막 원소가 원본 배열의 몇 번째인지
        int[] prev = new int[n];     // 수열 복원용 이전 인덱스

        int length = 0;

        for (int i = 0; i < n; i++) {
            input[i] = fs.nextInt();

            int pos = lowerBound(lis, length, input[i]);

            lis[pos] = input[i];
            prev[i] = (pos > 0) ? lisIndex[pos - 1] : -1;
            lisIndex[pos] = i;

            if (pos == length) {
                length++;
            }
        }

        int[] answer = new int[length];
        int idx = lisIndex[length - 1];

        for (int i = length - 1; i >= 0; i--) {
            answer[i] = input[idx];
            idx = prev[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length).append('\n');
        for (int i = 0; i < length; i++) {
            sb.append(answer[i]).append(' ');
        }

        System.out.print(sb);
    }
}