import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {

    static int n;
    static int[][] adj = new int[17][17];
    static int[][] dp = new int[17][(1<<16)+1];
    static int INF = 100_000_004;

    static int go(int cur, int visited){

        // 기저 1111 1111 1111 1111
        if(visited == (1<<n)-1) return adj[cur][1] == 0 ? INF:adj[cur][1];

        // 메모이제이션
        if(dp[cur][visited] != -1) return dp[cur][visited];

        // 로직
        int val = INF;

        for(int i=1; i<=n;i++){

            if((visited & (1<<i-1)) != 0) continue;
            if(adj[cur][i] == 0) continue;

            val = min(val, go(i,visited + (1<<i-1)) + adj[cur][i]);
        }

        return dp[cur][visited] = val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=1; i<=n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) adj[i][j] = Integer.parseInt(st.nextToken());
        }

        // [로직]
        for(int i=0;i<=n;i++) Arrays.fill(dp[i] ,-1);

        // [출력]
        int res = go(1,1);
        System.out.println(res > 20000004 ? 0 : res);
    }
}