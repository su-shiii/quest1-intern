package lisp_2.node;
import lisp_2.visitor.Visitor;


public class SymbolNode implements Node {

    String symbol;

    public String getSymbol(){
        return symbol;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    
     public SymbolNode(String symbol){
        this.symbol = symbol;
    }
}
