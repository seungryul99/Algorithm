import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[][] adj = new long[33][33];
    static long[][][] dp = new long[3][33][33];

    static long go(int dir, int endY, int endX) {

        // 예외
        if(endY <0 || endY>=n || endX<0 || endX>=n) return 0;
        if(dir == 0 && adj[endY][endX-1] + adj[endY][endX] > 0) return 0;
        if(dir ==1 && adj[endY-1][endX] + adj[endY][endX] > 0) return 0;
        if(dir == 2 && adj[endY-1][endX-1] + adj[endY-1][endX] + adj[endY][endX-1] + adj[endY][endX]>0) return 0;

        // 기저
        if(endY == n-1 && endX == n-1) return 1;

        // 메모이제이션
        if(dp[dir][endY][endX] != -1) return dp[dir][endY][endX];

        // 로직
        // →(0), ↓(1), ↘(2)
        long val = 0;

        if (dir == 0){
            val += go(0, endY, endX+1);
            val += go(2,endY+1,endX+1);
        }
        else if (dir == 1){
            val += go(1,endY+1,endX);
            val += go(2,endY+1,endX+1);
        }
        else if (dir==2){
            val += go(0,endY,endX+1);
            val += go(1,endY+1,endX);
            val += go(2,endY+1,endX+1);
        }

        return dp[dir][endY][endX] = val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) adj[i][j] = Integer.parseInt(st.nextToken());
        }


        // [로직]

        // dp 초기화
        for(int i=0;i<3;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++) dp[i][j][k]=-1;
            }
        }

        System.out.println(go(0,0,1));
    }
}