package algorithmengine;

/* 
Program: AlgorithEngine
Author:  Grace Castro
Desc:  AlgorithmEngine computes the integer value of an arithmetic statement. 
       Users input an infix notation statement. The program converts the 
       expression to postfix notation then evaluates the expression. 
Usage: The user types in an expression. The following operators may be used: 
       +, -, *, /, ^, and %. The operands must be greater than 0. (Note: any 
       operand greater than 0 and less than 1 must be represented with a "0" 
       before the value. 
*/

import java.io.*;

public class AlgorithmEngine {

/*
    Method continues to run program as long as the user input is valid. Prompts 
    user to input an input expression as a string. If input is valid, the 
    program converts and evaluates the expression. 
    User input: inputStr
    Returns: outputInt
*/    
    public static void main(String[] args) throws IOException {
        String inputStr, outputStr;
        double outputInt;

        while (true) {
            System.out.print("Enter infix expression: ");
            System.out.flush();
            inputStr = getString();
            if (inputStr.equals(" ")) { 
                break;
            }
            PostfixConvertor convertor = new PostfixConvertor(inputStr);
            outputStr = convertor.convert();
            System.out.println("Postfix expression is " + outputStr);

            PostfixEvaluator evaluator = new PostfixEvaluator(outputStr);             
            outputInt = evaluator.evaluate();
            System.out.println("Evaluates to " + outputInt + '\n');
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        return str;
    }
}
