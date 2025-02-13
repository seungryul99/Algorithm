import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {

    static class Tuple{

        int z,y,x;

        public Tuple(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString(){
            return "[z:" + z + ", y:" + y + ", x:" + x + "]";
        }
    }

    // 동 서 남 북 상 하
    static int[] dz = {0,0,0,0,-1,1};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dx = {1,-1,0,0,0,0};

    static int l=-1, r=-1, c=-1;
    static char[][][] adj;
    static int[][][] visited;

    static Tuple start, end;

    static Queue<Tuple> q;

    static void setAdj(BufferedReader br) throws IOException {

        for(int i=0; i<l; i++){

            for(int j=0; j<r; j++){

                String row = br.readLine();
                for(int k=0; k<c; k++) {
                    adj[i][j][k] = row.charAt(k);

                    if(adj[i][j][k] == 'S') start = new Tuple(i,j,k);
                    else if(adj[i][j][k] == 'E') end = new Tuple(i,j,k);
                }
            }
            br.readLine();
        }
    }
    static void printAdj(){

        System.out.println("adj 출력 시작");
        
        for(int i=0; i<l; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) System.out.print(adj[i][j][k]);
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("start = " + start);
        System.out.println("end = " + end);

        System.out.println("adj 출력 종료");
    }

    static void printVisited(){

        System.out.println("visited 출력 시작");
        for(int i=0; i<l; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) System.out.print(visited[i][j][k] + " ");
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("visited 출력 종료");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            StringTokenizer stk = new StringTokenizer(br.readLine());

            l = Integer.parseInt(stk.nextToken());
            r = Integer.parseInt(stk.nextToken());
            c = Integer.parseInt(stk.nextToken());

            if (l==0 && r==0 && c==0) exit(0);

            adj = new char[l][r][c];
            visited = new int[l][r][c];
            q = new ArrayDeque<>();

            setAdj(br);
//            printAdj();

            visited[start.z][start.y][start.x] = 1;
            q.add(start);

            while (!q.isEmpty()){

                Tuple tp = q.poll();

                int z = tp.z;
                int y = tp.y;
                int x = tp.x;

                for (int w=0; w<6; w++){

                    int nz = z + dz[w];
                    int ny = y + dy[w];
                    int nx = x + dx[w];

                    if(nz <0 || nz >= l || ny <0 || ny >= r || nx <0 || nx >=c) continue;
                    if(adj[nz][ny][nx] == '#') continue;
                    if(visited[nz][ny][nx] != 0) continue;

                    visited[nz][ny][nx] = visited[z][y][x] + 1;
                    q.add(new Tuple(nz,ny,nx));
                }
            }
//            printVisited();

            if (visited[end.z][end.y][end.x] == 0) System.out.println("Trapped!");
            else System.out.println("Escaped in " + (visited[end.z][end.y][end.x]-1) + " minute(s).");
        }

    }
}