import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Pair{
        int y,x;
        public Pair(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

    static int[][] adj = new int[9][9];
    static ArrayList<Pair> list = new ArrayList<>();

    static boolean check(int y, int x, int val){

        // 가로 세로 검사
        for (int i=0; i<9; i++) {

            if(i != x && adj[y][i] == val) return false;
            if(i != y && adj[i][x] == val) return false;
        }

        // 같은 영역 검사
        int yStart = y/3 *3;
        int xStart = x/3 *3;

        for(int i = yStart; i < yStart+3; i++){

            for(int j= xStart; j < xStart+3; j++){

                if (i != y && j != x && adj[i][j] == val) return false;
            }
        }

        return true;
    }

    static void go(Pair pi) {

        int y = pi.y;
        int x = pi.x;

        for (int val = 1; val <= 9; val++){

            adj[y][x] = val;
            list.remove(0);

            if(check(y,x,val)) {

                if(list.isEmpty()) {
                    print();
                    System.exit(0);
                }

                go(list.get(0));
            }
            adj[y][x] = 0;
            list.add(0, new Pair(y,x));
        }
    }

    static void print(){
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++) System.out.print(adj[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        for (int i=0; i<9; i++){

            stk = new StringTokenizer(br.readLine());

            for (int j=0; j<9; j++) {
                adj[i][j] = Integer.parseInt(stk.nextToken());
                if(adj[i][j] == 0) list.add(new Pair(i,j));
            }
        }

        go(list.get(0));
    }

}