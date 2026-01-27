package lisp.src.node;
import java.util.List;

import lisp.src.Visitor;

public class ListNode implements Node{

    List<Node> elements;

    public List<Node> getList(){
        return elements;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visitList(this);
    }

    public ListNode(List<Node> elements) {
        this.elements = elements;
    }
}
