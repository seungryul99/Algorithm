import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static final int MOD = 100000;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        w = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());

        dp = new int[w+1][h+1][2][2];

        for(int i=0; i<=w; i++) {
            for (int j = 0; j <= h; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        long res = 0;

        res += go(1,2, false, false)% MOD;
        res += go(2,1, true, false)% MOD;

        System.out.println(res% MOD);
    }

    public static int go(int y, int x, boolean up, boolean flag) {

        if (y == w && x == h) return 1;
        if (y > w || x > h) return 0;
        if (dp[y][x][up?1:0][flag?1:0] != -1) return dp[y][x][up?1:0][flag?1:0];

        int res = 0;

        if (up) {

            res += go(y+1, x, true, false) % MOD;
            if(!flag) res += go(y, x+1, false, true);
        }
        else{

            res += go(y, x+1, false, false) % MOD;
            if(!flag) res += go(y+1, x, true, true);
        }

        return dp[y][x][up?1:0][flag?1:0] = res % MOD;
    }
}
