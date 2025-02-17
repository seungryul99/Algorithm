import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[n];
        
        int network = 0;
        
        for(int i=0; i<n; i++){

            if(visited[i] ==0){
                
                visited[i] = ++network;
                q.add(i);
                
                while(!q.isEmpty()){
                    
                    int current = q.poll();
                    
                    for(int w=0; w<n; w++){
                        
                        int next = w;
                        
                        if (computers[current][next] != 1) continue;
                        if (visited[next] != 0) continue;
                        
                        visited[next] = network;
                        q.add(next);
                    }
                }
            }
        
        }
        
        

        return network;
    }
}