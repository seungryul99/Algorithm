import java.util.*;

class Trace{
    
    int x1,y1, x2,y2;
    
    public Trace(int x1, int y1, int x2, int y2){
        
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    @Override
    public boolean equals(Object o){
        
        Trace t = (Trace) o;
        
        if(this.x1 == t.x1 && this.y1 == t.y1 && this.x2 == t.x2 && this.y2 == t.y2) return true;
        if(this.x1 == t.x2 && this.y1 == t.y2 && this.x2 == t.x1 && this.y2 == t.y1) return true;
        
        return false;
    }
    
    @Override
    public String toString(){
        return "(" + this.x1 + "," + this.y1 + ") -> (" + this.x2 + "," + this.y2 + ")\n";  
    }
    
}

class Solution {
    
    public int solution(String dirs) {
        
        int x=0, y=0;
        List<Trace> list = new ArrayList<>();
        
        for(int i=0; i<dirs.length(); i++){
            
            if(dirs.charAt(i) == 'U'){
                
                Trace trace = new Trace(x,y,x,y+1);
                if(y==5) continue;
                if(!list.contains(trace)) list.add(trace);
                y++;
            }
            else if(dirs.charAt(i) == 'D'){
                
                Trace trace = new Trace(x,y,x,y-1);
                if(y==-5) continue;
                if(!list.contains(trace)) list.add(trace);
                y--;
            }
            else if(dirs.charAt(i) == 'L'){
                
                Trace trace = new Trace(x,y,x-1,y);
                if(x==-5) continue;
                if(!list.contains(trace)) list.add(trace);
                x--;
            }
            else if(dirs.charAt(i) == 'R'){
                
                Trace trace = new Trace(x,y,x+1,y);
                if(x==5) continue;
                if(!list.contains(trace)) list.add(trace);
                x++;
            }
        }
        
        return list.size();

    }
}