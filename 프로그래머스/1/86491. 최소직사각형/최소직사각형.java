class Solution {
    public int solution(int[][] sizes) {
       
        int answer = 1;
        
        int len = sizes.length;
        int width = 0;
        int length = 0;
        
        // 가로 구함
        for (int i=0; i<len; i++){
            
            int curWidth = sizes[i][0];
            int curLength = sizes[i][1];
            
            width = Math.max(width, Math.max(curWidth, curLength));
            length = Math.max(length, Math.min(curWidth, curLength));
        }
        
        return width * length;
    }
}