/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class Node{
    private int data;
    private Node next;

    // Constructor
    // It takes the data 
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    // Getters and setters 
    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }
}