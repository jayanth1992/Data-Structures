import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); position++) {
            char curr = text.charAt(position);

            if (curr == '(' || curr == '[' || curr == '{') {
                Bracket bracket = new Bracket(curr, position+1);
                opening_brackets_stack.push(bracket);
            }

            if (curr == ')' || curr == ']' || curr == '}') {
                if (opening_brackets_stack.isEmpty()) {
                    System.out.println(position+1);
                    return;
                }

                Bracket prev = opening_brackets_stack.peek();

                if (prev.Match(curr)) {
                    opening_brackets_stack.pop();
                } else {
                    System.out.println(position+1);
                    return;
                }
            }

        }

        if (!opening_brackets_stack.isEmpty()){
            System.out.println(opening_brackets_stack.firstElement().position);
            return;
        }

        System.out.println("Success");

    }
}

