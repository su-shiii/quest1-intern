package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class Subtraction implements Operations {

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {

        if (args.size() < 1) {
            throw new RuntimeException("- expects at least one argument");
        }

        int result = (int) args.get(0).accept(evaluator);

        //single operand
        if (args.size() == 1) {
            return -result;
        }

        for (int i = 1; i < args.size(); i++) {
            result -= (int) args.get(i).accept(evaluator);
        }

        return result;
    }
}
