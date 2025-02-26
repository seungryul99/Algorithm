import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        while (k>0){
            k--;

            StringTokenizer stk = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            List<Integer>[] list = new List[v+1];

            for(int i=0;i<=v;i++) list[i] = new ArrayList<>();

            while (e>0){
                e--;
                stk = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(stk.nextToken());
                int to = Integer.parseInt(stk.nextToken());

                list[from].add(to);
                list[to].add(from);
            }

            Queue<Integer> q = new ArrayDeque<>();
            int[] visited = new int[v+1];

            for (int i=1; i<=v; i++){

                if(visited[i] != 0) continue;

                visited[i] = 1;
                q.add(i);

                while (!q.isEmpty()){

                    int cur = q.poll();

                    for(int x : list[cur]){

                        if(visited[x] != 0) continue;
                        visited[x] = visited[cur] == 1 ? 2 : 1;
                        q.add(x);
                    }
                }
            }

            boolean res = true;

            for (int i=1; i<=v; i++){

                for (int x : list[i]){

                    if (visited[x] == visited[i]) {
                        res = false;
                        break;
                    }
                }
                if (!res) break;
            }

            System.out.println(res ? "YES" : "NO");
        }
    }
}