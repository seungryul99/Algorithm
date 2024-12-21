import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) list.add(Integer.valueOf(st.nextToken()));

        // [로직]
        Collections.sort(list);

        int res = 0;
        for(int i=0;i<n;i++){

            int goal = list.get(i);
            list.remove(i);
            int l = 0, r = n-2;

            while (l!=r){

                int left = list.get(l);
                int right = list.get(r);

                if(left + right ==goal){
                    res++;
                    break;
                }
                else if(left + right > goal){
                    r--;
                }
                else{
                    l++;
                }
            }
            list.add(i,goal);
        }
        System.out.println(res);
    }
}