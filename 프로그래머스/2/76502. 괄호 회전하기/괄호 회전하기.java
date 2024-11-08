import java.util.*;

class Solution {
    
    public void testRotate(char[] c){
        
        for (char x : c) System.out.print(x);
        System.out.println();
    }
    
    public void testStack(Stack<Character> stk){
        
        for(Character c : stk) System.out.print(c);
        System.out.println();
    }
      
    public int solution(String s) {
        
        int res = 0;
        int len = s.length();
        char[] c = new char[len];
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<len; i++){
            
            // 배열을 i 만큼 좌회전 
            for(int j=0; j<len; j++){
                
                if(j-i < 0) c[j+len-i] = s.charAt(j);
                else c[j-i] = s.charAt(j);
            }
            
            // testRotate(c);
            
            // 회전한 배열로 검사
            if(!stk.isEmpty()) stk.clear();
            
            stk.push(c[0]);
            
            for(int j=1; j<len; j++){
                // testStack(stk);
                if(stk.isEmpty()) stk.push(c[j]);
                else if(stk.peek() == '{' && c[j] == '}' || stk.peek() == '[' && c[j] == ']' || stk.peek() == '(' && c[j] == ')') stk.pop();
                else stk.push(c[j]);
            }
            
            if(stk.isEmpty()) res++;
        }
        
        return res;
    }
    
  
}