import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt1, cnt2, cnt3;
    static int[][] adj;

    static void go(int y1, int x1, int y2, int x2){

        if(check(y1, x1, y2, x2)) {

            if(adj[y1][x1] == -1) cnt1++;
            else if(adj[y1][x1] == 0) cnt2++;
            else if (adj[y1][x1] == 1) cnt3++;
            return;
        }

        int regY = (y2-y1 +1) / 3;
        int regX = (x2-x1 +1) / 3;

        for (int i=0; i<=2; i++){

            int divY = regY*i;

            for (int j=0; j<=2; j++){

                int divX = regX * j;

                go(y1+divY,x1+divX, y1 + divY + regY-1, x1 + divX +regX-1);
            }
        }
    }

    static boolean check(int y1, int x1, int y2, int x2){

        int tmp = adj[y1][x1];

        for(int i=y1; i<=y2; i++){

            for(int j=x1; j<=x2; j++) if(adj[i][j] != tmp) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        adj = new int[n+1][n+1];

        for (int i=1; i<=n; i++){

            StringTokenizer stk = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++) adj[i][j] = Integer.parseInt(stk.nextToken());
        }

        go(1,1,n,n);

        System.out.println(cnt1);
        System.out.println(cnt2);
        System.out.println(cnt3);
    }

}