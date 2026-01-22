package lisp_2;

import java.util.List;
import java.util.Scanner;

import lisp_2.node.Node;
import lisp_2.node.Factory;
import lisp_2.visitor.Evaluator;



public class Main {


    static Scanner s= new Scanner(System.in);
    public static void main(String[] args) {

        String input= s.nextLine();
        //String input = "(if (> 10 5) (+ 1 2) (* 2 3))";

        List<String> tokens = Tokenizer.tokenize(input);

        Factory factory = new Factory();
        Parser parser = new Parser(tokens, factory);

        Node ast = parser.parse();

        Evaluator evaluator = new Evaluator();
        ast.accept(evaluator);

        System.out.println(evaluator.getResult()); // should print 3
    }
}
