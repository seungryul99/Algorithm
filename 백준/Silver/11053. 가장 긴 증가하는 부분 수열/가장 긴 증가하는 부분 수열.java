import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {

    static int n;
    static int[] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1][n+2];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(stk.nextToken());

        for (int j = n; j>=1; j--){
            for (int i = j-1; i>=0; i--){

                if (arr[i] >= arr[j]) dp[i][j] = dp[i][j+1];
                else dp[i][j] = max(dp[i][j+1], dp[j][j+1]+1);
            }
        }

        System.out.println(dp[0][1]);
    }
}