import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] adj;

    static int go(int y1, int x1, int y2, int x2){

        int lenY = y2-y1 +1;
        int lenX = x2-x1 +1;

        if(lenY == 2 && lenX ==2){

            int[] a = new int[4];
            a[0] = adj[y1][x1];
            a[1] = adj[y1][x1+1];
            a[2] = adj[y1+1][x1];
            a[3] = adj[y1+1][x1+1];

            Arrays.sort(a);
            return a[2];
        }

        int[] a = new int[4];
        a[0] = go(y1,x1, y1 + lenY/2 -1, x1 + lenX/2 -1);
        a[1] = go(y1, x1+ lenX/2, y1+lenY/2-1, x2);
        a[2] = go(y1+lenY/2,x1,y2, x1+lenX/2-1);
        a[3] = go(y1+lenY/2, x1+lenX/2, y2, x2);
        Arrays.sort(a);

        return a[2];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        adj = new int[n+1][n+1];

        for(int i=1; i<=n; i++){

            StringTokenizer stk = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++) adj[i][j] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(go(1,1,n,n));
    }
}