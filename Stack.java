public class Stack {
    private Node top; // This variable holds the top node of the stack

    // Constructor initializes the stack to be empty
    public Stack() {
        this.top = null;
    }

    // Method to push a node onto the stack
    public void push(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        newNode.setNext(top); // Set the new node's next link to the current top
        top = newNode; // Update the top to be the new node
    }

    // Method to pop a node from the stack
    public int pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.getData(); // Get data from the top node
        top = top.getNext(); // Move the top to the next node in the stack
        return data; // Return the data
    }

    // Method to peek at the top node of the stack without removing it
    public int peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData(); // Return the data of the top node
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null; // Return true if the top is null
    }

    // Method to display the contents of the stack
    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}

