import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,1,-1};

    static class Pair{

        int y, x;

        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        int[][] adj = new int[r][c];
        int[][] visited = new int[r][c];

        Queue<Pair> q = new ArrayDeque<>();

        Pair hedgehog = null, beaver = null;

        for (int i=0; i<r; i++){

            String line = br.readLine();

            for (int j=0; j<c; j++){

                char cur = line.charAt(j);

                if (cur == 'S') {
                    adj[i][j] = 0;
                    hedgehog = new Pair(i,j);
                }
                else if (cur == 'D') {
                    adj[i][j] = 0;
                    beaver = new Pair(i,j);
                }
                else if (cur == '*') adj[i][j] = 1;
                else if (cur == 'X') adj[i][j] = -1;
            }
        }

        for (int i=0 ;i <r ;i++){
            for (int j=0; j<c; j++){

                if (adj[i][j] > 0) {

                    q.add(new Pair(i,j));

                    while (!q.isEmpty()){

                        Pair pi = q.poll();
                        int y = pi.y;
                        int x = pi.x;

                        for (int w = 0; w<4; w++){

                            int ny = y + dy[w];
                            int nx = x + dx[w];

                            if (ny <0 || ny >= r || nx <0 || nx >=c) continue;
                            if (ny == beaver.y && nx == beaver.x) continue;
                            if (adj[ny][nx] == -1 || adj[ny][nx] > 0) continue;

                            adj[ny][nx] = adj[y][x] + 1;
                            q.add(new Pair(ny,nx));
                        }
                    }
                }
            }
        }




        for (int i=0; i< r; i++) Arrays.fill(visited[i],-1);


        visited[hedgehog.y][hedgehog.x] = 0;
        q.add(hedgehog);

        while (!q.isEmpty()){

            Pair pi = q.poll();

            int y = pi.y;
            int x = pi.x;

            for (int w = 0; w<4; w++){

                int ny = y + dy[w];
                int nx = x + dx[w];

                if (ny == beaver.y && nx == beaver.x){
                    System.out.println(visited[y][x] +1 );
                    System.exit(0);
                }
                if (ny <0 || nx < 0 || ny >= r || nx >=c) continue;
                if (adj[ny][nx] == -1) continue;
                if (visited[ny][nx] >= 0) continue;
                if(adj[ny][nx] != 0 && adj[ny][nx] - visited[y][x] <= 2) continue;

                visited[ny][nx] = visited[y][x] + 1;
                q.add(new Pair(ny,nx));
            }
        }

        System.out.println("KAKTUS");
    }
}