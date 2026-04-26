import java.io.*;
import java.util.*;

public class Main {
    static class Range {
        int inL, inR, postL, postR;

        Range(int inL, int inR, int postL, int postR) {
            this.inL = inL;
            this.inR = inR;
            this.postL = postL;
            this.postR = postR;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        int[] index = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            index[inorder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Deque<Range> stack = new ArrayDeque<>();
        stack.push(new Range(0, n - 1, 0, n - 1));

        while (!stack.isEmpty()) {
            Range cur = stack.pop();

            if (cur.inL > cur.inR || cur.postL > cur.postR) continue;

            int root = postorder[cur.postR];
            sb.append(root).append(' ');

            int rootIdx = index[root];
            int leftSize = rootIdx - cur.inL;
            int rightSize = cur.inR - rootIdx;

            // 전위순회는 root -> left -> right
            // stack은 LIFO이므로 right를 먼저 넣고 left를 나중에 넣는다.
            if (rightSize > 0) {
                stack.push(new Range(
                        rootIdx + 1, cur.inR,
                        cur.postL + leftSize, cur.postR - 1
                ));
            }

            if (leftSize > 0) {
                stack.push(new Range(
                        cur.inL, rootIdx - 1,
                        cur.postL, cur.postL + leftSize - 1
                ));
            }
        }

        System.out.println(sb);
    }
}