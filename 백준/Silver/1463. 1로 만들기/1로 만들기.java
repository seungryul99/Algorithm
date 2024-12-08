import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class Main {

    static int x;
    static List<Integer> res = new ArrayList<>();
    static int INF = 100000004;
    static int[] dp = new int[1000004];

    static int go(int num){

        // 기저
        if(num == 1) return 1;

        // 메모이제이션
        if(dp[num] != -1) return dp[num];

        // 로직
        int val = INF;

        if(num % 3 == 0) val = min(val,go(num/3));
        if(num % 2 == 0) val = min(val,go(num/2));
        val = min(val,go(num-1));

        return dp[num] = val + 1;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        // [로직]
        Arrays.fill(dp,-1);
        System.out.println(go(x)-1);
    }
}