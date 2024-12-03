import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {

    static int INF = 1000000004;
    static int n;
    static int[] r = new int[1004];
    static int[] g = new int[1004];
    static int[] b = new int[1004];
    static int[][][] dp = new int[3][1004][3];

    static int firstColor;


    // 0(r), 1(g), 2(b)
    static int go(int idx, int color){

        // 기저
        if(idx == n-1){

            if(color == firstColor) return INF;

            if(color == 0) return r[idx];
            if(color == 1) return g[idx];
            if(color == 2) return b[idx];
        }

        // 메모이제이션
        if(dp[firstColor][idx][color] != 0) return dp[firstColor][idx][color];


        // 로직
        if(color == 0) return dp[firstColor][idx][color] = min(go(idx+1,1), go(idx+1, 2)) + r[idx];
        if(color == 1) return dp[firstColor][idx][color] = min(go(idx+1,0), go(idx+1, 2)) + g[idx];
        if(color == 2) return dp[firstColor][idx][color] = min(go(idx+1,0), go(idx+1, 1)) + b[idx];

        return 0;
    }


    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0; i<n; i++) {

            st = new StringTokenizer(br.readLine());

            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }


        // 0(r), 1(g), 2(b)
        int[] cnt = {0,0,0};

        for(int i=0; i<3 ;i++){

            firstColor = i;
            cnt[i] = go(0,i);
        }

        System.out.println(min(min(cnt[0], cnt[1]), cnt[2]));
    }
}
