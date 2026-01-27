package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class GreaterThanOperation implements Operations {

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {
        if (args.size() != 2) {
            throw new RuntimeException("> expects exactly 2 arguments");
        }

        int left = (int) args.get(0).accept(evaluator);
        int right = (int) args.get(1).accept(evaluator);

        return left > right;
    }
}
