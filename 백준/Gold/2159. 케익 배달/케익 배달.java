import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final long INF = 100000000000000L;
    static int[] dx = {0, 0, -1, 1, 0};
    static int[] dy = {1, -1, 0, 0, 0};
    static long[][] dp;

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(stk.nextToken());
        int startY = Integer.parseInt(stk.nextToken());

        for (int i=0; i<n; i++){

            stk = new StringTokenizer(br.readLine());
            list.add(new Pair(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }

        long res = INF;
        dp = new long[n+1][5];

        for (int i=0; i<n+1; i++) Arrays.fill(dp[i], INF);

        for (int i=0; i<5;i++){

            int nx = list.get(0).x + dx[i];
            int ny = list.get(0).y + dy[i];

            if (ny <= 0 || nx <= 0 || ny > 100000 || nx > 100000) continue;
            long dist = abs(nx-startX) + abs(ny-startY);

            res = min(res, go(1, nx, ny, i) + dist);
        }
        System.out.println(res);
    }

    public static long go(int idx, int curX, int curY, int dir) {

        if(idx == n) return 0;
        if(dp[idx][dir] != INF) return dp[idx][dir];

        long val = INF;

        for (int i=0; i<5;i++){

            int nx = list.get(idx).x + dx[i];
            int ny = list.get(idx).y + dy[i];

            if (ny <= 0 || nx <= 0 || ny > 100000 || nx > 100000) continue;
            long dist = abs(nx-curX) + abs(ny-curY);

            val = min(val, go(idx+1, nx, ny, i) + dist);
        }

        return dp[idx][dir] = val;
    }

}
