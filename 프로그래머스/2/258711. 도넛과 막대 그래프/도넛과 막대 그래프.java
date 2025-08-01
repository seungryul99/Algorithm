// 개선된 풀이
class Solution {
    public int[] solution(int[][] edges) {
        
        // new int[len+1]을 하게되면, [[200, 435]] 같은 입력케이스에 걸림, 문제 조건상 노드의 번호는 1~1,000,000 까지 랜덤
        int len = edges.length;
        int[] in = new int[1_000_001];
        int[] out = new int[1_000_001];
        
        for (int i=0; i<len; i++){
            
            int from = edges[i][0];
            int to = edges[i][1];
            
            in[to]++;
            out[from]++;
        }
        
        
        int start=0, m=0, d=0, e=0;
        
        for (int i=1; i<=1_000_000; i++){
            
            if(in[i] == 0 && out[i] >= 2) start = i;
            else if(in[i] >= 2 && out[i] ==2) e++;
            else if(in[i] != 0 && out[i] == 0) m++;
        }
        
        d = out[start] - e - m;
        
        return new int[]{start, d, m , e}; 
    }
}


// 개선 전 풀이
/**
import java.util.*;

class Solution {
    
    static class Node{

        List<Integer> in;
        List<Integer> out;
        
        public Node(){

            this.in = new ArrayList<>();
            this.out = new ArrayList<>();
        }
    }
    
    static Map<Integer, Node> mp;
    
    public int[] solution(int[][] edges) {
        
        int len = edges.length;
        mp = new HashMap<>();
        
        for (int i=0; i<len; i++){
            
            int from = edges[i][0];
            int to = edges[i][1];
            
            Node fromNode = mp.getOrDefault(from, null);
            
            
            if (fromNode == null){
                
                Node node = new Node();
                node.out.add(to);
                mp.put(from, node);
            }
            else {
                fromNode.out.add(to);
                mp.put(from, fromNode);
            }
            
            Node toNode = mp.getOrDefault(to, null);
            if (toNode == null){
                
                Node node = new Node();
                node.in.add(from);
                mp.put(to, node);
            }
            else {
                toNode.in.add(from);
                mp.put(to, toNode);
            }
        }
        
        Set<Integer> st = mp.keySet();
        
        int max = -1;
        int start = 0;
        
        for (int cur : st){
            
            Node node = mp.get(cur);
            
            if(node.in.size() == 0 && node.out.size() > max){
                
                start = cur;
                max = node.out.size();
            }
        }
        
        // System.out.println("시작점 : " + start);

        // 각 그래프의 연결점
        List<Integer> link = mp.get(start).out;
        // System.out.println("각 그래프의 연결점 : " + link);
        
        int m=0, d=0, e=0;
        
        for (int x : link){
            
            Node node = mp.get(x);
            
            // start 노드는 그래프 탐색에서 제거
            for (int i=0; i<node.in.size(); i++){
                
                if (node.in.get(i) == start) {
                    node.in.remove(i);
                    break;
                }
            }
            
            int res = -1;
            
            if(node.in.size()==2 && node.out.size()==2) e++;     // 연결점이 8자 그래프의 중간점 일 경우
            else if (node.out.size() == 0) m++;                  // 연결점이 막대 그래프의 종단 점일 경우  
            else res = go(x, node.out.get(0));                   // 그렇지 않은 연결점은 outDegree가 1임
            
            if (res == 1) d++;
            else if (res == 2) m++;
            else if (res == 3) e++;
        }
        
        return new int[]{start, d, m, e};
    }
    
    // 그래프 탐색
    public int go(int cycle, int cur){
    
        Node node = mp.get(cur);
        
        if (node.out.size() == 0) return 2;
        if (node.out.size() == 2 && node.in.size() == 2) return 3;
        if (cycle == cur) return 1;
        
        return go(cycle, node.out.get(0));
    }
    
}
**/
