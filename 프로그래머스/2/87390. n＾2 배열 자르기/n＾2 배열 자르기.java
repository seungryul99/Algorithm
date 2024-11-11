class Solution {
    public int[] solution(int n, long left, long right) {
        
        // int[n][n] 선언하는 순간 10만 x 10만 배열이 생성되면서 메모리 폭파
        
        int[] res= new int[(int)(right-left+1)];
        
        int l = (int)(left/n);
        int l_idx = (int)(left%n);
        int r = (int)(right/n);
        int r_idx = (int)(right%n);
        
        int pl = l;
        int p = 0;
        
        
        if(l==r){
            
            for(int i=1; i<=n; i++){
                
                if(l_idx <= i-1 && i-1 <= r_idx) res[p++] = i+pl;
                if(pl>0) pl--;
            }
            
            return res;
        }
        
        
        // i == l
       
        for(int i=1; i<=n; i++){
            
            if(l_idx < i) res[p++] = i+pl;
            if(pl >0) pl--;
        }
        
        // 중간
        if(r-l>1){
            for(int i=l+1; i<r; i++){
                pl = i;
                for(int j=1; j<=n; j++){
                    res[p++] = j+pl;
                    if(pl >0) pl--;
                }
            }    
        }
    
        
        // i == r;
        
        pl = r;
        for(int i=1; i<=n; i++){
            
            if(i > r_idx+1) break;
            res[p++] = i+pl;
            if(pl>0) pl--;
        }
        
        
        return res;
    }
}