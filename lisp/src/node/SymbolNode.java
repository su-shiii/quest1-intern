package lisp.src.node;
import lisp.src.Visitor;


public class SymbolNode implements Node {

    String symbol;

    public String getSymbol(){
        return symbol;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visitSymbol(this);
    }
    
     public SymbolNode(String symbol){
        this.symbol = symbol;
    }
}
