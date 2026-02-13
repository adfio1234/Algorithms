
import java.util.Scanner;

public class Main {
    static void printPairs(int n) {
        int cnt = (2 * n + 1) / 3;  // 최대 쌍의 개수
        System.out.println(cnt);

        for (int i = 1; i <= cnt; i++) {
            int a = n + 1 - i;
            int b;

            if (i % 2 == 1) { // i가 홀수
                b = (cnt + 1) / 2 + 1 - ((i + 1) / 2);
            } else {          // i가 짝수
                b = a - ((cnt / 2) - (i / 2));
            }

            System.out.println(a + " " + b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            printPairs(n);
        }
    }
}
