


package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class Multiplication implements Operations {

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {
        int product = 1;


        for (Node arg : args) {
            product *= (int) arg.accept(evaluator);
        }

        return product;
    }
}

