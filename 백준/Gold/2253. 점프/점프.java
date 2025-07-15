import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 100_000_000;
    static int n, m;
    static int[] adj;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        adj = new int[n+1];
        for (int i=0; i<m; i++) adj[Integer.parseInt(br.readLine())]++;

        // 10000 = 100 * 100, 150 * 150 == 22500, 1 ~ 150 까지 다 더해도 10000 언저리
        dp= new int[n+1][150];

        for (int i=0; i<=n; i++) Arrays.fill(dp[i], INF);

        int res = go(1, 0);
        System.out.println(res == INF ? -1 : res);
    }

    public static int go(int cur, int jump){

        // 기저
        if (cur > n || adj[cur] == 1) return INF;
        if (cur == n) return 0;

        // 메모이제이션
        if (dp[cur][jump] != INF) return dp[cur][jump];

        // 로직
        int val = INF;
        val = min(val, 1 + go(cur + jump +1, jump +1));
        if(jump > 0){
            val = min(val, 1 + go(cur + jump -1, jump -1));
            val = min(val, 1 + go(cur + jump, jump));
        }

        return dp[cur][jump] = val;
    }
}
