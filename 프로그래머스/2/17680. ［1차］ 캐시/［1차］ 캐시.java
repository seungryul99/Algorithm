import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        Map<String, Integer> cache = new HashMap<>();
        int res = 0, time = 1;
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (String city : cities) {
            
            city = city.toLowerCase();
            
            int now = cache.getOrDefault(city, 0);
            
            // cache miss
            if (now == 0){
                
                if(cache.size() < cacheSize) {
                    cache.put(city, time);
                }
                else {
                    
                    int min = 10000000;
                    String deleteKey="";
                    for(String key : cache.keySet()){
                        
                        int val = cache.get(key);
                        
                        if (min > val){
                            min = val;
                            deleteKey = key;
                        }
                    }
                    
                    cache.remove(deleteKey);
                    cache.put(city, time);
                }
                res += 5;
            }
            
            // cache hit
            else {
                cache.put(city, time);
                res += 1;
            }
            
            time++;
        }

        return res;
    }
}