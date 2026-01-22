package lisp_2.node;
import lisp_2.visitor.Visitor;

import java.util.List;

public class ListNode implements Node{

    List<Node> elements;

    public List<Node> getList(){
        return elements;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public ListNode(List<Node> elements) {
        this.elements = elements;
    }
}
