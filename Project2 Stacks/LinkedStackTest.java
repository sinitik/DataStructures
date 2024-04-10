import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Class to test LinkedStack implementation and features
 * Checks the infixExpression provided from Task1 for verification
 * @author Sean Sang
 * @version 1.0
 */

public class LinkedStackTest 
{

    // Unit testing infixToPostfix method
    @Test
    public void infixtoPostfix() {
        LinkedStack exp = new LinkedStack<>();


        String infix = "a*b/(c-a)+d*e";
        assertEquals("ab*ca-/de*+", exp.convertToPostfix(infix));
    }

    @Test
    public void infixtoPostfix2() {
        LinkedStack exp = new LinkedStack<>();

        String infix = "(4+2) * 3-5";
        assertEquals("42+3*5-", exp.convertToPostfix(infix));

    }



    public static void main(String[] args) {

    // Given infixExpression from Task 1.
    String infixExp = "a*b/(c-a)+d*e";    
    String infixExp2 = "(4+2) * 3-5";
    // infixExp to postFix = ab*ca-/de*+
    // infixExp2 to postFix = 42+3*5-
            
        
    String postfixExp = new LinkedStack<>().convertToPostfix(infixExp);
    System.out.println();
    System.out.println("This is the infix expression: " + infixExp);
    System.out.println("This is the postfix expression: " + postfixExp);
    System.out.println();

    String postfixExp2 = new LinkedStack<>().convertToPostfix(infixExp2);
    System.out.println("This is the infix2 expression: " + infixExp2);
    System.out.println("This is the postfix expression: " + postfixExp2);
    
    System.out.println();
    LinkedStack<Integer> stack = new LinkedStack<>();
    System.out.println("This is the Integer Stack");
    System.out.println("Adding a int '1' to the Integer LinkedStack");
    stack.push(1);
    System.out.println("This is currently at the top of the Integer stack: " + stack.peek());
    System.out.println("Adding a int '5' to the Integer LinkedStack");
    stack.push(5);
    System.out.println("This is currently at the top of the Integer stack: " + stack.peek());
    System.out.println("Our stack is " + stack.getSize() + " elements tall");
    System.out.print("Removing off the top of the stack, currently at the top of the stack: " + stack.pop() + "\n");
    // stack.peek();
    System.out.println("Is the stack currently empty?: " + stack.isEmpty());
    System.out.println("Running the clear function... ");
    stack.clear();
    System.out.println("Is the stack currently empty?: " + stack.isEmpty());

    System.out.println();
    StackInterface<String> stack2 = new LinkedStack<>();
    System.out.println("Adding a string 'Hello!' to the String LinkedStack");
    stack2.push("Hello!");
    System.out.println("This is currently at the top of the stack: " + stack2.peek());


    /* Final pop tests the EmptyStackException since there is nothing  
     * else to pop in the stack.
     */
    stack.pop();

}
}
