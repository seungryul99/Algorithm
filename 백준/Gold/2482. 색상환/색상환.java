import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long MOD = 1000000003L;
    static int n, k;
    static long[][][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        dp = new long[n+1][k+1][2][2];
        initDP();

        if(k >n/2) {
            System.out.println(0);
            return;
        }
        System.out.println(go(1, 0,0,0)%MOD);
    }

    public static long go(int cur, int cnt, int prev, int first){

        // 아직 k개를 못채웠는데 마지막 노드의 선택 여부만을 남겨둔 경우
        if (cur == n){

            // 마지막을 선택해도 달라질게 없음
            if(cnt < k-1) return 0;

            // 마지막에 선택하지 않는다 밖에 남지 않은 경우
            if(cnt == k-1 && (prev==1 || first==1)) return 0;

            return 1;
        }

        // k개를 이미 만족함
        if (cnt == k) return 1;

        if (dp[cur][cnt][prev][first] != -1) return dp[cur][cnt][prev][first];

        long val = 0;

        // 첫 노드 선택
        if (cur == 1) {
            val = (val + go(cur+1, cnt+1, 1, 1)) % MOD;
            val = (val + go(cur+1, cnt, 0, 0)) % MOD;
        } else {
            val = (val + go(cur+1, cnt, 0, first)) % MOD;
            if (prev == 0) val = (val + go(cur+1, cnt+1, 1, first)) % MOD;
        }

        return dp[cur][cnt][prev][first] = val % MOD;
    }

    public static void initDP(){
        for (int i=0; i<=n; i++){
            for (int j=0; j<=k; j++){
                for (int l=0; l<=1; l++){
                    for (int m=0; m<=1; m++){
                        dp[i][j][l][m] = -1;
                    }
                }
            }
        }
    }
}
