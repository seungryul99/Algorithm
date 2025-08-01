// 개선된 풀이
class Solution {
    public int[] solution(int[][] edges) {
        
        // new int[len+1]을 하게되면, [[200, 435]] 같은 입력케이스에 걸림, 문제 조건상 노드의 번호는 1~1,000,000 까지 랜덤
        int len = edges.length;
        int[] in = new int[1_000_001];
        int[] out = new int[1_000_001];
        
        for (int i=0; i<len; i++){
            
            int from = edges[i][0];
            int to = edges[i][1];
            
            in[to]++;
            out[from]++;
        }
        
        
        int start=0, m=0, d=0, e=0;
        
        for (int i=1; i<=1_000_000; i++){
            
            if(in[i] == 0 && out[i] >= 2) start = i;
            else if(in[i] >= 2 && out[i] ==2) e++;
            else if(in[i] != 0 && out[i] == 0) m++;
        }
        
        d = out[start] - e - m;
        
        return new int[]{start, d, m , e}; 
    }
}


// 개선 전 풀이
/**
class Solution {
    public int[] solution(int[][] edges) {
        
        // new int[len+1]을 하게되면, [[200, 435]] 같은 입력케이스에 걸림, 문제 조건상 노드의 번호는 1~1,000,000 까지 랜덤
        int len = edges.length;
        int[] in = new int[1_000_001];
        int[] out = new int[1_000_001];
        
        for (int i=0; i<len; i++){
            
            int from = edges[i][0];
            int to = edges[i][1];
            
            in[to]++;
            out[from]++;
        }
        
        
        int start=0, m=0, d=0, e=0;
        
        for (int i=1; i<=1_000_000; i++){
            
            if(in[i] == 0 && out[i] >= 2) start = i;
            else if(in[i] >= 2 && out[i] ==2) e++;
            else if(in[i] != 0 && out[i] == 0) m++;
            else if(in[i] == 2 && out[i] == 1) d++;
        }
        
        return new int[]{start, d, m , e}; 
    }
}
**/
