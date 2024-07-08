class Solution {
    public StringBuffer solution(int n) {
        
        StringBuffer sb = new StringBuffer();
        int reg = 1;
        
        for(int i=1;i<=n;i++){
            
            if(reg == 1){
                sb.append("수");
                reg = 0;
            }
            
            else {
                sb.append("박");
                reg = 1;
            }
        }
        
        return sb;
        
    }
}