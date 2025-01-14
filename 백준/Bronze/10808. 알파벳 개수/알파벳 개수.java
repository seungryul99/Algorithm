import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] cnt = new int[26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i=0;i<s.length();i++) cnt[s.charAt(i)-97]++;

        for(int x : cnt) System.out.print(x + " ");
    }
}