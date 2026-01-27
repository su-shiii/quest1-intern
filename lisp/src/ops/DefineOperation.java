

package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.env.GlobalEnvironment;
import lisp.src.node.Node;
import lisp.src.node.SymbolNode;

public class DefineOperation implements Operations {

    private final GlobalEnvironment env = GlobalEnvironment.getInstance();

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {
        if (!(args.get(0) instanceof SymbolNode)) {
            throw new RuntimeException("define: first argument must be a symbol");
        }

        String name = ((SymbolNode) args.get(0)).getSymbol();
        Object value = args.get(1).accept(evaluator);

        env.set(name, value);
        return value;
    }
}

