import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    static class Move{
        int time, cost;

        public Move(int time, int cost){
            this.time = time;
            this.cost = cost;
        }
    }

    static int n, k;
    static int INF  = -100000004;
    static List<Move> walk = new ArrayList<>();
    static List<Move> bicycle = new ArrayList<>();

    static int[][] dp = new int[101][1000001];

    static int go(int sec, int time){

        // 기저
        if(time > k) return INF;
        if(sec == n) return 0;

        // 메모이제이션
        if (dp[sec][time] != -1) return dp[sec][time];


        // 로직
        return dp[sec][time] = max(go(sec + 1, time + walk.get(sec).time) + walk.get(sec).cost,
                    go(sec + 1, time + bicycle.get(sec).time) + bicycle.get(sec).cost);
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++){

            st = new StringTokenizer(br.readLine());
            walk.add(new Move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            bicycle.add(new Move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        // [로직]
        for(int i=0;i<= 100; i++) Arrays.fill(dp[i] , -1);

        int res = max(go(1,walk.get(0).time) + walk.get(0).cost,
                        go(1,bicycle.get(0).time) + bicycle.get(0).cost);

        // [출력]
        System.out.println(res);

    }
}