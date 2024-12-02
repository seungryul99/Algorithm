import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {

    static int EX = -100000004;

    // ← ↓ →
    static int[] dy = {0, 1 , 0};
    static int[] dx = {-1, 0, 1};
    static int n, m;
    static int[][] adj = new int[1004][1004];
    
    // y,x에서 어떤 방향으로 이동할 때 cost의 합
    static int[][][] dp = new int[1004][1004][3];

    static boolean[][] visited = new boolean[1004][1004];


    static int go(int y, int x, int dir){
        
        // 기저
        if(y == n-1 && x == m-1) return adj[y][x];


        // 메모이제이션
        if(dp[y][x][dir] != EX) return dp[y][x][dir];
        
        
        // 로직
        visited[y][x] = true;

        int value = EX;

        for(int i=0; i<3; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0 || ny >= n || nx<0 || nx>= m) continue;
            if(visited[ny][nx]) continue;

            value = max(value, go(ny,nx,i));
        }

        visited[y][x] =false;

        return dp[y][x][dir] = value + adj[y][x];
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

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) Arrays.fill(dp[i][j], EX);
        }

        // DFS 시작
        // ←(0) ↓(1) →(2)
        System.out.println(max(go(0,0,1), go(0,0,2)));
    }
}
