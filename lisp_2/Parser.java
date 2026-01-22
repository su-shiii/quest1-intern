package lisp_2;

import java.util.ArrayList;
import java.util.List;

import lisp_2.node.Node;
import lisp_2.node.Factory;

public class Parser {

    private final List<String> tokens;
    private int position;
    private final Factory factory;

    public Parser(List<String> tokens, Factory factory) {
        this.tokens = tokens;
        this.factory = factory;
        this.position = 0;
    }

    public Node parse() {
        return parseExpression();
    }

    private Node parseExpression() {

        String token = tokens.get(position);

        if (token.equals("(")) {
            position++; // skip opening bracket
            List<Node> elements = new ArrayList<>();

            while (!tokens.get(position).equals(")")) {
                elements.add(parseExpression());
            }

            position++; //skip closing paren
            return factory.createList(elements);
        }

        //no
        else if (isNumber(token)) {
            position++;
            return factory.createNumber(Integer.parseInt(token));
        }

        //non-number
        else {
            position++;
            return factory.createSymbol(token);
        }
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
