import java.util.*;

class Solution {
    
    static class Pair{
        int y, x;
        
        public Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    static int[] dy = {0,0,1,-1};
    static int[] dx = {-1,1,0,0};
    
    public int[] solution(String[][] places) {
        
        int[] res = new int[]{1,1,1,1,1};
        int idx = 0;
        
        for(String[] place : places){
            
            int[][] adj = new int[5][5];
            
            for (int i=0; i<5; i++){
                
                for (int j=0; j<5; j++){
                    
                    char c = place[i].charAt(j);
                    
                    if(c == 'P') adj[i][j] = 1;
                    else if (c == 'X') adj[i][j] = 2;
                }
            }
            
            for (int i=0; i<5; i++){
                
                for (int j=0; j<5; j++){
                    
                    if(adj[i][j] == 1 && res[idx]==1){
                        
                        int[][] visited = new int[5][5];
                        
                        for (int k=0; k<5; k++){
                            for (int m=0; m<5; m++) visited[k][m] = -1;
                        }
                        
                        Queue<Pair> q = new ArrayDeque<>();
                        
                        visited[i][j] = 0;
                        q.add(new Pair(i,j));
                        
                        while(!q.isEmpty()){
                            
                            Pair pi = q.poll();
                            
                            int y = pi.y;
                            int x = pi.x;
                            
                            for (int w=0; w<4; w++){
                                
                                int ny = y + dy[w];
                                int nx = x + dx[w];
                                
                                if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
                                if(adj[ny][nx] == 2) continue;
                                if(visited[ny][nx] != -1) continue;
                                
                                visited[ny][nx] = visited[y][x] + 1;
                                
                                if(visited[ny][nx] < 2) q.add(new Pair(ny, nx));
                            }
                        }
                        
                        boolean flag = true;
                        for (int k=0; k<5; k++){
                            
                            for (int m=0; m<5; m++){
                                
                                if(visited[k][m] >=1 && visited[k][m] <=2 && adj[k][m] == 1)
                                    flag = false;
                            }
                        }
                        
                        if(!flag) res[idx] = 0;
                    }
                }
            }
            idx++;
        }
        
        return res;
    }
}