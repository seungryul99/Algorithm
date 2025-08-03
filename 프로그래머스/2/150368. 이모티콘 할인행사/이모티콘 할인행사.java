import java.util.*;

class Solution {
    
    static int n, m;
    static int[][] u;
    static int[] e;
    
    static class Stat{
        
        int cnt;
        int total;
        
        public Stat(){}
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        n = users.length;
        m = emoticons.length;
        u = users;
        e = emoticons;
        
        List<Integer> combi = new ArrayList<>();
        
        Stat res = go(0, combi);
        
        return new int[]{res.cnt, res.total};
    }
    
    public Stat go(int idx, List<Integer> combi){
        
        // 계산
        if(idx == m){
         
            Stat stat = new Stat();
            
            for (int i=0; i<n; i++){
                
                int perStandard = u[i][0];
                int priceStandard = u[i][1];
                int totalPrice = 0;
                boolean exceed = false;
                
                for (int j=0; j<m; j++){
                    
                    int per = combi.get(j);
                    int price = e[j] * (100 - per) / 100;
                    
                    if (per >= perStandard) totalPrice += price;   
                }
                
                if (priceStandard <= totalPrice) stat.cnt++;
                else stat.total += totalPrice;
            }
            
            return stat;
        }
        
        Stat val = new Stat();
        for (int per=10; per<=40; per+=10){
            
            combi.add(per);
            val = max(val, go(idx+1, combi));
            combi.remove(combi.size()-1);
        }
        
        return val;
    }
    
    public static Stat max(Stat a, Stat b){
        
        if(a.cnt == b.cnt) return a.total > b.total ? a : b;
        return a.cnt > b.cnt ? a : b;
    }
}