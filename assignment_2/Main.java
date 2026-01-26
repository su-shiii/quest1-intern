package assignment_2.Mopoken;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // read input
        String myInput  = sc.nextLine();
        String oppInput = sc.nextLine();

        // parse input
        List<Mopoken> mine = parse(myInput);
        List<Mopoken> opp  = parse(oppInput);

        if (!Validator.hasExactlyFive(mine) ||
    !Validator.hasExactlyFive(opp)) {
    System.out.println("Each breeder must have exactly 5 mopokens");
    return;
}

if (!Validator.hasUniqueTypes(mine) ||
    !Validator.hasUniqueTypes(opp)) {
    System.out.println("Each breeder must have unique mopoken types");
    return;
}


        // battle logic
        BattleLogic logic = new BattleLogic();
        List<Mopoken> result = logic.getOrder(mine, opp);

        // output
        if (result == null) {
            System.out.println("There are no chance of winning");
        } else {
            print(result);
        }

        sc.close();
    }

    // converts "Fire#10;Water#20;..." into List<Mopoken>
    private static List<Mopoken> parse(String input) {
        List<Mopoken> list = new ArrayList<>();

        String[] parts = input.split(";");
        for (String p : parts) {
            String[] data = p.split("#");
            String type = data[0];
            int level = Integer.parseInt(data[1]);

            list.add(new Mopoken(type, level));
        }

        return list;
    }

    

    // prints mopokens in required format
    private static void print(List<Mopoken> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(";");
            }
        }
        System.out.println();
    }
}
