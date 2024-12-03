import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n, res;
    static List<Integer> list = new ArrayList<>();

    static boolean check(int num){

        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i=2; i * i <= num; i++) if(num % i == 0) return false;

        return true;
    }

    static int sum(int start, int end){

        int sum = 0;
        for(int i=start; i<= end; i++) sum += list.get(i);

        return sum;
    }
    static void solve(){


        int l=0, r=0;
        int sum;

        while (r!=list.size()){

            sum = sum(l,r);


            if(sum > n){
                l++;
            }
            else if(sum < n){
                r++;
            }
            else {
                res++;
                l++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if(n==1 || n==2) {
            System.out.println(n-1);
            return;
        }


        for(int i=2; i<n; i++) if(check(i)) list.add(i);

        if(check(n)) res++;

        solve();

        System.out.println(res);
    }
}
