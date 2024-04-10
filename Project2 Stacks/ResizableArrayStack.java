import java.util.Arrays;
import java.util.EmptyStackException;

/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class ResizableArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ResizableArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public ResizableArrayStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      integrityOK = true;
  } // end constructor
  
/** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry){
      checkIntegrity();

      if(isEmpty()){
      topIndex=1;
      } else{
      topIndex++;
      }

      if(topIndex<stack.length){
      stack[topIndex]=newEntry;
      }
   }
  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop(){
      checkIntegrity();
      checkEmpty();
      T entry = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return entry;
   }
  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek(){
      checkIntegrity();
      checkEmpty();
      return stack[topIndex];
   }
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty(){
      checkIntegrity();
      return topIndex<=0;
   }
  
   /** Removes all entries from this stack. */
   public void clear(){
      checkIntegrity();
      checkEmpty();
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[stack.length];
      stack = tempStack;
      topIndex=0;
   }

private void ensureCapacity(){
if (topIndex >= stack.length - 1) // If array is full, double its size
{
int newLength = 2 * stack.length;
checkCapacity(newLength);
stack = Arrays.copyOf(stack, newLength);
} // end if
}
   
private void checkCapacity(int capacity){
   if(capacity>MAX_CAPACITY)
   throw new IllegalStateException("Error, trying to create an ArrayStack that is bigger than the maximum allowed size");
}

private void checkIntegrity(){
   if(!integrityOK)
   throw new SecurityException("Integrity of program is compromised");
}

private void checkEmpty(){
   if(isEmpty())
   throw new EmptyStackException();
}


} // end ArrayStack
