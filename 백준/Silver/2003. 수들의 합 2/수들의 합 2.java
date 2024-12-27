import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] psum = new int[10004];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++)
            psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());


        int res = 0;

        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++) {

                if (m == psum[j] - psum[i-1]) res++;
            }
        }

        System.out.println(res);
    }
}