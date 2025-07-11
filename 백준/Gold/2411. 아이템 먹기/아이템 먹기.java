import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] adj;
    static int n;
    static int m;
    static int a;

    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        adj = new int[n+1][m+1];

        for (int i=0; i<a; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            adj[x][y] = 1;
        }

        for (int i=0; i<b; i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            adj[x][y] = 2;
        }

        dp = new int[n+1][m+1][a+1];
        for(int i=1; i<=n; i++) {
            for (int j = 1; j <= m; j++)
                for(int k=0; k<a+1;k++) dp[i][j][k] = -1;
        }

        System.out.println(go(1,1,0));
    }

    public static int go(int y, int x, int cnt) {

        if (y==n && x==m) {

            if(cnt == a) return 1;
            else return 0;
        }
        if(dp[y][x][cnt] != -1) return dp[y][x][cnt];

        int nextCnt = cnt;
        if(adj[y][x] == 1) nextCnt++;

        int val = 0;
        if(y+1 <= n && adj[y+1][x] != 2) val += go(y+1,x,nextCnt);
        if(x+1 <= m && adj[y][x+1] != 2) val += go(y,x+1,nextCnt);

        return dp[y][x][cnt] = val;
    }

}
