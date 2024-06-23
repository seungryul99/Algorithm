class Solution {
    public long solution(long n) {
        
        // 최대 범위 50조, 전수 탐색 -> 8000000 * 8000000 = 64,000,000,000,000
        // 800만번 연산, 1초 : 1억번, 구체적인 시간 제한이 없지만 문제 없을듯함
        
        long i=1;
        while(true){
            if(i*i > 50000000000000L) return -1;
            if(i*i == n) return ((i+1)*(i+1));
            i++;
        }
    }
}