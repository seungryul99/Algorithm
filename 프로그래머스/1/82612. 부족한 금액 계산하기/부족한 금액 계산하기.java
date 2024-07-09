class Solution {
    public long solution(int price, int money, int count) {
        
        long sum =0;
        
        for(int i=1;i<=count;i++){
            
            sum += price * i;
        }
        
        if(money - sum <0) return -1*(money -sum);
        else return 0;
    }
}