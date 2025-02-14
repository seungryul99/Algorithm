import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int idx = 0;
        int[] res = new int[commands.length];
        
        for (int i=0; i<commands.length; i++){
            
            int left = commands[i][0]-1;
            int right = commands[i][1];
            int target = commands[i][2]-1;
            int len = right - left;
            
            int[] subArray = new int[len];
            
            System.arraycopy(array, left, subArray, 0, len);
            
            Arrays.sort(subArray);
            
            res[idx++] = subArray[target];
        }
        
        return res;
    }
}