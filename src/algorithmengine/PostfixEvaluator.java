package algorithmengine;

/*
    PostfixEvaluator class calculates the integer value of the expression. The 
    class uses the evaluate method in order to complete the calculation.
    Input: string of postfix expression (str)
    Returns: integer value 
*/
public class PostfixEvaluator {
    private OperandStack operandStack;
    private String input;

    public PostfixEvaluator(String str) {
        input = str;
        int stackSize = input.length();
        operandStack = new OperandStack(stackSize);
    }

    /*
        Method evaluate adds numerical character to OperandStack. If operand is 
        multidigits or a decimal, sets to true. The method calculates 
        intermediate values. Returns the final value of expression. 
    */
    public double evaluate() {
        char ch;
        double operand1, operand2, interAns;
        
        for (int j = 0; j < input.length(); j++)
        {
            ch = input.charAt(j); 
            if (ch >= '0' && ch <= '9')
            {
                operandStack.push((int) (ch - '0'));
            } else if (ch == ' ') {
                operandStack.multidigit = false;
                operandStack.inDecimal = false;
            } else if (ch == '.') {
                operandStack.decimalPlace = 0;
                operandStack.inDecimal = true;
                operandStack.multidigit = true;
            } else
            {
                if(operandStack.size() <= 1)
                {
                    System.out.println("Invalid input!");
                    System.exit(0);
                }
                else
                {
                    operandStack.multidigit = false; 
                    operand2 = operandStack.pop();
                    operand1 = operandStack.pop();
                    switch (ch)
                    {
                        case '+':
                            interAns = operand1 + operand2;
                            break;
                        case '-':
                            interAns = operand1 - operand2;
                            break;
                        case '*':
                            interAns = operand1 * operand2;
                            break;
                        case '/':
                            interAns = operand1 / operand2;
                            break;
                        case '%':
                            interAns = operand1 % operand2;
                            break;
                        case '^':
                            interAns = Math.pow(operand1, operand2);
                            break;
                        default:
                            interAns = 0;
                    } 
                    operandStack.push(interAns);
                }
            } 
        } 
        interAns = operandStack.pop();
        return interAns;
    }    
}
