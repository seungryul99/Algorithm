import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.System.exit;


public class Main {

    static int n,m;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,1,-1};
    static int[][] map = new int[54][54];
    static boolean[][] visited = new boolean [54][54];
    static int[][] dp = new int[54][54];

    static int dfs(int y, int x){

        // 기저 사례, 구멍에 빠진 경우
        if (map[y][x]==0) return 0;

        
        // 메모이 제이션
        if (dp[y][x] != 0) return dp[y][x];


        // 로직
        int card = map[y][x];
        int max = 0;

        for(int i=0;i<4;i++){

            int ny = y + dy[i] * card;
            int nx = x + dx[i] * card;

            if(ny <0 || ny >= n || nx < 0 || nx >= m) continue;
            if(visited[ny][nx]) {
                System.out.println(-1);
                exit(0);
            }
            visited[ny][nx] = true;
            max = max(dfs(ny,nx),max);
            visited[ny][nx] = false;
        }

        return dp[y][x] = max+1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n;i++){
            String s = br.readLine();

            for(int j=0;j<m;j++){
                if(s.charAt(j)!='H') map[i][j] = s.charAt(j)-'0';
            }
        }

        visited[0][0] = true;
        System.out.println(dfs(0,0));
    }
}
