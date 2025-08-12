import java.util.*;

class Solution {
    public long solution(String exp) {
        
        // 3! 이라 구현보다 그냥 쓰는게 빠를듯
        List[] per = new List[6];
        per[0] = List.of('-', '+', '*');
        per[1] = List.of('-', '*', '+');
        per[2] = List.of('+', '*', '-');
        per[3] = List.of('+', '-', '*');
        per[4] = List.of('*', '+', '-');
        per[5] = List.of('*', '-', '+');

        // exp 분리
        List<Long> originNums = new ArrayList<>();
        List<Character> originOps = new ArrayList<>();
        
        String s = "";
        for(int i=0; i<exp.length(); i++){
            
            char c = exp.charAt(i);
            
            if(c >= '0' && c <= '9') s+=c;
            else {
                
                originNums.add(Long.parseLong(s));
                s="";
                originOps.add(c);
            }
        }
        originNums.add(Long.parseLong(s));
        
        
        long[] can = new long[6];
        int canIdx = 0;
        // 모든 경우의 수 계산
        for (List p : per){
            
            List<Long> nums = new LinkedList<>();
            List<Character> ops = new LinkedList<>();
            
            for (long n : originNums) nums.add(n);
            for (char c : originOps) ops.add(c);
            
            for (int idx=0; idx<3; idx++){
                
                char op = (char)p.get(idx);
                
                while(ops.contains(op)){
                    
                    for(int i=0; i<ops.size(); i++){
                        
                        char c = ops.get(i);
                        
                        if (c == op){
                            
                            long result = cal(op, nums.get(i), nums.get(i+1));
                            ops.remove(i);
                            nums.remove(i+1);
                            nums.remove(i);
                            nums.add(i, result);
                            break;
                        }
                    }
                }
            }
            can[canIdx++]=nums.get(0);
        }
        
        long max = 0;
        
        for (int i=0; i<6; i++){
            long cur = can[i] < 0 ? can[i]*-1 : can[i];
            
            if(cur > max) max = cur;
        }
        
        return max;
    }
    
    long cal(char op, long a, long b){
        
        if(op == '-') return a-b;
        if(op == '*') return a*b;
        return a+b;
    }
}