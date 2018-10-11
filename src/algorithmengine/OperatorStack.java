package algorithmengine;

/*
    OperatorStack creates a stack in which the operators will be stored during 
    the conversion of the expression. The stack is initialized as a character
    array with a maximum size. Integer top refers to the top position in the 
    character array (an empty stack would have top = -1). 
*/

public class OperatorStack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public OperatorStack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    /*
        Push method adds a character to the top of the stack. 
        Input: character
        Returns: stack with input character at the top    
    */
    public void push(char inputChar) {
        stackArray[++top] = inputChar;
    }

    /*
        Pop method removes character from top of the stack. 
        Returns: stack without top charater     
    */
    public char pop() { 
        return stackArray[top--];
    }

    /*
        Peek method identifies last inputed character to the stack. 
        Returns: top character from the stack    
    */
    public char peek() {
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
        Size method determines the size of the stack. 
        Returns: size of stack as an integer    
    */
    public int size() {
        return top + 1;
    }

    /*
        PeekN method identifies element at position n in the stack. 
        Returns: character from position n in the stack    
    */
    public char peekN(int n) {
        return stackArray[n];
    }
}
