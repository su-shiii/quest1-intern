package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class Addition implements Operations {

    @Override
    public Object apply(List<Node> args, Evaluator evaluator) {
        int sum=0;
        for (Node arg : args) {
            sum += (int) arg.accept(evaluator);
        }
        return sum;
    }
}