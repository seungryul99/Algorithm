import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static List<Integer> s = new ArrayList<>();
    static List<Integer> a = new ArrayList<>();
    static int n;

    static void print(){

        for(int x : a) System.out.print(x + " ");
        System.out.println();
    }
    static void combi(int start){

        if(a.size() == 6){
            print();
            return;
        }

        for(int i= start+1; i<n; i++){
            a.add(s.get(i));
            combi(i);
            a.remove(a.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            s.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n==0) break;

            while (st.hasMoreTokens()) s.add(Integer.valueOf(st.nextToken()));

            Collections.sort(s);
            a.clear();
            combi(-1);
            System.out.println();
        }
    }
}