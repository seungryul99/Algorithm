import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long b;
    static long[][] adj;


    static long[][] pow(long b){

        if (b==1) return adj;

        long[][] tmp;
        tmp = pow(b/2);

        if(b % 2 == 0) return mul(tmp, tmp);
        else return mul(adj,mul(tmp,tmp));
    }

    static long[][] mul(long[][] a, long[][] b){

        long[][] res = new long[n+1][n+1];

        for (int i=1; i<=n; i++){

            for (int j=1; j<=n; j++) res[i][j] = go(i,j,a,b);
        }

        return res;
    }

    static long go(int y, int x, long[][] a, long[][] b){

        long sum = 0;

        for(int i=1; i<=n; i++) sum += (a[y][i] * b[i][x])%1000;

        return sum % 1000;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        b = Long.parseLong(stk.nextToken());
        adj = new long[n+1][n+1];

        for (int i=1; i<=n; i++){

            stk = new StringTokenizer(br.readLine());

            for (int j=1; j<=n; j++) adj[i][j] = Integer.parseInt(stk.nextToken());
        }

        for(int i=1; i<=n; i++){

            for (int j=1;j<=n;j++) System.out.print(pow(b)[i][j] % 1000 + " ");
            System.out.println();
        }
    }
}