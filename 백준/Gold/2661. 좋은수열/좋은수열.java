import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        go("1");
        go("2");
        go("3");
    }

    public static void go(String cur) {

        if(!check(cur)) return;

        if(cur.length() == n){
            System.out.println(cur);
            System.exit(0);
        }

        go(cur+"1");
        go(cur+"2");
        go(cur+"3");
    }

    public static boolean check(String cur){

        int size = cur.length()/2;

        for (int i=1; i<= size; i++){

            if(cur.substring(cur.length()-i, cur.length()).equals(cur.substring(cur.length()-i*2, cur.length()-i))) return false;
        }

        return true;
    }
}