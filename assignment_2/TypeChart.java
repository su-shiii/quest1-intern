package assignment_2.Mopoken;

import java.util.*;

public class TypeChart {

    // a -> types that a has advantage over
    private static final Map<String, List<String>> ADVANTAGE_MAP = new HashMap<>();

    static {
        ADVANTAGE_MAP.put("Fire", Arrays.asList("Grass", "Ghost"));
        ADVANTAGE_MAP.put("Water", Arrays.asList("Fire"));
        ADVANTAGE_MAP.put("Grass", Arrays.asList("Electric", "Fighting"));
        ADVANTAGE_MAP.put("Electric", Arrays.asList("Water"));
        ADVANTAGE_MAP.put("Psychic", Arrays.asList("Ghost"));
        ADVANTAGE_MAP.put("Ghost", Arrays.asList("Fighting", "Fire", "Electric"));
        ADVANTAGE_MAP.put("Fighting", Arrays.asList("Electric"));
    }

    // returns true if 'me' has type advantage over 'opponent'
    public boolean hasAdvantage(Mopoken me, Mopoken opponent) {
        List<String> list = ADVANTAGE_MAP.get(me.getType());
        if (list == null) {
            return false;
        }
        return list.contains(opponent.getType());
    }
}
