import java.util.*;

class Solution {

    public int solution(String dartResult) {
        
        int[] score = new int[3];
        
        int idx = -1;
        for (int i=0; i<dartResult.length(); i++){
            
            char cur = dartResult.charAt(i);
            
            if(cur >= '0' && cur <= '9'){
                
                idx++;
                
                if (cur == '1' && dartResult.charAt(i+1) == '0') {
                    score[idx] = 10;
                    i++;
                }
                else score[idx] = Integer.valueOf(cur - '0');
            }
            
            else if(cur == 'S' || cur == 'D' || cur == 'T'){
                
                if (cur == 'T') score[idx]  *= score[idx] * score[idx];
                else if (cur == 'D') score[idx] *= score[idx];
            }
            
            else {
                
                if(cur == '*') {
                    
                    if(idx == 0) score[idx] *= 2;
                    else {
                        
                        score[idx] *= 2;
                        score[idx -1] *= 2;
                    }
                }
                else if(cur == '#') score[idx] *= -1;
            }
        }
        
        
        int res = score[0] + score[1] + score[2];
        return res;
    }
}