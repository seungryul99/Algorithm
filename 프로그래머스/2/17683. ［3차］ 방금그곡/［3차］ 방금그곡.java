import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        m = m.replaceAll("C#", "c")
             .replaceAll("D#", "d")
             .replaceAll("F#", "f")
             .replaceAll("G#", "g")
             .replaceAll("A#", "a")
             .replaceAll("B#", "b");
        
        String res = "";
        int maxPlayTime = 0;
        
        for (String cur : musicinfos){
            
            String[] info = cur.split(",");
            
            String startTime = info[0];
            String endTime = info[1];
            String title = info[2];
            String melody = info[3].replaceAll("C#", "c")
                                   .replaceAll("D#", "d")
                                   .replaceAll("F#", "f")
                                   .replaceAll("G#", "g")
                                   .replaceAll("A#", "a")
                                   .replaceAll("B#", "b");
            
            int playTime = resolvePlayTime(startTime, endTime);
            String realMelody = resolveRealMelody(playTime, melody);
            
            if (check(realMelody, m) && playTime > maxPlayTime){
                
                maxPlayTime = playTime;
                res = title;
            }
            
        }
        
        return res.length()==0 ? "(None)" : res;
    }
    
    public int resolvePlayTime(String startTime, String endTime){
        
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        
        int startHour = Integer.parseInt(start[0]);
        int startMin = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMin = Integer.parseInt(end[1]);
        
        int resMin = endMin - startMin;
        int resHour = endHour - startHour;
        
        if(resMin < 0) {
            resHour--;
            resMin += 60;
        }
        
        return resHour * 60 + resMin;
    }   
    
    public String resolveRealMelody(int playTime, String melody){
        
        int idx=0;
        StringBuilder sb = new StringBuilder();
        
        while(playTime > 0){
            
            if (idx >= melody.length()) idx %= melody.length();
                
            sb.append(melody.charAt(idx));
            idx++;
            playTime--;
        }
        
        return sb.toString();
    }
    
    public boolean check(String realMelody, String m){
        
        return realMelody.contains(m);
    }
}