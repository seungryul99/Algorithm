import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n, r, cnt;
    static List<Integer> num = List.of(0,1,2,3,4,5,6,7,8,9);
    static List<Integer> list = new ArrayList<>();
    static List<Integer> res = List.of(-1);

    static void combi(int start){

        if(list.size()==r){
            
            cnt++;
            if(cnt == n) res = new ArrayList<>(list);

            return;
        }

        for(int i=start; i<10; i++){

            if(list.isEmpty() && num.get(i) == 0) continue;

            if(!list.isEmpty() && list.get(list.size()-1) <= num.get(i)) continue;

            list.add(num.get(i));
            combi(start);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if(n < 10) System.out.println(n);
        else {
            for(int i=1; i<=10; i++) {
                r = i;
                combi(0);
            }

            for (int e : res) System.out.print(e);
        }


    }
}