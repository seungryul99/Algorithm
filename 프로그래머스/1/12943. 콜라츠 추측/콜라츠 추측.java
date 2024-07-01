class Solution {
    public int solution(int num) {

        int cnt=0;
        long res = num;
  
        
        while(true){
            
            
            if (res == 1) return cnt;
            if (cnt == 499) return -1;
            
            cnt++;
            
            if (res % 2 ==0) res/=2;
            else res = res*3+1;
        }
        
    }
}