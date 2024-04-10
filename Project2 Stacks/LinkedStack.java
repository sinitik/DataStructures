import java.util.EmptyStackException;

/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Sean Sang
    @version 1.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
    private Node<T> topNode; // References the first node in the chain
    private int size; // Keeping overall size of stack
   
    /**
    * Default size of constructor is set to 0.
    */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }

    /**
    * @return Returns the size of the stack. Currently size++ is part of push() and size-- of pop().
    * the constructor sets the default to 0.
    */
    public int getSize()
    {
       return size;
    }

   /**
    * Adds a new element to the top of the stack.
    * @param newEntry is the new element to be added.
    */
    @Override
    public void push(T newEntry)
    {

      Node<T> newNode = new Node<>(newEntry);
      newNode.setNextNode(topNode);
      topNode = newNode;
      size++;

    }
    /**
    * Removes the element on the top of the stack
    * @throws EmptyStackException() if the stack is empty when the method is called.
    */
    @Override
    public T pop()

    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T popped = topNode.getData(); // Store the popped element
        topNode = topNode.getNextNode(); // Update the top node
        size--;
        return popped; // Return the stored element
    }
    /**
    * Returns the element on the top of the stack
    * @throws EmptyStackException() if the stack is empty when the method is called.
    */
    @Override
    public T peek()
    {
      if (isEmpty())
      {
        throw new EmptyStackException();
      }
      return topNode.getData();
    }

    /**
    * Checks if there is anything in the top node
    * @return If true that it is null, then it is empty, if false then there is at least one element
    * @throws EmptyStackException() if the stack is empty when the method is called.
    */
    @Override
    public boolean isEmpty()
    {
      return (topNode == null);
    }

    /**
    * If it returns that it is not empty, it will continue running pop() until it is empty.
    * @throws EmptyStackException() if the stack is empty when the method is called.
    */
    @Override
    public void clear()
    {
      if(!isEmpty())
      {
         pop();
      }
      else 
      {
         throw new EmptyStackException();
      }
    }

    /**
    * Algorithm to sort through a infix operation and turn it into
    * a postfix operation using the previously created LinkedStack methods
    * @param infix Inputs a String infix operation
    * @return Returns a converted postfix operation
    */
    public String convertToPostfix(String infix) {
    
    LinkedStack<Character> operationStack = new LinkedStack<>();

    // Using StringBuilder to keep the String mutable for append and pop().
    // postfix as an empty String, per textbook
    StringBuilder postfix = new StringBuilder();
    
    // Switch case statement for removing spaces and parantheses.
    for (char nextChar : infix.toCharArray()) { // Enhanced for-loop to go through the infix char array
         switch (nextChar) { // Switch case to sort through OOP.
            case ' ': // Ignores the space characters
                break;
            case '(': // Adds lhs parantheses to the stack
                operationStack.push(nextChar);
                break;
            case ')': // Uses the pop() method to remove closing parantheses brackets, verifies 
                       // the stack is not empty or a lhs parantheses
                while (operationStack.peek() != '(' && !operationStack.isEmpty()) {
                    postfix.append(operationStack.pop());
                }
                operationStack.pop(); 
                break; 
            case '+': case '-': case '*': case '/': case '^': // When encountering operations, follows OOP method orderPrecedence
                                                                // orderPrecedence has specific operations provide an int value to 
                                                                // create a value-based order to sort the postfix String
                while (!operationStack.isEmpty() && orderPrecedence(nextChar) <= orderPrecedence(operationStack.peek())) {
                     postfix.append(operationStack.pop());
                }
                operationStack.push(nextChar);
                break; // Adds operation to stack through push(newEntry/nextChar) method.
             default: // Otherwise adds nextChar to the end of the String
                postfix.append(nextChar); 
                break; 
         }
     }
    // Leftover operators will continue being popped from the initial 
    // String, being added to the newly converted Postfix String.
    while (!operationStack.isEmpty()) {
        postfix.append(operationStack.pop());
    } 
      
    // Returns the postfix sorted String
    return postfix.toString();
  }
  /**Order of operations used in conjunction with converToPostfix
   * When encountering an operator it provides a int value to make a
   * value-based order to sort the Postfix string.
   * @param operation convertToPostfix has operators placed in this method during its enhanced for-loop.
   * @return returns an int value based on the operator through its switch statement.
   */
  private int orderPrecedence(char operation) {
      switch (operation) {
          case '+': case '-':
              return 1;
          case '*': case '/':
              return 2;
          case '^':
              return 3;
          default:
              return 0;
      }
  }

	private static class Node<T>
	{
      private T data; // Entry in stack
      private Node<T> next; // Link to next node
      
      private Node(T data)
      {
         this.data = data;
         this.next = null;
      } // end constructor
   
      public T getData()
      {
         return data;
      } // end getData

      private Node<T> getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node<T> nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedStack
