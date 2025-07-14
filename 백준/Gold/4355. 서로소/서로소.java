import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            List<Integer> list = new ArrayList<>();
            long n = Long.parseLong(br.readLine());
            if(n == 0) break;
            if(n == 1){
                System.out.println(0);
                continue;
            }

            long tmp = n;
            double res = (double)n;

            for(int i = 2; i<=(int)sqrt(n); i++) {

                if(tmp % i == 0) {

                    list.add(i);
                    while (tmp % i == 0) tmp /= i;
                }
            }
            if(tmp > 1) list.add((int)tmp);

            for(int l : list) res *= (1.0-1.0/l);

            System.out.println((int)res);
        }
    }

}
