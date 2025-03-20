import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt;
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int n, int from, int tmp, int to){

        if(n==1) {
            cnt++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n-1,from,to,tmp);
        sb.append(from).append(" ").append(to).append("\n");
        cnt++;

        hanoi(n-1,tmp,from,to);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        hanoi(n,1,2,3);

        System.out.println(cnt);
        System.out.println(sb);

    }
}