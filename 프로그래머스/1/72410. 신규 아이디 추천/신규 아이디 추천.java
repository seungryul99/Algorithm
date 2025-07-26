class Solution {
    public String solution(String new_id) {
        
        // 1 
        new_id = new_id.toLowerCase();
        
        // 2
        int len = new_id.length();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++){
            
            char c = new_id.charAt(i);
            
            if ('a' <= c && c <='z' || '0' <= c && c <= '9' || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        new_id = sb.toString();
        
       
        // 3
        while(new_id.contains("..")) new_id = new_id.replace("..",".");
         
        // 4
        while(new_id.length() > 0 && new_id.charAt(0) == '.') {
            if(new_id.length() == 1) {
                new_id = "";
                break;
            }
            new_id = new_id.substring(1, new_id.length());
        }
       
       
        while(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.'){
            if(new_id.length() == 1) {
                new_id="";
                break;
            }
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
            
        // 5
        if(new_id.isBlank()) new_id = "a";
         
        // 6
        if(new_id.length() >= 16) new_id = new_id.substring(0,15);
      
        while(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.'){
            if(new_id.length() == 1) {
                new_id="";
                break;
            }
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        while (new_id.length() <=2) {
            new_id += new_id.charAt(new_id.length()-1);
        } 
        
        
        return new_id;
    }
    
    public static void p(String s){System.out.println(s);}
}