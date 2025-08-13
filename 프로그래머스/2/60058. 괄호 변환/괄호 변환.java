import java.util.*;

class Solution {
    
    static class SepResult{
        String u, v;
        
        public SepResult(String u, String v){
            this.u = u;
            this.v = v;
        }
    }
    
    public String solution(String p) {
        
        if (p.isBlank()) return "";
        
        return go(p);
    }
    
    public String go(String w){
        
        SepResult sepRes = seperate(w);
        String u = sepRes.u;
        String v = sepRes.v;            
        
        boolean correct = isCorrect(u);
        if(correct && v.isBlank()) return u;
        
        if(correct) return u + go(v);
        else {
            
            StringBuilder sb = new StringBuilder("");
            sb.append("(");
            sb.append(go(v));
            sb.append(")");
            sb.append(u.substring(1,u.length()-1).replace("(","#").replace(")","(").replace("#",")"));
            
            return sb.toString();
        }
    }
    
 
    public SepResult seperate(String w){
        
        int len = w.length();
        int l = 0, r = 0;
        String u = "", v = "";

        for(int i=0; i<len; i++){
            
            char c = w.charAt(i);
            
            if(c=='(') l++;
            else r++;
            
            if(l>0 && r>0 && l==r){
                u = w.substring(0,i+1);
                v = w.substring(i+1, len);
                break;
            }
        }
        
        // System.out.println(u + " ### " + v);
        
        return new SepResult(u, v);
    }
    
    public boolean isCorrect(String s){
    
        Deque<Character> stk = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(c == '(') stk.push(c);
            else{
                if(!stk.isEmpty() && stk.peek() == '(') stk.pop();
                else stk.push(c);
            }
        }
        
        // System.out.println(stk.size());
        
        if(stk.size()==0) return true;
        return false;
    }
}