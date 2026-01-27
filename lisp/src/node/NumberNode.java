package lisp.src.node;

import lisp.src.Visitor;


public class NumberNode implements Node {

    //public final int value;
    int value;

    public int getValue(){
        return value;
    }


    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visitNumber(this);
    }

    //constrcutor
     public NumberNode(int value){
        this.value = value;
    }

    
}
