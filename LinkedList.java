/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class LinkedList{
    private Node head;

    public void prepend(int data){
        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
    }
    
    public void append(int data){
        Node newNode = new Node(data);
        if (this.head == null){
            this.head = newNode;
            return;
        } else {
            Node head = this.head;
            while(head.getNext() != null){
                head = head.getNext();
            }
            head.setNext(newNode);
        }
    }

    public void delete(int value) {
        Node current = this.head;
        Node previous = null;
    
        // Check if the head node itself holds the value to be deleted
        if (current != null && current.getData() == value) {
            this.head = current.getNext(); // Change head
            return;
        }
    
        // Search for the value to be deleted, keep track of the previous node
        while (current != null && current.getData() != value) {
            previous = current;
            current = current.getNext();
        }
    
        // If the value was not present in the list
        if (current == null) {
            return;
        }
    
        // Unlink the node from the linked list
        previous.setNext(current.getNext());
    }

    public boolean search(int value){
        Node current = this.head;
        System.out.println("Searching................");
        while (current != null){
            if (current.getData() == value){
                System.out.println(value + " Found!");
                return true;
            }
            current = current.getNext();
        }
        System.out.println(value + " Not Found!");
        return false;
    }
    
    public void display(){
        Node current = this.head;
        while (current != null){
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("End");
    }

    public Node getMiddle(Node head){
        if (head == null){
            return head;
        }
        Node back = head, front = head;
        while (front.getNext() != null && front.getNext().getNext() != null){
            back = back.getNext();
            front = front.getNext().getNext();
        }
        return back;
     }

     // Reverse the linked list
    public void reverse() {
        Node prev = null, current = this.head, next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        this.head = prev;
    }

     // Sorting Algorithms

     // Sort the linked list using Merge Sort
    public void sort() {
        this.head = mergeSort(this.head);
    }

    private Node mergeSort(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.getNext();
        middle.setNext(null);

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    private Node sortedMerge(Node a, Node b) {
        Node result;
        if (a == null) return b;
        if (b == null) return a;
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b)); 
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

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