import java.util.*;
import java.time.format.*;
import java.time.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> cond = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        // term 초기화
        StringTokenizer stk;        
        for (String s : terms) {
            
            stk = new StringTokenizer(s);
            cond.put(stk.nextToken(), Integer.parseInt(stk.nextToken()));
        }
        
        int tYear = Integer.parseInt(today.substring(0,4));
        int tMonth = Integer.parseInt(today.substring(5,7));
        int tDay = Integer.parseInt(today.substring(8,10));
        
        int idx = 1;
        for (String cur : privacies) {
            
            stk = new StringTokenizer(cur);
            
            String date = stk.nextToken();
            String type = stk.nextToken();
            int period = cond.get(type);
            
            int year = Integer.parseInt(date.substring(0,4));
            int month = Integer.parseInt(date.substring(5,7));
            int day = Integer.parseInt(date.substring(8,10));
            
            day--;
            if(day == 0){
                
                day = 28;
                month--;
            }
            
            month += period;
            if (month > 12){
                year += month / 12;
                month %= 12;
            }
            
            if (month == 0){
                month = 12;
                year--;
            }
            
            if(tYear > year) res.add(idx);
            else if(tYear == year){
                
                if(tMonth > month) res.add(idx);
                else if(tMonth == month){
                    
                    if(tDay > day) res.add(idx);
                }
            }
           
            idx++;
        }
        
        return res;
    }
}