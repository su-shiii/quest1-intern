package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class Arithmetic implements Operations {

    private final String operator;

    public Arithmetic(String operator){
        this.operator=operator;
    }

    @Override
    public Object apply(List<Node> args,Evaluator evaluator){

        if(args.isEmpty()){
            throw new RuntimeException(operator+" expects at least one argument");
        }

        switch(operator){

            case "+":
                int sum=0;
                for(Node arg:args){
                    sum+=(int)arg.accept(evaluator);
                }
                return sum;

            case "*":
                int product=1;
                for(Node arg:args){
                    product*=(int)arg.accept(evaluator);
                }
                return product;

            case "-":
                int result=(int)args.get(0).accept(evaluator);

                if(args.size()==1){
                    return -result;
                }

                for(int i=1;i<args.size();i++){
                    result-=(int)args.get(i).accept(evaluator);
                }
                return result;

            case "/":
                if(args.size()!=2){
                    throw new RuntimeException("/ expects exactly 2 arguments");
                }

                int left=(int)args.get(0).accept(evaluator);
                int right=(int)args.get(1).accept(evaluator);

                if(right==0){
                    throw new RuntimeException("division by zero");
                }

                return left/right;

            default:
                throw new RuntimeException("Unknown arithmetic operator: "+operator);
        }
    }
}
