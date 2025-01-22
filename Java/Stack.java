package Java;

/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class Stack {
    private Node top; // Holds the top node of the stack, which is the last node that was pushed.

    /**
     * Constructor initializes the stack to be empty by setting the top to null.
     */
    public Stack() {
        this.top = null;
    }

    /**
     * Pushes a new node with the specified data onto the stack.
     * @param data The integer data to be stored in the new node.
     */
    public void push(int data) {
        Node newNode = new Node(data); // Create a new node.
        newNode.setNext(top); // The new node's next pointer points to the current top.
        top = newNode; // The top of the stack is updated to the new node.
    }

    /**
     * Pops the top node from the stack and returns its data.
     * @return The data from the top node.
     * @throws IllegalStateException if the stack is empty.
     */
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty"); // Throw exception if the stack is empty.
        }
        int data = top.getData(); // Retrieve data from the top node.
        top = top.getNext(); // Set the top to the next node down the stack.
        return data; // Return the retrieved data.
    }

    /**
     * Returns the data from the top node without removing it from the stack.
     * @return The data from the top node.
     * @throws IllegalStateException if the stack is empty.
     */
    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty"); // Throw exception if the stack is empty.
        }
        return top.getData(); // Return the data of the top node.
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == null; // Return true if there is no top node, indicating the stack is empty.
    }

    /**
     * Displays all elements of the stack from top to bottom.
     */
    public void display() {
        Node current = top; // Start from the top.
        while (current != null) {
            System.out.print(current.getData() + " -> "); // Print each node's data followed by '->'.
            current = current.getNext(); // Move to the next node down the stack.
        }
        System.out.println("null"); // Indicate the end of the stack.
    }

    /**
     * Main method to demonstrate and test stack functionalities.
     */
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Test isEmpty on an empty stack
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack after pushes
        System.out.print("Current Stack: ");
        stack.display();

        // Peek the top element
        System.out.println("Top element (should be 30): " + stack.peek());

        // Pop elements and show stack state
        System.out.println("Popped (should be 30): " + stack.pop());
        System.out.print("Stack after one pop: ");
        stack.display();

        // Continue popping
        System.out.println("Popped (should be 20): " + stack.pop());
        System.out.println("Popped (should be 10): " + stack.pop());

        // Check if stack is empty after pops
        System.out.println("Is the stack empty after all pops? " + stack.isEmpty());

        // Attempt to pop from an empty stack to check error handling
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Expected exception for popping from empty stack: " + e.getMessage());
        }

        // Re-push elements to check stack reusability
        stack.push(40);
        stack.push(50);

        // Display final state of the stack
        System.out.print("Final Stack: ");
        stack.display();
    }
}

