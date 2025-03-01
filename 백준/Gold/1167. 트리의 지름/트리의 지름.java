import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, maxNode , max;
    static boolean[] visited;
    static List<Node>[] adj;

    static void dfs(int cur, int cost, int sum){

        int cnt = 0;
        visited[cur]= true;

        for (Node next : adj[cur]){

            if(visited[next.to]) continue;
            dfs(next.to, next.cost, sum + next.cost);
            cnt ++ ;
        }

        if (cnt == 0 && max < sum){
            maxNode = cur;
            max = sum;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        adj = new List[n+1];

        for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();

        visited = new boolean[n+1];

        for (int i=0; i< n; i++){

            StringTokenizer stk = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(stk.nextToken());

            while (true){

                int to = Integer.parseInt(stk.nextToken());

                if(to == -1) break;
                int cost = Integer.parseInt(stk.nextToken());

                adj[from].add(new Node(to, cost));
                adj[to].add(new Node(from, cost));
            }
        }


        dfs(1,0,0);
        Arrays.fill(visited,false);
        dfs(maxNode,0,0);

        System.out.println(max);
    }
}