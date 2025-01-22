public class Queue {
    private Node front; // This variable holds the front node of the queue
    private Node rear; // This variable holds the rear node of the queue

    // Constructor initializes an empty queue
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Method to add a node to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (rear == null) {
            front = rear = newNode; // If the queue is empty, both front and rear are the new node
            return;
        }
        rear.setNext(newNode); // Link the current rear to the new node
        rear = newNode; // Update the rear to the new node
    }

    // Method to remove a node from the front of the queue
    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.getData(); // Get data from the front node
        front = front.getNext(); // Move the front to the next node
        if (front == null) {
            rear = null; // If the queue is now empty, set the rear to null as well
        }
        return data; // Return the data
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null; // Return true if the front is null
    }

    // Method to peek at the front node of the queue without removing it
    public int peek() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.getData(); // Return the data of the front node
    }

    // Method to display the contents of the queue
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
