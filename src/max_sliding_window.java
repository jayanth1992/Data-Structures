import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class max_sliding_window {

    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class SlidingWindow{
        int n;
        int sequence[];
        int m;
        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = in.nextInt();
            }
            m = in.nextInt();
        }

        int[] getMaxSequence(){
            int[] ans = new int[n - m + 1];
            int j = 0;
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < m; i++){
                if (deque.isEmpty()) {
                    deque.add(i);
                } else {
                    while (!deque.isEmpty() && sequence[deque.peekLast()] <= sequence[i]) {
                        deque.pollLast();
                    }
                    deque.addLast(i);
                }
            }

            ans[j++] = sequence[deque.peekFirst()];

            for (int i = m; i < sequence.length; i++) {

                while (!deque.isEmpty() && deque.peekFirst() <= i - m ) {
                    deque.removeFirst();
                }

                while (!deque.isEmpty() && sequence[deque.peekLast()] <= sequence[i]) {
                    deque.removeLast();
                }

                deque.addLast(i);

                ans[j++] = sequence[deque.peekFirst()];
            }

            return ans;
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new max_sliding_window().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        SlidingWindow sWindow = new SlidingWindow();
        sWindow.read();
        int[] ans = sWindow.getMaxSequence();
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
