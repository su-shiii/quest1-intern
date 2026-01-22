package lisp_2.visitor;
import lisp_2.node.Node;
import lisp_2.node.NumberNode;
import lisp_2.node.SymbolNode;
import lisp_2.node.ListNode;

import lisp_2.env.GlobalEnvironment;


import java.util.List;

public class Evaluator implements Visitor {


private final GlobalEnvironment env = GlobalEnvironment.getInstance();

    
    private Object result;

    public Object getResult() {
        return result;
    }

    @Override
    public void visit(NumberNode numberNode) {
        result = numberNode.getValue();
    }

    @Override
public void visit(SymbolNode symbolNode) {
    String name = symbolNode.getSymbol();

    // If symbol exists as a variable, return its value
    try {
        result = env.get(name);
    } catch (RuntimeException e) {
        // Otherwise, treat it as an operator (+, *, etc.)
        result = name;
    }
}


    @Override
    public void visit(ListNode listNode) {
        List<Node> elements = listNode.getList();

        //operator is first el
        Node first = elements.get(0);

        first.accept(this);
        String operator = (String) result;

        if (operator.equals("+")) {
            int sum = 0;

            for (int i=1; i < elements.size(); i++) {
                elements.get(i).accept(this);
                sum += (int) result;
            }

            result = sum;
        }

        else if (operator.equals("*")) {
            int product = 1;

            for (int i = 1; i < elements.size(); i++) {
                elements.get(i).accept(this);
                product *= (int) result;
            }

            result = product;
        }

        else if (operator.equals(">")) {

    if (elements.size() != 3) {
        throw new RuntimeException("> expects exactly 2 arguments");
    }

        elements.get(1).accept(this);
    int left = (int) result;

    elements.get(2).accept(this);
    int right = (int) result;

    result = left > right;
}

else if (operator.equals("<")) {

    if (elements.size() != 3) {
        throw new RuntimeException("> expects exactly 2 arguments");
    }

    elements.get(1).accept(this);
    int left = (int) result;

    elements.get(2).accept(this);
    int right = (int) result;

    result = left < right;
}
else if (operator.equals("=")) {

    if (elements.size() != 3) {
        throw new RuntimeException("= expects exactly 2 arguments");
    }

    elements.get(1).accept(this);
    int left = (int) result;

    elements.get(2).accept(this);
    int right = (int) result;

    result = (left == right);
}

else if (operator.equals("eq")) {

    if (elements.size() != 3) {
        throw new RuntimeException("eq expects exactly 2 arguments");
    }

    elements.get(1).accept(this);
    Object left = result;

    elements.get(2).accept(this);
    Object right = result;

    result = (left == right);
}

else if (operator.equals("equal")) {

    if (elements.size() != 3) {
        throw new RuntimeException("equal expects exactly 2 arguments");
    }

    elements.get(1).accept(this);
    Object left = result;

    elements.get(2).accept(this);
    Object right = result;

    result = left.equals(right);
}


        else if (operator.equals("define")) {

    Node nameNode = elements.get(1);
    Node valueNode = elements.get(2);

    if (!(nameNode instanceof SymbolNode)) {
        throw new RuntimeException("define: first argument must be a symbol");
    }

    String varName = ((SymbolNode) nameNode).getSymbol();

    valueNode.accept(this);
    Object value = result;

    env.set(varName, value);
    result = value;
}


else if (operator.equals("if")) {

    if (elements.size() != 4) {
        throw new RuntimeException("if expects 3 arguments");
    }

    
    elements.get(1).accept(this);
    boolean condition = (boolean) result;

    if (condition) {
        elements.get(2).accept(this);
    } else {
        elements.get(3).accept(this);
    }

}


else {
    throw new RuntimeException("Unknown operator: " + operator);
}

    }
}

