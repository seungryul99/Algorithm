import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] adj;
    static int cnt0, cnt1;

    static void go(int y1, int x1, int y2, int x2){

        if(y2-y1 == 0 && x2-x1 == 0) {
            if(adj[y1][x1] == 1) cnt1++;
            else cnt0++;
            return;
        }
        if(check(y1, x1, y2, x2)) {
            if(adj[y1][x1] == 1) cnt1++;
            else cnt0++;
            return;
        }

        int midY = (y1 + y2)/2;
        int midX = (x1 + x2)/2;

        go(y1, x1, midY, midX);
        go(y1, midX+1, midY, x2);
        go(midY+1, x1, y2, midX);
        go(midY+1, midX+1, y2,x2);
    }

    static boolean check(int y1, int x1, int y2, int x2) {

        int color = adj[y1][x1];

        for(int i=y1; i<=y2; i++){
            for(int j=x1; j<=x2; j++)
                if (adj[i][j] != color) {
                    return false;
                }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        adj = new int[size+1][size+1];

        for(int i=1; i<=size; i++){

            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=1; j<=size; j++) adj[i][j] = Integer.parseInt(stk.nextToken());
        }

        go(1,1, size, size);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }
}