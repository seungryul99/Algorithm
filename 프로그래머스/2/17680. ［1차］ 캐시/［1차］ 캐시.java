import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize==0) return cities.length * 5;
        
        int res = 0;
        List<String> cache = new ArrayList<>();
        String tmp;
        
        for(String city : cities){
            
            tmp = city.toLowerCase();
            
            if(cache.contains(tmp)){
                
                cache.remove(tmp);
                cache.add(tmp);
                res++;
            }
            else{

                if(cacheSize == cache.size()) cache.remove(0);               
                cache.add(tmp);
                res+=5;
            }
        }
        
        return res;
    }
}