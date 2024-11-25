import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//2178 미로 탐색(BFS)
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        int[][] adj = new int[104][104];
        int[][] visited = new int [104][104];

        Queue<Pair> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i=0;i<n;i++){

            String s = br.readLine();

            for(int j=0;j<m;j++){
                adj[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0][0] = 1;
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair pi = q.poll();

            int y = pi.y;
            int x = pi.x;

            for(int w=0;w<4;w++){

                int ny = y + dy[w];
                int nx = x + dx[w];

                if (ny < 0 || ny >= n || nx <0 || nx >= m) continue;
                if (adj[ny][nx] == 0) continue;
                if (visited[ny][nx] >= 1) continue;

                visited[ny][nx] = visited[y][x] + 1;
                q.add(new Pair(ny,nx));
            }
        }

        System.out.println(visited[n-1][m-1]);

    }

    static class Pair{
        int y,x;

        Pair(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}