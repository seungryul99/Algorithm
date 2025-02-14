class Solution {

    static int goal, len;
    static int[] arr;

    // operation => [0 : - , 1 : +]
    static int go(int idx, int sum, int operation){
    
    int val = operation == 0 ? arr[idx] *-1 : arr[idx];
    
    // 그래프의 끝까지 옴
    if(idx == len-1){
        
        if((sum + val) == goal) return 1;
        
        return 0;
    }
        
    return go(idx+1, sum + val, 0) + go(idx +1, sum + val , 1);
}
    
    
    public int solution(int[] numbers, int target) {
       
        len = numbers.length;
        goal = target;
        arr = new int[len];
        System.arraycopy(numbers,0,arr,0,len);
        
        return go(0,0,0) + go(0,0,1);
    }
}