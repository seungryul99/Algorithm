class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int zero = 0;
        
        while(true){
            
            int one = 0;
            
            // 탈출 로직 
            if(s.equals("1")) break;
            
        
            // x에서 1을 모두 제거함
            for(int i=0;i<s.length();i++){
                
                if(s.charAt(i) == '1') one++;
            }
            
            zero += s.length()-one;
            
            
            // x의 길이를 2진수로 나타냄, 직접 2로 나눠서 구해도 될듯
            s = Integer.toBinaryString(one);
            
            cnt++;
        }
        
        return new int[]{cnt,zero};
    }
}