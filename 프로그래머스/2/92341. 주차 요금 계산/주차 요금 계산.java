import java.util.*;

class Solution {
    
    static class Rec{
        
        String in;
        String out;
        
        public Rec(){
            in = "";
            out = "23:59";
        }
        
        public int getDuration(){
            
            int outH = Integer.parseInt(out.substring(0,2));
            int outM = Integer.parseInt(out.substring(3,5));
            int inH = Integer.parseInt(in.substring(0,2));
            int inM = Integer.parseInt(in.substring(3,5));

            int h = outH - inH;
            int m = outM - inM;
           
            if(m < 0){
                m+=60;
                h--;
            }
    
            return h*60 + m;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        
        Map<Integer, List<Rec>> mp = new TreeMap<>();
    
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        for (String s : records){
            
            StringTokenizer stk = new StringTokenizer(s);
            
            String time = stk.nextToken();
            Integer num = Integer.parseInt(stk.nextToken());
            String action = stk.nextToken();
            
            if (action.equals("IN")) {
                
                List<Rec> recs = mp.getOrDefault(num, null);
                
                if(recs == null){
                    
                    recs = new ArrayList<>();
                    
                    Rec rec = new Rec();
                    rec.in = time;
                    recs.add(rec);
                    mp.put(num, recs);
                }
                else{
                    
                    Rec rec = new Rec();
                    rec.in = time;
                    recs.add(rec);
                }
            }
            else {
                
                List<Rec> recs = mp.getOrDefault(num, null);
                Rec rec = recs.get(recs.size()-1);
                rec.out = time;
            }
        }
        
        int res[] = new int[mp.size()];
        int idx = 0;
        
        Set<Integer> st = mp.keySet();
        
        for (Integer num : st){
    
            List<Rec> list = mp.get(num);
            
            int duration = 0;
            for (Rec r : list) duration += r.getDuration();
            
            
            int sum;
            int exceedTime = duration - baseTime;
     
            if (exceedTime > 0) {
        
                if((exceedTime) % unitTime != 0) exceedTime += unitTime;
                    
                sum = baseFee + exceedTime/unitTime * unitFee; 
            }
            else sum = baseFee;
            
            
            res[idx++] = sum;
        }
    
        
        return res;
    }
}