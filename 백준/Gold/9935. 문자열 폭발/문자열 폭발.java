import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String x = br.readLine();
        Stack<Character> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        int eq = 0;

        // 자바 스택에는 get()이 있음

        for (int i = 0; i < s.length(); i++) {

            eq = 0;
            stk.push(s.charAt(i));
            if (stk.size() >= x.length()) {

                for (int j = 0; j < x.length(); j++) {

                    if (stk.get(stk.size() - x.length() + j) == x.charAt(j)) eq++;
                    else break;
                }
            }

            if (eq == x.length()) {
                for (int j = 0; j < x.length(); j++) stk.pop();
            }
        }

        if (stk.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        else {
            for (char c : stk) res.append(c);
        }
        System.out.println(res);

    }
}