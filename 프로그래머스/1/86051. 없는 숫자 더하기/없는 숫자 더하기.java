class Solution {
    public int solution(int[] numbers) {
        
        // 1 ~ 9 까지 다 더한 거에서 numbers에 있는거 뺌, '45'
        
        int sum = 45;
        
        for(int i=0;i<numbers.length;i++) sum -= numbers[i];
        
        return sum;
    }
}