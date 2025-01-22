package Java;

/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class LinkedList {
    private Node head; // Head pointer for the linked list.

    /**
     * Inserts a new node with the specified data at the beginning of the list.
     * @param data The integer data to store in the new node.
     */
    public void prepend(int data) {
        Node newNode = new Node(data); // Create a new node.
        newNode.setNext(this.head); // Link the new node to the current head.
        this.head = newNode; // Update the head to point to the new node.
    }

    /**
     * Appends a new node with the specified data to the end of the list.
     * @param data The integer data to store in the new node.
     */
    public void append(int data) {
        Node newNode = new Node(data); // Create a new node.
        if (this.head == null) { // If the list is empty, make this node the head.
            this.head = newNode;
            return;
        }
        Node current = this.head; // Start traversal from the head.
        while (current.getNext() != null) { // Traverse to the last node.
            current = current.getNext();
        }
        current.setNext(newNode); // Link the last node to the new node.
    }

    /**
     * Deletes the first occurrence of the node containing the specified value.
     * @param value The integer value to search for and delete.
     */
    public void delete(int value) {
        Node current = this.head, previous = null; // Start at the head.

        if (current != null && current.getData() == value) { // Check if head is the node to be deleted.
            this.head = current.getNext(); // Update head.
            return;
        }

        while (current != null && current.getData() != value) { // Traverse to find the value.
            previous = current;
            current = current.getNext();
        }

        if (current == null) { // Value not found in the list.
            return;
        }

        previous.setNext(current.getNext()); // Unlink the node from the list.
    }

    /**
     * Searches for an integer value in the linked list.
     * @param value The integer to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean search(int value) {
        Node current = this.head; // Start at the head.
        while (current != null) {
            if (current.getData() == value) { // Check if current node contains the value.
                return true;
            }
            current = current.getNext(); // Move to the next node.
        }
        return false; // Value not found.
    }

    /**
     * Displays all elements of the linked list.
     */
    public void display() {
        Node current = this.head; // Start at the head.
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    /**
     * Retrieves the middle node of the linked list.
     * Useful for operations like merge sort.
     * @return The middle node of the list.
     */
    public Node getMiddle(Node head) {
        if (head == null) {
            return null; // Return null if list is empty.
        }
        Node slow = head, fast = head; // Use two pointers.
        while (fast.getNext() != null && fast.getNext().getNext() != null) { // Fast moves twice as fast as slow.
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow; // Slow is at the middle when fast reaches the end.
    }

    /**
     * Reverses the linked list.
     */
    public void reverse() {
        Node prev = null, current = this.head, next = null;
        while (current != null) {
            next = current.getNext(); // Save next node.
            current.setNext(prev); // Reverse current node's pointer.
            prev = current; // Move pointers one position forward.
            current = next;
        }
        this.head = prev; // Update head to new front of the list.
    }

    /**
     * Sorts the linked list using Merge Sort algorithm.
     */
    public void sort() {
        this.head = mergeSort(this.head); // Begin merge sort on the list.
    }

    private Node mergeSort(Node head) {
        if (head == null || head.getNext() == null) {
            return head; // Base case: a list with 0 or 1 element is already sorted.
        }
        Node middle = getMiddle(head); // Find the middle.
        Node nextOfMiddle = middle.getNext(); // Split the list into two halves.
        middle.setNext(null);

        Node left = mergeSort(head); // Recursively sort the left half.
        Node right = mergeSort(nextOfMiddle); // Recursively sort the right half.

        return sortedMerge(left, right); // Merge the two halves together.
    }

    private Node sortedMerge(Node a, Node b) {
        Node result;
        if (a == null) return b; // If left half is empty, return right half.
        if (b == null) return a; // If right half is empty, return left half.

        // Pick either a or b, and recursively call sortedMerge for the next element.
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

    /**
     * Main method to demonstrate functionality.
     */
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(10);
        ll.append(50);
        ll.append(20);
        ll.append(40);
        ll.append(30);
    
        ll.display();
        ll.reverse();
        ll.display();
        ll.sort();
        ll.display();
    }
}
