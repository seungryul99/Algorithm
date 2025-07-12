import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] adj;
    static int[][] dp;
    static int n;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        adj = new int[n][n];
        dp = new int[n][n];

        for (int i=0; i<n; i++) {
            stk = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) {

                adj[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                res = max(1+go(i,j), res);
            }
        }

        System.out.println(res);
    }


    public static int go(int y, int x) {

        if(dp[y][x] != -1) return dp[y][x];
        
        int val = 0;

        for (int w=0; w<4; w++) {
            int ny = y + dy[w];
            int nx = x + dx[w];

            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if(adj[ny][nx] <= adj[y][x]) continue;

            val = max(val, 1 + go(ny, nx));
        }

        return dp[y][x] = val;
    }
}
