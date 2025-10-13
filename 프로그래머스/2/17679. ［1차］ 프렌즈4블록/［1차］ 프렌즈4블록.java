import java.util.*;

class Solution {
    
    class Pair{
        int y, x;
        
        public Pair(int y, int x){
            this.y=y;
            this.x=x;
        }
        
        @Override
        public boolean equals(Object o){
            if(((Pair)o).y== y && ((Pair)o).x ==x) return true;
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(y,x);
        }
    }
    
    static void print(char[][] adj){
        for(int i=0;i<adj.length;i++){
            
            for (int j=0; j<adj[0].length;j++) System.out.print(adj[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public int solution(int m, int n, String[] board) {
        
        int res = 0;
        char[][] adj = new char[m][n];
        
        for (int i=0; i<m; i++) {
            
            for (int j=0; j<n; j++){
                
                adj[i][j] = board[i].charAt(j);
            }
        }
        
        Set<Pair> st = new HashSet<>();
        
        // 탐색 루프
        while(true) {
            for (int i=0; i<m-1; i++){
                for (int j=0; j<n-1; j++){

                    if(adj[i][j] == '0') continue;
                    if(adj[i][j] != adj[i+1][j]) continue;
                    if(adj[i][j] != adj[i][j+1]) continue;
                    if(adj[i][j] != adj[i+1][j+1]) continue;
                    
                    st.add(new Pair(i,j));
                    st.add(new Pair(i+1,j));
                    st.add(new Pair(i,j+1));
                    st.add(new Pair(i+1,j+1));
                }
            }
            
            if(st.size()==0) break;
            
            res += st.size();
            
            for (Pair pi : st){
                adj[pi.y][pi.x] = '0';
            }
            
            st.clear();
            
            char[][] tmp = new char[m][n];
            
            for (int i=0; i<n; i++){
                
                StringBuilder sb = new StringBuilder();
                int cnt = 0;
                
                for (int j=0; j<m; j++){
                    
                    if(adj[j][i] != '0') sb.append(adj[j][i]);
                    else cnt++;
                }
                
                String s = "0".repeat(cnt);
                s += sb.toString();
                
                for (int j=0; j<m; j++){
                    
                    tmp[j][i] = s.charAt(j);
                }
            }
            adj = tmp;
        }
    
        return res;
    }
}