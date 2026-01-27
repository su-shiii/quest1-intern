package lisp.src;

import java.util.List;

import lisp.src.env.GlobalEnvironment;
import lisp.src.node.ListNode;
import lisp.src.node.Node;
import lisp.src.node.NumberNode;
import lisp.src.node.SymbolNode;
import lisp.src.ops.Operations;
import lisp.src.ops.OpsControl;


public class Evaluator implements Visitor<Object> {

    
    private final GlobalEnvironment env = GlobalEnvironment.getInstance();

    //nodess

    @Override
    public Object visitNumber(NumberNode numberNode) {
        return numberNode.getValue();
    }

    @Override
    public Object visitSymbol(SymbolNode symbolNode) {
        String name = symbolNode.getSymbol();

        //check if its a defined variable
        if (env.contains(name)) {
            return env.get(name);
        }

        return name;
    }

    @Override
    public Object visitList(ListNode listNode) {

        List<Node> elements = listNode.getList();

        if (elements.isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        String operator = (String) elements.get(0).accept(this);

        Operations op = OpsControl.get(operator);
        if (op == null) {
            throw new RuntimeException("Unknown operator: " + operator);
        }

        return op.apply(elements.subList(1, elements.size()), this);
    }
}
