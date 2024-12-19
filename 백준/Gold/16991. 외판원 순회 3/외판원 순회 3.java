import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.lang.Math.pow;

public class Main {

    static class City{
        int x, y;
        public City(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static double[][] adj = new double[17][17];
    static double[][] dp = new double[17][(1<<16)+1];
    static int INF = 100_000_004;
    static List<City> cityList = new ArrayList<>();

    static double go(int cur, int visited){

        // 기저 1111 1111 1111 1111
        if(visited == (1<<n)-1) return adj[cur][1] == 0 ? INF:adj[cur][1];

        // 메모이제이션
        if(dp[cur][visited] != -1) return dp[cur][visited];

        // 로직
        double val = INF;

        for(int i=1; i<=n;i++){

            if((visited & (1<<i-1)) != 0) continue;
            if(adj[cur][i] == 0) continue;

            val = min(val, go(i,visited + (1<<i-1)) + adj[cur][i]);
        }

        return dp[cur][visited] = val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=1; i<=n; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            cityList.add(new City(start, end));
        }

        // [로직]
        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){

                City a= cityList.get(i);
                City b= cityList.get(j);

                double dis = Math.sqrt(pow(a.x-b.x,2) + pow(a.y-b.y,2));

                adj[i+1][j+1] = dis;
                adj[j+1][i+1] = dis;
            }
        }

        for(int i=0;i<=n;i++) Arrays.fill(dp[i] ,-1);

        // [출력]
        double res = go(1,1);
        System.out.println(res > 20000004 ? 0 : res);
    }
}