import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {

    static int n;
    static int[][] adj = new int[17][17];
    static int[] visited = new int[17];
    static int INF = 100_000_004;

    static int go(int cur){

        // 기저
        if(Arrays.stream(visited).sum() == n-1) return adj[cur][1]==0 ? INF : adj[cur][1];

        // 로직
        int val = INF;
        visited[cur] = 1;

        for(int i=1; i<=n;i++){

            if(visited[i] == 1) continue;
            if(adj[cur][i] == 0) continue;
            val = min(val, go(i) + adj[cur][i]);
        }

        visited[cur] = 0;
        return val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=1; i<=n; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) adj[i][j] = Integer.parseInt(st.nextToken());
        }

        // [출력]
        int res = go(1);
        System.out.println(res > 20000004 ? 0 : res);
    }
}