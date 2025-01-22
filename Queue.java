/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class Queue {
    private Node front; // Reference to the front node of the queue, where elements are dequeued.
    private Node rear; // Reference to the rear node of the queue, where elements are enqueued.

    /**
     * Constructor for initializing an empty queue.
     */
    public Queue() {
        this.front = null; // Initially, there are no elements, so front is set to null.
        this.rear = null; // Initially, there are no elements, so rear is also set to null.
    }

    /**
     * Adds a new node with specified data to the end of the queue.
     * 
     * @param data The data to be added to the queue.
     */
    public void enqueue(int data) {
        Node newNode = new Node(data); // Create a new node with the given data.
        if (rear == null) {
            // If the queue is empty, this new node becomes both the front and the rear.
            front = rear = newNode;
        } else {
            // Otherwise, link the current rear node to this new node and update the rear
            // reference.
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    /**
     * Removes and returns the data from the front node of the queue.
     * 
     * @return The data from the node that was dequeued.
     * @throws IllegalStateException if the queue is empty.
     */
    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty"); // Throw exception if the queue is empty.
        }
        int data = front.getData(); // Retrieve data from the front node.
        front = front.getNext(); // Move the front pointer to the next node in the queue.
        if (front == null) {
            rear = null; // If the queue becomes empty after dequeuing, update rear to null.
        }
        return data; // Return the data of the dequeued node.
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return front == null; // Return true if the front is null, indicating the queue is empty.
    }

    /**
     * Retrieves, but does not remove, the data from the front of the queue.
     * 
     * @return The data at the front of the queue.
     * @throws IllegalStateException if the queue is empty.
     */
    public int peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty"); // Ensure there's at least one node.
        }
        return front.getData(); // Return the data from the front node.
    }

    /**
     * Displays all elements in the queue from front to rear.
     */
    public void display() {
        Node current = front; // Start traversal from the front.
        while (current != null) {
            System.out.print(current.getData() + " -> "); // Print each node's data.
            current = current.getNext(); // Move to the next node.
        }
        System.out.println("null"); // Mark the end of the queue visually.
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Test isEmpty on an empty queue
        System.out.println("Queue should be empty: " + queue.isEmpty());

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the queue after enqueues
        System.out.print("Queue after enqueues: ");
        queue.display();

        // Test peek method
        System.out.println("Peek front item (should be 10): " + queue.peek());

        // Dequeue elements and display the queue
        System.out.println("Dequeued (should be 10): " + queue.dequeue());
        System.out.print("Queue after one dequeue: ");
        queue.display();

        // Continue to dequeue
        System.out.println("Dequeued (should be 20): " + queue.dequeue());
        System.out.println("Dequeued (should be 30): " + queue.dequeue());

        // Try to dequeue from an empty queue to see error handling
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Expected error on dequeue from empty queue: " + e.getMessage());
        }

        // Check if the queue is empty after all dequeues
        System.out.println("Queue should be empty now: " + queue.isEmpty());

        // Enqueue and dequeue again to ensure queue can be reused
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.print("Queue after re-enqueue: ");
        queue.display();

        // Check peek and isEmpty again
        System.out.println("Peek front item (should be 40): " + queue.peek());
        System.out.println("Queue should not be empty: " + !queue.isEmpty());

        // Display final state of the queue
        System.out.print("Final state of queue: ");
        queue.display();
    }
}
