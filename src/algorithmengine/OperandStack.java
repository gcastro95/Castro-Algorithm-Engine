package algorithmengine;

/*
    OperandStack creates a stack in which the operands will be stored during 
    the evaluation of the expression. The stack is initialized as a double
    array with a maximum size. Integer top refers to the top position in the 
    character array (an empty stack would have top = -1). 
*/
public class OperandStack {
    public int maxSize;
    private double[] stackArray;
    private int top;
    public boolean multidigit = false;  
    public boolean inDecimal = false;  
    public int decimalPlace = 0;       

    public OperandStack(int size) {
        maxSize = size;
        stackArray = new double[maxSize];
        top = -1;
    }

    /*
        Pop method removes element from top of the stack. 
        Returns: stack without top integer     
    */
    public double pop() {
        return stackArray[top--];
    }

    /*
        Push method adds a number to the top of the stack. Method takes into 
        consideration if number is multiple digits and/or a decimal. 
        Input: double 
        Returns: stack with number at the top    
    */
    public void push(double num) {
        /*
            Method checks if number is multidigit or a decimal. If number is 
            part of a multiple digit number, then the previous digit is removed 
            from the stack and set variable name to previousDigit. If number is
            a decimal, then method divides current element by 10 to create a 
            decimal value and adds this to previous digit. If number is multiple
            digits then it is added to 10 times the previous digit. 
        */
        if (multidigit) { 
            double previousDigit; 
            previousDigit = pop();
            if (inDecimal) {
                decimalPlace++; 
                stackArray[++top] = num/((int)Math.pow(10,decimalPlace)) + previousDigit;
            } else {
                stackArray[++top] = num + 10 * previousDigit; 
            }
        } else if (!multidigit) {
            stackArray[++top] = num;
            multidigit = true;
        }
    }

    /*
        Peek method identifies top element in the stack. 
        Returns: top element from the stack    
    */
    public double peek() {
        return stackArray[top];
    }

    /*
        Method isEmpty determines if the stack is empty. 
        Returns: true if stack is empty   
    */
    public boolean isEmpty() {
        return (top == -1);
    }

    /*
        Method isFmpty determines if the stack is full. 
        Returns: true if stack is full   
    */
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    /*
        Size method determines the size of the stack. 
        Returns: size of stack as an integer    
    */
    public int size() {
        return top + 1;
    }

    /*
        PeekN method identifies element at position n in the stack. 
        Returns: element from position n in the stack    
    */
    public double peekN(int n) {
        return stackArray[n];
    } 
}
