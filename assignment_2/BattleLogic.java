

package assignment_2.Mopoken;

import java.util.*;

public class BattleLogic {

    private TypeChart chart = new TypeChart();

    public List<Mopoken> getOrder(List<Mopoken> mine, List<Mopoken> opp) {

        boolean[] myUsed = new boolean[mine.size()];

        // result list aligned with opponent order
        List<Mopoken> order = new ArrayList<>();
        for (int i = 0; i < opp.size(); i++) {
            order.add(null);
        }

        int wins = 0;

        // loop through opponent mopokens
        for (int i = 0; i < opp.size(); i++) {

            Mopoken opponent = opp.get(i);

            // try to find a winning mopoken
            for (int j = 0; j < mine.size(); j++) {

                if (myUsed[j]) continue;

                Mopoken me = mine.get(j);

                boolean meAdv  = chart.hasAdvantage(me, opponent);
                boolean oppAdv = chart.hasAdvantage(opponent, me);

                boolean iWin;

                // I have type advantage
                if (meAdv && !oppAdv) {
                    iWin = opponent.getLevel() < 2 * me.getLevel();
                }
                // opponent has type advantage
                else if (oppAdv && !meAdv) {
                    iWin = me.getLevel() >= 2 * opponent.getLevel();
                }
                // no type advantage (or same type)
                else {
                    iWin = me.getLevel() > opponent.getLevel();
                }

                // record win
                if (iWin) {
                    order.set(i, me);
                    myUsed[j] = true;
                    wins++;
                    break;
                }
            }
        }

        // fill remaining positions with unused mopokens
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i) == null) {
                for (int j = 0; j < mine.size(); j++) {
                    if (!myUsed[j]) {
                        order.set(i, mine.get(j));
                        myUsed[j] = true;
                        break;
                    }
                }
            }
        }

        if (wins < 3) {
            return null;
        }

        return order;
    }
}
