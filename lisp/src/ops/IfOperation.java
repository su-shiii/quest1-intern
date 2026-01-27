package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class IfOperation implements Operations{

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {

        // (if condition then-expr else-expr)
        if (args.size() != 3) {
            throw new RuntimeException("if expects exactly 3 arguments");
        }

        // 1️⃣ Evaluate condition
        Object cond = args.get(0).accept(evaluator);

        if (!(cond instanceof Boolean)) {
            throw new RuntimeException("if condition must be boolean");
        }

        boolean condition = (Boolean) cond;

        // 2️⃣ Lazy evaluation: evaluate ONLY one branch
        if (condition) {
            return args.get(1).accept(evaluator);
        } else {
            return args.get(2).accept(evaluator);
        }
    }
}
