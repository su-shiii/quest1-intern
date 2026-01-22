package lisp_2;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();

        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
            }
            else if (c == '(' || c == ')') {
                tokens.add(String.valueOf(c));
                i++;
            }
            else {
                StringBuilder sb = new StringBuilder();
                while (i < input.length()
                        && !Character.isWhitespace(input.charAt(i))
                        && input.charAt(i) != '('
                        && input.charAt(i) != ')') {
                    sb.append(input.charAt(i));
                    i++;
                }
                tokens.add(sb.toString());
            }
        }

        return tokens;
    }
}
