import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   static int n, r, q;
   static List<Integer>[] adj = new List[100004];
   static boolean[] visited = new boolean[100004];
   static int[] sub = new int [100004];

   static int makeTree(int node){

       visited[node] = true;
       for(int i=0; i< adj[node].size(); i++){

           int next = adj[node].get(i);

           if(visited[next]) continue;
           sub[node] += makeTree(next);
       }
       visited[node] = false;

       return sub[node] == 0 ? 1 : sub[node]+1;
   }


    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for(int i=0;i<100004;i++) adj[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        makeTree(r);

        for(int i=0;i<q;i++) System.out.println(sub[Integer.parseInt(br.readLine())]+1);
    }
}
