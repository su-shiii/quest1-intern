package lisp.src.node;
import lisp.src.Visitor;

public interface Node {

   <T> T accept(Visitor<T> v);
}


