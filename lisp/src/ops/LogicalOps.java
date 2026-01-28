package lisp.src.ops;

import java.util.List;

import lisp.src.Evaluator;
import lisp.src.node.Node;

public class LogicalOps implements Operations {

    private final String operator;

    public LogicalOps(String operator){
        this.operator=operator;
    }

    @Override
    public Object apply(List<Node> args,Evaluator evaluator){

        if(args.size()!=2){
            throw new RuntimeException(" Needs 2 arguments");
        }

        Object left=args.get(0).accept(evaluator);
        Object right=args.get(1).accept(evaluator);

        switch(operator){

            case "=":
                return (int)left==(int)right;
                
            case ">":
                return (int)left>(int)right;
            case "<":
                return (int)left<(int)right;
            case "eq":
                return left==right;
            case ">=":
                return (int)left>=(int)right;
            case "<=":
                return (int)left<=(int)right;

            default:
                throw new RuntimeException("Unknown logical operator: "+operator);
        }
    }
}
