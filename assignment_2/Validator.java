package assignment_2.Mopoken;

import java.util.*;

public class Validator {

    // checks if breeder has exactly 5 mopokens
    public static boolean hasExactlyFive(List<Mopoken> list) {
        return list.size() == 5;
    }

    // checks if all mopoken types are unique
    public static boolean hasUniqueTypes(List<Mopoken> list) {
        Set<String> seen = new HashSet<>();

        for (Mopoken m : list) {
            if (seen.contains(m.getType())) {
                return false;
            }
            seen.add(m.getType());
        }

        return true;
    }
}
