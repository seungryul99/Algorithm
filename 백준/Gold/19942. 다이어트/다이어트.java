import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int MIN_PROTEIN;
    public static int MIN_FAT;
    public static int MIN_CARB;
    public static int MIN_VITAMIN;
    public static int CANT_SOLVE = 1000000000;

    static List<Ingredient> ingredients = new ArrayList<>();

    static class Ingredient {
        int protein;
        int fat;
        int carb;
        int vitamin;
        int price;

        List<Integer> trace = new ArrayList<>();

        public Ingredient() {}

        public Ingredient(int protein, int fat, int carb, int vitamin, int price) {
            this.protein = protein;
            this.fat = fat;
            this.carb = carb;
            this.vitamin = vitamin;
            this.price = price;
        }

        public Ingredient add(Ingredient ingredient){

          return new Ingredient(
              this.protein + ingredient.protein,
              this.fat + ingredient.fat,
              this.carb + ingredient.carb,
              this.vitamin + ingredient.vitamin,
              this.price + ingredient.price
          );
        }

        public boolean satisfyMin(){

            if(this.protein < MIN_PROTEIN) return false;
            if(this.fat < MIN_FAT) return false;
            if(this.carb < MIN_CARB) return false;
            if(this.vitamin < MIN_VITAMIN) return false;

            return true;
        }

        public static Ingredient cantSolve(){
            return new Ingredient(0,0,0,0,CANT_SOLVE);
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        MIN_PROTEIN = Integer.parseInt(stk.nextToken());
        MIN_FAT = Integer.parseInt(stk.nextToken());
        MIN_CARB = Integer.parseInt(stk.nextToken());
        MIN_VITAMIN = Integer.parseInt(stk.nextToken());

        for (int i=0; i<n; i++){

            stk = new StringTokenizer(br.readLine());
            ingredients.add(new Ingredient(
                                Integer.parseInt(stk.nextToken()),
                                Integer.parseInt(stk.nextToken()),
                                Integer.parseInt(stk.nextToken()),
                                Integer.parseInt(stk.nextToken()),
                                Integer.parseInt(stk.nextToken()))
            );
        }

        Ingredient ingredient = new Ingredient();

        Ingredient result = go(0, ingredient);

        if (result.price == CANT_SOLVE) {
            System.out.println(-1);
            return;
        }

        System.out.println(result.price);
        Collections.sort(result.trace);

        for (int x : result.trace)
            System.out.print(x+1 + " ");
    }

    public static Ingredient go(int idx, Ingredient cur) {

        if (idx == ingredients.size()) {

            if(cur.satisfyMin()) return cur;
            else return Ingredient.cantSolve();
        }

        Ingredient target = ingredients.get(idx);
        Ingredient no = go(idx+1, cur);
        Ingredient yes = go(idx+1, cur.add(target));
        yes.trace.addAll(cur.trace);
        yes.trace.add(idx);

        if (yes.price < no.price) return yes;
        else if (yes.price > no.price) return no;
        else {
            int m = min(yes.trace.size(), no.trace.size());

            for (int i = 1; i <= m; i++) {

                int a = yes.trace.get(yes.trace.size() - i);
                int b = no.trace.get(no.trace.size() - i);

                if (a != b) return a < b ? yes : no;
            }
            return yes.trace.size() < no.trace.size() ? yes : no;
        }

    }
}
