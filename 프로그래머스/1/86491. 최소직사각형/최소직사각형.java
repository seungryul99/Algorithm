import java.util.*;

class Solution {
    
    public static int lastIndex;
    public static int[][] sizes;
    
    public int solution(int[][] input) {
    
        sizes = new int[input.length][2];
        
        for (int i=0; i<input.length; i++){
            
            for (int j=0; j<2; j++) sizes[i][j] = input[i][j];
        }

        lastIndex = input.length -1;
        
        return go(0, 0, 0);
    }
    
    public static int go(int index, int maxWidth, int maxLength){
        
        if (index == lastIndex + 1) return maxWidth * maxLength;
    
        int curWidth = sizes[index][0];
        int curLength = sizes[index][1];
        
        int val = go(index + 1, Math.max(maxWidth, curWidth), Math.max(maxLength, curLength));
        val = Math.min(val, go(index + 1, Math.max(maxWidth, curLength), Math.max(maxLength, curWidth)));
        
        return val;
    }
}