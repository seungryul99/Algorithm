import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int res = 0;
        List<String> cache = new ArrayList<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            
            city = city.toLowerCase();
            
            // cache hit
            if (cache.contains(city)){
                
                cache.remove(city);
                cache.add(city);
                res++;
            }
            else {
                
                if(cache.size() < cacheSize) cache.add(city);
                else{
                    cache.remove(0);
                    cache.add(city);
                }
                res += 5;
            }
        }
        
        return res;
    }
}