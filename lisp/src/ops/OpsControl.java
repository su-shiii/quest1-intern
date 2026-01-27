

package lisp.src.ops;
import java.util.HashMap;
import java.util.Map;

public class OpsControl {

    private static final Map<String, Operations> OPS = new HashMap<>();

    static {
    OPS.put("+", new Addition());
    OPS.put("-", new Subtraction());
    OPS.put("*", new Multiplication());
    OPS.put("/", new Division());
    OPS.put(">", new GreaterThanOperation());
    OPS.put("<", new LessThanOperation());
    OPS.put("=", new EqualityOperation());
    OPS.put("eq", new EqOperation());
    OPS.put("define", new DefineOperation());
    OPS.put("if", new IfOperation());         
    }



    public static Operations get(String name) {
        return OPS.get(name);
    }
}

