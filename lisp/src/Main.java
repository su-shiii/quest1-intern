package lisp.src;

import java.util.List;
import java.util.Scanner;

import lisp.src.input_parsing.Parser;
import lisp.src.input_parsing.Tokenizer;
import lisp.src.node.Factory;
import lisp.src.node.Node;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Factory factory = new Factory();
        Evaluator evaluator = new Evaluator(); // reuse → memory works

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().trim();

            // exit condition
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("EXITED LISP INTERPRETEDR");
                break;
            }

          

            try {
                List<String> tokens = Tokenizer.tokenize(input);
                Parser parser = new Parser(tokens, factory);

                Node ast = parser.parse();

                Object result = ast.accept(evaluator);
                System.out.println(result);

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
