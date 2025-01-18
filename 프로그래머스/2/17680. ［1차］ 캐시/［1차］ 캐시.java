import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize==0) return cities.length * 5;
        
        int res = 0;
        List<String> cache = new ArrayList<>();
        int cnt = 0;
        
        // 캐시 초기화
        for(String city : cities){
            
            String cur = city.toLowerCase();
            cnt ++;
            
            if(cache.contains(cur)) {
                cache.remove(cur);
                cache.add(cur);
                res++;
            }
            else{
                cache.add(cur);
                res+=5;
            }
          
            if(cache.size() == cacheSize) break;
        }
        
        
        // 로직
        for(int i=cnt; i<cities.length; i++){
            
            String city = cities[i].toLowerCase();
            
            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                res++;
            }
            else{
                cache.remove(0);
                cache.add(city);
                res+=5;
            }
        }
        
        return res;
    }
}