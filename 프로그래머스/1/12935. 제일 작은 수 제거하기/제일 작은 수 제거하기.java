import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) return new int[]{-1};
        
        int min= arr[0];
        int pos= 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(min > arr[i]){
                min = arr[i];
                pos = i;
            } 
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            
            if(i==pos) continue;
            list.add(arr[i]);
        }
        
        int sol[] = new int[arr.length-1];

        for(int i=0;i<arr.length-1;i++){
            
            sol[i] = list.get(i);
        }
        
        return sol;
        
        
    }
}