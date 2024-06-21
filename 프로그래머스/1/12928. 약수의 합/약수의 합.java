class Solution {
    public int solution(int n) {
        
        
        // n이 최악의 경우 3000, 3000의 약수는 3000보다 작음
        // 1~N 까지 전수순회 하면서 N의 약수인지 판별
        // N이 0 인경우? -> 0 반환
        
        if(n==0) return 0;
        
        int res = 0;
        
        for(int i=1;i<=n;i++){
            
            if(n%i==0) res+=i;
        }
        
        return res;
    }
}