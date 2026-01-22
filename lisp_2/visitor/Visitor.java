package lisp_2.visitor;
import lisp_2.node.NumberNode;
import lisp_2.node.SymbolNode;
import lisp_2.node.ListNode;

public interface Visitor {

    void visit(NumberNode numberNode);

    void visit(SymbolNode symbolNode);

    void visit(ListNode listNode);
}

