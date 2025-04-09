import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n , res;
    static int[][] adj;
    
    // O(N)
    static boolean check(int y, int x){

        // row
        for (int i=1;i<=n; i++){

            if (x == i) continue;
            if (adj[y][i] == 1) return false;
        }

        // col
        for (int i=1; i<=n; i++){

            if(y==i) continue;
            if(adj[i][x] == 1) return false;
        }

        // 대각 오른쪽 위
        for (int i= 1; i<=n; i++){

            if(y-i < 1 || x+i > n) break;
            if(adj[y-i][x+i] == 1) return false;
        }

        // 대각 오른쪽 아래
        for (int i= 1; i<=n; i++){

            if(y+i > n || x+i > n) break;
            if(adj[y+i][x+i] == 1) return false;
        }

        // 대각 왼쪽 위
        for (int i= 1; i<=n; i++){

            if(y-i < 1 || x-i < 1) break;
            if(adj[y-i][x-i] == 1) return false;
        }

        // 대각 왼쪽 아래
        for (int i= 1; i<=n; i++){

            if(y+i > n || x-i < 1) break;
            if(adj[y+i][x-i] == 1) return false;
        }

       return true;
    }

    static void go(int y, int x) {

        // 현재 위치에 퀸을 둔다.
        adj[y][x] = 1;

        // 잘 뒀는지 체크, 잘 못 뒀으면 해당 경우 모두 가지치기
        if(!check(y,x)){

            adj[y][x] = 0;
            return;
        }

        if (y < n){
            for (int i=1; i<=n; i++) {
                go(y+1,i);
            }
        }
        else if (y==n) res++;

        adj[y][x] = 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new int[n+1][n+1];

        for (int i=1; i<=n; i++) go(1,i);

        System.out.println(res);
    }
}