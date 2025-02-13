import java.util.*;

class Solution {
    
    static class Pair{
        int y,x;
        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public int solution(int[][] maps) {
        
        int r = maps.length;
        int c = maps[0].length;
        
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,1,-1};
        
        int[][] visited = new int[r][c];
        
        Queue<Pair> q = new ArrayDeque<>();
        
        visited[0][0] = 1;
        q.add(new Pair(0,0));
        
        while(!q.isEmpty()){
            
            Pair pi = q.poll();
            
            int y = pi.y;
            int x = pi.x;
            
            for(int w=0; w<4; w++){
                
                int ny = y + dy[w];
                int nx = x + dx[w];
                
                if (ny < 0 || ny >= r || nx <0 || nx >=c) continue;
                if (maps[ny][nx] == 0) continue;
                if (visited[ny][nx] >= 1) continue;
                
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new Pair(ny,nx));
            }
        }
        
        return visited[r-1][c-1] == 0 ? -1 : visited[r-1][c-1];
    }
}