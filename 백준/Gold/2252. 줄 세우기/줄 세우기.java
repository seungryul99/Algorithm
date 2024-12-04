import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static List<Integer>[] adj = new List[32004];
    static boolean[] visited = new boolean[32004];
    static List<Integer> res = new ArrayList<>();


    // dfs를 이용한 위상 정렬
    static void dfs(int node){

        visited[node] = true;

        for(int i=0; i< adj[node].size(); i++) {

            int next = adj[node].get(i);

            if(visited[next]) continue;
            dfs(next);
        }
        res.add(node);
    }


    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1;i<=32000;i++) adj[i] = new ArrayList<>();

        for(int i=0;i<m;i++) {

            st = new StringTokenizer(br.readLine());

            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            adj[big].add(small);
        }

        // 로직
        for(int i=1; i<=n; i++) if(!visited[i]) dfs(i);

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int x : res) sb.append(x + " ");

        System.out.println(sb);
    }
}
