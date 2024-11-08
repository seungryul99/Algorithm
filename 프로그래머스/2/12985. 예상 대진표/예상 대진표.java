class Solution{
    public int solution(int n, int a, int b){
        
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        int cnt = 1;
        
        // max가 짝수 && max-1 == min 이면 정답
        while (n>2) {
            
            if(max %2 ==0 && max-1 == min) return cnt;
            
            cnt++;
            max = (max+1)/2;
            min = (min+1)/2;
            n /= 2;
        }
        
        return cnt;
    }
}