import java.util.*;

class Solution {
    
    static List<Integer>[] adj;
    static int[] visited;
        
    public int solution(int n, int[][] edge) {
        
             
        adj = new List[n+1];
        visited = new int[n+1];
        
        for(int i=1;i<=n;i++) adj[i] = new ArrayList<>();
       
        for(int i=0; i<edge.length; i++){
            
            int start = edge[i][0];
            int end = edge[i][1];
            
            adj[start].add(end);
            adj[end].add(start);
        }
        
        
        Queue<Integer> q = new ArrayDeque<>();
        
        visited[1] = 1;
        q.add(1);
        
        while(!q.isEmpty()){
            
            int cur = q.poll();
            
            for(int next : adj[cur]){
                
                if(visited[next] >= 1) continue;
                
                visited[next] = visited[cur] + 1;
                q.add(next);
            }
        }
        
        Arrays.sort(visited);
        
        int max = visited[n];
        int cnt = 0;
        
        for(int i=visited.length-1; i>0; i--) {
            
            if(max == visited[i]) cnt++;
            else break;
        }
        
        return cnt;
    }
}