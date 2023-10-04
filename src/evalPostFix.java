import java.util.Stack;

public class evalPostFix {
    public static void main(String[] args) {
        //System.out.println(calculatePostFix("235*-"));
        //System.out.println(calculatePreFix("-*532"));
        //System.out.println(infixToPostFix("(2+3)*(3-2)"));
    }
    static double calculatePostFix(String expression){
        Stack<String> stack = new Stack<>();
        for (char character: expression.toCharArray()) {

            if (!(character == '+' || character== '-'|| character=='*'|| character=='/')) {
                // a number
                stack.push(String.valueOf(character));
            }else {
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());
                double result =0;
                if (character =='+'){
                    result =operand1+operand2;
                }else if (character =='-'){
                    result =operand1-operand2;
                }else if (character =='*'){
                    result =operand1*operand2;
                }else if (character =='/'){
                    result =operand1/operand2;
                }
                stack.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(stack.pop());
    }

    static double calculatePreFix(String expression){
        Stack<String> stack = new Stack<>();

        // prefix expressions are evaluated from right to left
        char[] charArray = expression.toCharArray();
        for(int i =charArray.length-1; i>=0;i-- ){
            char character= charArray[i];
            if (!(character == '+' || character== '-'|| character=='*'|| character=='/')) {
                // a number
                stack.push(String.valueOf(character));
            }else {
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());
                double result =0;
                if (character =='+'){
                    result =operand1+operand2;
                }else if (character =='-'){
                    result =operand1-operand2;
                }else if (character =='*'){
                    result =operand1*operand2;
                }else if (character =='/'){
                    result =operand1/operand2;
                }
                stack.push(String.valueOf(result));
            }

        }
        return Double.parseDouble(stack.pop());
    }

    static String infixToPostFix(String expression){
        /*
        * if operand add to the end of the postfix
        * if ( add to the stack
        * if ) pop until ( is found and discard both ( and)
        * if operator level is higher than what is in the stack pop its level or higher except ( and push to the stack
        * + or - pop until ( or empty and add
        * * or / pop until = or- or (
        *finally empty the stack by adding to the postfix
        * */
        Stack<Character> stack = new Stack<>();
        expression = expression;

        String postFix = "";
        for (char character:expression.toCharArray()) {
            if(character=='('){
                stack.push(character);
            }else if(character == '+'||character=='-'||character=='/'||character=='*'){
                if(stack.isEmpty()){
                    stack.push(character);
                }else if(character=='+' || character == '-'){
                    while (!stack.isEmpty() && stack.peek() !='(') {
                        postFix = postFix + stack.pop();
                    }
                    stack.push(character);

                }else if(character=='*' || character == '/'){
                    // if same level of order is given
                        while(!stack.isEmpty() && stack.peek()!='+' && stack.peek()!='-' && stack.peek()!='('){
                            postFix =postFix + stack.pop();
                        }
                        stack.push(character);
                }
            }else if (character==')'){
                while (stack.peek()!='('){
                    postFix=postFix+stack.pop();
                }
                stack.pop();
            }else {
                postFix = postFix+character;
            }
        }
        while (!stack.isEmpty()){
            postFix =postFix+stack.pop();
        }
        return postFix;
    }
}
//todo : infix to postfix vise versa prefix to infix , prefix to postfix
