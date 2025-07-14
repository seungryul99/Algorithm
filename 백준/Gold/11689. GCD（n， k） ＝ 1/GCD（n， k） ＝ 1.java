import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long tmp = n;
        Set<Long> set = new HashSet<>();

        double res = (double)n;

        // 소인수 구하기
        for(long i = 2; i<=(long)sqrt(n); i++) {

            if(tmp % i == 0) {
                set.add(i);

                while (tmp % i == 0){
                    tmp /= i;
                }
            }
        }
        if(tmp > 1) set.add(tmp);

        // 오일러 피함수 공식
        for(long l : set) {

            res *= (1.0-1.0/l);
        }

        System.out.println((long)res);
    }

}
