import java.util.*;

class Solution {
    
    static class Pair{
        int y, x;
        
        public Pair(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    
    static Map<Integer, Pair> mp = new HashMap<>();
  
    public String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        int num = 1;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                
                mp.put(num++, new Pair(i,j));
            }
        }
        
        mp.put(0, new Pair(3,1));
        mp.put(-1, new Pair(3,0));  // *
        mp.put(-2, new Pair(3,2));  // #
        
        int left = -1; 
        int right = -2; 
       
        for (int cur : numbers){

            if (cur == 1 || cur == 4 || cur == 7){
                
                left = cur;
                sb.append("L");
            }

            else if (cur == 3 || cur == 6 || cur == 9){

                right = cur;
                sb.append("R");
            }

            else {
                
                int leftDist = dist(left, cur);
                int rightDist = dist(right, cur);
                
                if(leftDist < rightDist){
                    
                    left = cur;
                    sb.append("L");
                }
                else if (leftDist > rightDist){
                    
                    right = cur;
                    sb.append("R");
                }
                else {
                    
                    if(hand.equals("left")){
                        
                        left = cur;
                        sb.append("L");
                    }
                    else {
                        
                        right = cur;
                        sb.append("R");
                    }
                }
            }
        }

        return sb.toString();
    }

    public static int dist(int dir, int cur){
        
        int dirY = mp.get(dir).y;
        int dirX = mp.get(dir).x;
        int curY = mp.get(cur).y;
        int curX = mp.get(cur).x;
        
        return Math.abs(dirY-curY)+ Math.abs(dirX-curX);
    }
}