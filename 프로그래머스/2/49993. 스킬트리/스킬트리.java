class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int res = 0;
        
        for (int i=0; i<skill_trees.length; i++){
            
            String s = skill_trees[i];   
            int cnt = 0;
            boolean success = true;
            
            for (int j=0; j<s.length(); j++){
                
                int idx = skill.indexOf(s.charAt(j));
             
                if(idx == -1) continue;
                
                if(cnt < idx) {
                    success = false;
                    break;
                }
                else cnt++;
            }
            
            if(success) res ++;
        }
        
        return res;
    }
}