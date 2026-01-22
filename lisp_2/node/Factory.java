package lisp_2.node;

import java.util.List;

public class Factory {

    public Node createNumber(int value) {
        return new NumberNode(value);
    }

    public Node createSymbol(String name) {
        return new SymbolNode(name);
    }

    public Node createList(List<Node> elements) {
        return new ListNode(elements);
    }
}
