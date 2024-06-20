class Solution {
    public int solution(String s) {
       
        // 문제에서 s[0]가 +,-가 올 수 있다고 했는데 양수를 +로 표기한다고는 안해서 애매함
        // 일단은 둘다 처리
        // Integer.parseInt() 시간 복잡도 O(N)
        // substring : O(N)
        
        if (s.charAt(0) == '+'){
            
            s = s.substring(1,s.length());
            return Integer.parseInt(s);
        }
        
        else if (s.charAt(0) == '-'){
            
            s = s.substring(1,s.length());
            return Integer.parseInt(s)*-1;
        }
        
        else {
            return Integer.parseInt(s);
        }
    }
}