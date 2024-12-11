import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.min;


public class Main {

    static int n, k;
    static List<Integer> coinList = new ArrayList<>();
    static int INF = 987654321;
    static int[] dp = new int[100004];


    static int go(int sum){

        // 기저
        if(sum == k) return 0;

        // 메모이제이션
        if(dp[sum] != 0) return dp[sum];

        // 로직
        int val = INF;

        for(int i=0;i<coinList.size();i++){

            int next = coinList.get(i);

            if(sum + next > k) continue;

            val = min(val, go(sum+next));
        }

        return dp[sum] =val + 1;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){

            int coin = Integer.parseInt(br.readLine());
            if(!coinList.contains(coin)) coinList.add(coin);
        }

        // [로직]
        int res = go(0);

        // [출력]
        System.out.println(res > 10000? -1: res);
    }
}