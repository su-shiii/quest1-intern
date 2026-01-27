package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class EqOperation implements Operations{

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {
        if (args.size() != 2) {
            throw new RuntimeException("eq expects exactly 2 arguments");
        }

        Object left = args.get(0).accept(evaluator);
        Object right = args.get(1).accept(evaluator);

        return left == right;
    }
}
