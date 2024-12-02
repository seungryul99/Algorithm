import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    static int n;
    static long[][] dp = new long[32][32];

    static long go(int whole, int half){

        // 기저 사례
        if(whole ==0 && half ==0) return 1;

        if(dp[whole][half] != 0) return dp[whole][half];

        // 로직
        if(whole > 0 && half >0) return dp[whole][half] = go(whole-1,half+1) + go(whole, half-1);
        if(whole > 0 && half == 0) return dp[whole][half] = go(whole-1, half + 1);
        if(whole==0 && half > 0) return dp[whole][half] = go(whole,half-1);

        return 0;
    }


    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            n = Integer.parseInt(br.readLine());
            if(n==0) break;

            System.out.println(go(n,0));
        }

    }
}
