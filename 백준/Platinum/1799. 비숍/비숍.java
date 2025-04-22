import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {

    static class Pair{
        int y,x;
        public Pair(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

    static int[][] adj;

    static ArrayList<Pair> black = new ArrayList<>();
    static ArrayList<Pair> white = new ArrayList<>();

    static ArrayList<Pair> list;
    static int cnt, n;
    static boolean[] dia1, dia2;

    static void go(int cur, int idx) {
        
        if(idx == list.size()){
            
            cnt = max(cur, cnt);
            return;
        }
        
        Pair pi = list.get(idx);

        int y = pi.y;
        int x = pi.x;

        // 놓을 수 있는 경우는 놓고 돌아올 걸 대비 해서 원복
        if(!dia1[y+x] && !dia2[y-x+n-1]){

            adj[y][x] = 2;
            dia1[y+x] = true;
            dia2[y-x+n-1] = true;
            go(cur+1, idx+1);

            dia1[y+x] = false;
            dia2[y-x+n-1] = false;
            adj[y][x] = 1;
        }

        // 안 놓는 경우는 무조건 호출
        go(cur, idx+1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];

        StringTokenizer stk;

        for (int i=0; i<n; i++){

            stk = new StringTokenizer(br.readLine());

            for (int j=0; j<n; j++) {

                adj[i][j] = Integer.parseInt(stk.nextToken());
                if(adj[i][j] == 1 && (i+j) % 2 == 0) white.add(new Pair(i,j));
                if(adj[i][j] == 1 && (i+j) % 2 == 1) black.add(new Pair(i,j));
            }
        }

        int res = 0;

        list = new ArrayList<>(white);
        go(0,0);
        res += cnt;
        cnt=0;

        list = new ArrayList<>(black);
        go(0,0);
        res += cnt;

        System.out.println(res);
    }
}