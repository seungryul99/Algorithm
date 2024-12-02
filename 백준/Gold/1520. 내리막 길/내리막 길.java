import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {

    static int[] dy = {1,-1, 0,0};
    static int[] dx = {0,0,1,-1};
    static int n, m;
    static int[][] adj = new int[504][504];
    static long[][][] dp = new long[504][504][4];


    static long go(int y, int x, int dir){

        // 기저 사례
        if(y==n-1 && x==m-1) return 1;

        // 메모이 제이션
        if(dp[y][x][dir] != -1) return dp[y][x][dir];

        long val = 0;
        // 로직
        for(int i=0; i<4; i++){

            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0 || nx <0 || ny >=n || nx >= m) continue;
            if(adj[ny][nx] >= adj[y][x]) continue;

            val += go(ny,nx,i);
        }


        return dp[y][x][dir] = val;
    }


    public static void main(String[] args) throws IOException {

        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 초기화
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)Arrays.fill(dp[i][j] , -1);
        }

        if(n==1 && m!=1){
            if(adj[0][1] >= adj[0][0]) System.out.println(0);
            else System.out.println(go(0,1,2));
        } else if (m==1 && n!= 1) {
            if(adj[1][0] >= adj[0][0]) System.out.println(0);
            else System.out.println(go(1,0,0));
        } else if (n==1 && m==1) System.out.println(1);
        else {
            int res =0;
            if(adj[1][0] < adj[0][0]) res += go(1,0,0);
            if(adj[0][1] < adj[0][0]) res += go(0,1,2);
            System.out.println(res);
        }
    }
}
