class Solution {
    public int solution(int left, int right) {
        
        int sum = 0;
        
        for(int cur = left; cur <= right; cur++){
            
            int cnt=0;
            
            for(int j=1;j<=cur;j++) if(cur%j==0) cnt++;
            
                
            if(cnt %2 ==0) sum += cur;
            else sum -= cur;
        }
        
        return sum;
    }
}