public class Parser {
    public static void main(String[] args) {
        /*System.out.println(eval("123"));
        System.out.println(eval("2*3"));
        System.out.println(eval("2*(1+3)"));
        System.out.println(eval("1+(5-2*(13/6))"));*/

        /*System.out.println(">> 123 = " + lab_18.Parser.eval("123"));
        System.out.println(">> 2*3 = " + lab_18.Parser.eval("2*3"));
        System.out.println(">> 2*(1+3) = " + lab_18.Parser.eval("2*(1+3)"));
        System.out.println(">> 1+(5-2*(13/6)) = " + lab_18.Parser.eval("1+(5-2*(13/6))"));*/

        System.out.println(">> 123 = " + Parser.eval("123"));
        System.out.println(">> 2*3 = " + Parser.eval("2*3"));
        System.out.println(">> (1+3)*2 = " + Parser.eval("(1+3)*2"));
        System.out.println(">> ((13/6)*2-5)+1 = " + Parser.eval("((13/6)*2-5)+1"));
        System.out.println(">> 333-123 = " + Parser.eval("333-123"));

    }

    public static int eval(String expr) {
        return eval(expr, 0, expr.length() - 1);
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(to) == ')') {
            return eval(expr, from + 1, to - 1);
        } else {
            int pos = to;
            while (pos > from) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos--;
                } else {
                    int rightOperand = Integer.valueOf(expr.substring(pos + 1, to + 1));
                    char operation = expr.charAt(pos);
                    int leftOperand = eval(expr, from, pos - 1);
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(from, to + 1));
        }
    }
}