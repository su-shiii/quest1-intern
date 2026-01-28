

package lisp.src.ops;
import java.util.HashMap;
import java.util.Map;

public class OpsControl {

    private static final Map<String, Operations> OPS = new HashMap<>();

    static {
    OPS.put("+",new Arithmetic("+"));
    OPS.put("-",new Arithmetic("-"));
    OPS.put("*",new Arithmetic("*"));
    OPS.put("/",new Arithmetic("/"));

    OPS.put(">", new LogicalOps(">"));
    OPS.put("<", new LogicalOps("<"));
    OPS.put(">=", new LogicalOps(">="));
    OPS.put("<=", new LogicalOps("<="));
    OPS.put("=", new LogicalOps("="));
    OPS.put("eq", new LogicalOps("eq"));
    OPS.put("define", new DefineOperation());
    OPS.put("if", new IfOperation());         
    }



    public static Operations get(String name) {
        return OPS.get(name);
    }
}

