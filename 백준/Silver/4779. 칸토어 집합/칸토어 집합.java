import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;

    static void cantor(int n){

        if(n==3){
            sb.append("- -");
            return;
        }

        int div = n/3;

        cantor(div);
        voidString(div);
        cantor(div);
    }

    static void voidString(int n){

        for(int i=0; i<n; i++) sb.append(" ");
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            String input = br.readLine();

            if (input == null) break;

            int n = (int)Math.pow(3,Integer.parseInt(input));

            if(n==1) System.out.print("-");
            else {
                sb = new StringBuilder();
                cantor(n);
                System.out.print(sb);
            }

            System.out.println();
        }

    }

}