import java.util.*;

class Solution {
    
    static class Music implements Comparable<Music>{
        
        int playCnt;
        int id;
        
        public Music(int playCnt, int id){
            this.playCnt = playCnt;
            this.id = id;
        }
        
        @Override
        public int compareTo(Music m){
            
            if(this.playCnt < m.playCnt) return 1;
            else if(this.playCnt > m.playCnt) return -1;
            else {
                return this.id < m.playCnt ? 1 : -1;
            }
        }
        
    }
    
    static class Genre implements Comparable<Genre>{
        
        String name;
        int playCnt;
        
        public Genre(String name, int playCnt){
            this.name = name;
            this.playCnt = playCnt;
        }
        
        @Override
        public int compareTo(Genre g){
            
            return this.playCnt < g.playCnt ? 1 : -1;
        }
    }
    
    
    public List<Integer> solution(String[] genres, int[] plays) {
        
        int len = genres.length;
        
        // 장르별 재생수 구함
        Map<String, Integer> genreCntMap = new HashMap<>();
        
        for(int i=0; i<len; i++){
            
            String genre = genres[i];
            int playCnt = plays[i];
            
            if(!genreCntMap.containsKey(genre)) genreCntMap.put(genre, playCnt);
            else genreCntMap.put(genre, genreCntMap.get(genre) + playCnt);
        }
        
        // 장르순 정렬
        Set<Genre> genreSet = new TreeSet<>();
        
        for(String key : genreCntMap.keySet()) genreSet.add(new Genre(key, genreCntMap.get(key)));
        
        Map<String, Set<Music>> musicsMap = new HashMap<>();
        
        // 장르별 음악 저장과 동시에 정렬
        for(int i=0; i<len; i++){
            
            String genre = genres[i];
            int playCnt = plays[i];
            
            if(!musicsMap.containsKey(genre)) {
                
                musicsMap.put(genre, new TreeSet<Music>());
                musicsMap.get(genre).add(new Music(playCnt,i));
            }
            else musicsMap.get(genre).add(new Music(playCnt,i));
        }
        
        // 장르별 top2로 결과 만들기
        List<Integer> res = new ArrayList<>();
        
        for(Genre genre : genreSet){
            
            String key = genre.name;
            
            int cnt = 0;
            
            for(Music m : musicsMap.get(key)){
                
                if(cnt==2) break;
                res.add(m.id);
                cnt++;
            }
        }
        
        return res;
    }
}