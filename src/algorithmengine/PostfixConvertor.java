package algorithmengine;

import java.io.*;

/*
    PostfixConvertor class converts the expression from infix to postfix 
    notation. The class uses convert, getOperator, and getParenthesis methods
    in order to return the postfix expression.
*/
class PostfixConvertor {
    private OperatorStack operatorStack;
    private String input;
    private String output = "";

    public PostfixConvertor(String userInput)
    {
        input = userInput;
        int stackSize = input.length();
        operatorStack = new OperatorStack(stackSize);
    }

    /*
        Method convert sets precedent of each user input character based on 
        order of operations. Method continues as long as the stack is not 
        empty. 
    */
    public String convert()
    {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    getOperator(ch, 1);
                    output = output + ' ';
                    break;
                case '*': 
                case '/':
                case '%':
                    getOperator(ch, 2);
                    output = output + ' '; 
                    break; 
                case '^': 
                    getOperator(ch, 3);
                    output = output + ' ';
                    break;
                case '(': 
                    operatorStack.push(ch);
                    break;
                case ')':
                    getParenthesis(ch); 
                    break;
                default:
                    output = output + ch;
                    break;
            } 
        } 
        while(!operatorStack.isEmpty())
        {
            output = output + operatorStack.pop();
        }
        return output;
    } 

    /*
        Method getOperator pushes operators to stack based on order of 
        operations.
        Input: currentOperator (character) and precedent1 (integer)
    */
    public void getOperator(char currentOperator, int precedent1) {
        while (!operatorStack.isEmpty()) {
            char operatorTop = operatorStack.pop();
            if (operatorTop == '(')
            {
                operatorStack.push(operatorTop);
                break;
            } else
            {
                int precedent2;
                if (operatorTop == '+' || operatorTop == '-')
                {
                    precedent2 = 1;
                } else {
                    precedent2 = 2;
                }
                if (precedent2 < precedent1) 
                {
                    operatorStack.push(operatorTop); 
                    break;
                } else 
                {
                    output = output + operatorTop; 
                }
            } 
        } 
        operatorStack.push(currentOperator);
    }

    /*
        Method getParenthesis pops operators from the stack until  th opening 
        parenthesis is popped. 
    */
    public void getParenthesis(char ch) { 
        while (!operatorStack.isEmpty()) {
            char currentChar = operatorStack.pop();
            if (currentChar == '(')
            {
                break;
            } else
            {
                output = output + currentChar;
            }
        }
    }    
}
