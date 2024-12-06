import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge{
        int cost, now, next;
        public Edge(int cost, int now, int next){
            this.cost = cost;
            this.now = now;
            this.next = next;
        }

    }

    static int v, e;
    static int[] parent  = new int[10004];
    static List<Edge> edgeList = new ArrayList<>();

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

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=1;i<=v;i++) parent[i] = i;
        for(int i=0;i<e;i++){

            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            edgeList.add(new Edge(cost, now, next));
        }

        // [로직]
        Collections.sort(edgeList, (e1, e2)-> Integer.compare(e1.cost, e2.cost) );

        int res = 0;
        for(int i=0; i<e; i++){

            Edge edge = edgeList.get(i);

            if(find(edge.now) == find(edge.next)) continue;
            res += edge.cost;

            union(edge.now,edge.next);
        }

        System.out.println(res);
    }
}