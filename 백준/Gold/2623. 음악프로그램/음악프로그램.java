import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static List<Integer>[] adj = new List[1004];
    static Stack<Integer> stk = new Stack<>();
    static boolean[] visited = new boolean[1004];
    static boolean[] checked = new boolean[1004];

    static void dfs(int node) {

        visited[node] = true;
        checked[node] = true;


        for(int i=0;i<adj[node].size();i++){

            int next = adj[node].get(i);

            if(checked[next]) {
                System.out.println(0);
                System.exit(0);
            }
            if(visited[next]) continue;


            dfs(next);
        }

        stk.push(node);
        checked[node] = false;
    }


    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++) adj[i] = new ArrayList<>();

        for(int i=1; i<=m; i++) {

            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());

            int[] list = new int[cnt];
            for(int j=0;j<cnt;j++) list[j] = Integer.parseInt(st.nextToken());

            for(int j=0;j<cnt-1;j++){
                adj[list[j]].add(list[j+1]);
            }
        }


        // [로직]
        for(int i=1; i<=n; i++) if(!visited[i]) dfs(i);


        // [출력]
        StringBuilder sb = new StringBuilder();

        while (!stk.isEmpty()){

            sb.append(stk.peek());
            sb.append("\n");
            stk.pop();
        }

        System.out.println(sb);
    }
}