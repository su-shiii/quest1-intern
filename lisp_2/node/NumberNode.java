package lisp_2.node;

import lisp_2.visitor.Visitor;


public class NumberNode implements Node {

    int value;

    public int getValue(){
        return value;
    }


    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    //constrcutor
     public NumberNode(int value){
        this.value = value;
    }

    
}
