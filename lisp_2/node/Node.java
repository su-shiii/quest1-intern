package lisp_2.node;
import lisp_2.visitor.Visitor;

public interface Node {

   void accept(Visitor v);
}


