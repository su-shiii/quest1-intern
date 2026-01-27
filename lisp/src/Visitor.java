package lisp.src;
import lisp.src.node.ListNode;
import lisp.src.node.NumberNode;
import lisp.src.node.SymbolNode;

public interface Visitor<T> {

    T visitNumber (NumberNode N_Node);

    T visitSymbol (SymbolNode S_Node);

    T visitList (ListNode L_Node);
}

