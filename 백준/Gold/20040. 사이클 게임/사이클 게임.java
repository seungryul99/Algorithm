import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] parent  = new int[500004];

    static int find(int node){

        if (node == parent[node]) return node;

        return parent[node] = find(parent[node]);
    }

    static void union(int node1, int node2){

        node1 = find(node1);
        node2 = find(node2);

        if (node1 != node2) parent[node1] = node2;
    }



    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1;i<=n;i++) parent[i] = i;

        // [로직]
        int res=0;
        for(int i=1;i<=m;i++){

            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            if(find(prev) == find(next)) {
                res = i;
                break;
            }
            else union(prev, next);
        }

        System.out.println(res);
    }
}