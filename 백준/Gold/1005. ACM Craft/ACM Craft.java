import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;


public class Main {

    static int t, n, k, w, res;
    static int[] cost = new int[1004];
    static List<Integer>[] adj = new List[1004];
    static int[] indegree;
    static boolean[] visited;
    static int[] dp;


    static int dfs(int node){

        // 기저
        if(node == w) return cost[node];
        if(adj[node].isEmpty()) return -1000000004;

        // 메모이제이션
        if(dp[node] != -1000000004) return dp[node];
            
        // 로직
        visited[node] = true;

        int val = -1000000004;
        for(int i=0;i<adj[node].size();i++) {

            int next = adj[node].get(i);

            if (visited[next]) continue;

            val = max(val, dfs(next));
        }

        visited[node] = false;

        return dp[node] = val + cost[node];
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        while (t >0) {

            // [입력]
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) cost[i] = Integer.parseInt(st.nextToken());

            for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();

            indegree = new int[n+1];

            for (int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());

                int prev = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());
                adj[prev].add(next);
                indegree[next]++;
            }

            w = Integer.parseInt(br.readLine());

            dp = new int[n+1];
            visited = new boolean[n+1];
            res = 0;


            // 초기화
            Arrays.fill(dp, -1000000004);

            // [로직]
            for(int i=1;i<=n;i++){

                if(indegree[i] != 0) continue;

                res = max(dfs(i), res);
            }

            // [출력]
            System.out.println(res);
            t--;
        }

    }
}