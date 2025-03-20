import java.io.*;
import java.math.BigInteger;

import static java.lang.Math.*;

public class Main {

    static int num;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    static void hanoi(int n, int from, int temp, int to) throws IOException {

        if (n==1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        hanoi(n-1, from, to, temp);

        bw.write(from + " " + to + "\n");

        hanoi(n-1,temp, from, to);
    }

    public static void main(String[] args) throws IOException {

        num = Integer.parseInt(br.readLine());

        System.out.println(BigInteger.valueOf(2).pow(num).subtract(BigInteger.valueOf(1)));

        if(num<=20) {
            hanoi(num,1,2,3);
            bw.flush();
        }
    }
}