import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    static List<File> res = new ArrayList<>();
    
    class File {
        
        String head;
        String number;
        String tail;
        
        public File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public String toString(){
            return head + number + tail;
        }
    }
    
    class CustomComparator implements Comparator<File>{
        
        @Override
        public int compare(File f1, File f2){
            
            int headCompare = f1.head.toUpperCase().compareTo(f2.head.toUpperCase());
            if (headCompare != 0) return headCompare;
            
            int n1 = Integer.parseInt(f1.number);
            int n2 = Integer.parseInt(f2.number);
           
            if (n1 < n2) return -1;
            else if (n1 == n2) return 0;
            else return 1;
        }
    }
    
    public List<String> solution(String[] files) {
        
        for (String s : files){
            
            int idx=0;
            
            StringBuilder headSb = new StringBuilder();
            
            while(true){
                
                char c = s.charAt(idx);
                
                if (c >= '0' && c <= '9') break;
    
                headSb.append(c);
                idx++;
            }
            
            int len = 0;
            StringBuilder numberSb = new StringBuilder();
        
            while(true){
                
                if (idx == s.length()) break;
                char c = s.charAt(idx);
                
                if (c < '0' || c > '9' || len > 5) break;
                
                numberSb.append(c);
                idx++;
                len++;
            }
            
            String tail = s.length() == idx ? "" : s.substring(idx, s.length());
            String number = numberSb.toString();
            String head = headSb.toString();
            
            res.add(new File(head, number, tail));
        }
        
        Collections.sort(res, new CustomComparator());
        
        return res.stream()
            .map(file -> file.toString())
            .collect(Collectors.toList());
    }
}