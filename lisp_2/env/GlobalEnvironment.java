package lisp_2.env;

import java.util.HashMap;
import java.util.Map;

public class GlobalEnvironment {

    private static GlobalEnvironment instance;

    private final Map<String, Object> symbols;

    private GlobalEnvironment() {
        symbols = new HashMap<>();
    }

    public static GlobalEnvironment getInstance() {
        if (instance == null) {
            instance = new GlobalEnvironment();
        }
        return instance;
    }

    public void set(String name, Object value) {
        symbols.put(name, value);
    }

    public Object get(String name) {
        if (!symbols.containsKey(name)) {
            throw new RuntimeException("Undefined symbol: " + name);
        }
        return symbols.get(name);
    }
}
