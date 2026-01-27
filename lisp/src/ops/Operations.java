package lisp.src.ops;
import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public interface Operations {
    Object apply(List<Node> args, Evaluator evaluator);
    }

