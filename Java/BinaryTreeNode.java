package Java;

/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class BinaryTreeNode{
    private int data;
    BinaryTreeNode right;
    private BinaryTreeNode left;

    public BinaryTreeNode(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
    
    public int getData(){
        return data;
    }

     public void setData(int data){
        this.data = data;
     }

     public BinaryTreeNode getRight(){
        return right;
    }

     public void setRight(BinaryTreeNode right){
        this.right = right;
     }

     public BinaryTreeNode getLeft(){
        return left;
    }

     public void setLeft(BinaryTreeNode left){
        this.left = left;
     }

}
