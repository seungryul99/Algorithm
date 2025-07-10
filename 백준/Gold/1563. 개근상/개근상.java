import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long[][][] dp;
    static final long MOD = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n+1][2][3];
        initDp();

        System.out.println(
            (go(2, 0,0) +
            go(2, 1,0) +
            go(2, 0,1)
            ) %MOD
        );
    }

    public static long go(int toDay, int lCnt, int aCnt) {

        if(lCnt >= 2 || aCnt>=3) return 0;
        if (toDay == n+1) return 1;

        return dp[toDay][lCnt][aCnt] = dp[toDay][lCnt][aCnt] == -1 ?
                 (go(toDay+1, lCnt, 0) % MOD+
                  go(toDay+1, lCnt+1, 0) % MOD +
                  go(toDay+1, lCnt, aCnt+1) % MOD) %MOD
                : dp[toDay][lCnt][aCnt];
    }

    public static void initDp(){
        for (int i=0; i<n+1; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
    }

}
