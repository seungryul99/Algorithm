import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int n, goal;
    static int[] arr = new int[104];
    static long[][] dp = new long[104][24];

    static long go(int opCnt, int cur){
        
        // 기저
        if (cur > 20 || cur <0) return 0;
        if (opCnt == n-2) return cur == goal ? 1 : 0;

        // 메모이제이션
        if(dp[opCnt][cur] != -1) return dp[opCnt][cur];

        // 로직
        return dp[opCnt][cur] = go(opCnt + 1, cur + arr[opCnt+1]) +
                go(opCnt + 1, cur - arr[opCnt+1]);
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        // [로직]
        goal = arr[n-1];
        for(int i=0; i<103; i++) Arrays.fill(dp[i],-1);

        // [출력]
        System.out.println(go(0, arr[0]));
    }
}