/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Insert data into the binary tree at the first available position
    public void insert(int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data);
        if (root == null) {
            root = newNode;
        } else {
            BinaryTreeNode temp = root;
            BinaryTreeNode parent;
            while (true) {
                parent = temp;
                if (data < temp.getData()) { // left subtree
                    temp = temp.getLeft();
                    if (temp == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else { // right subtree
                    temp = temp.getRight();
                    if (temp == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    // Preorder traversal: Root, Left, Right
    public void preorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }

    // Inorder traversal: Left, Root, Right
    public void inorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversal(node.getRight());
        }
    }

    // Postorder traversal: Left, Right, Root
    public void postorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    // Helper method to start the traversal from the root
    public void traverse(String type) {
        switch (type) {
            case "preorder":
                System.out.println("Preorder traversal:");
                preorderTraversal(root);
                break;
            case "inorder":
                System.out.println("Inorder traversal:");
                inorderTraversal(root);
                break;
            case "postorder":
                System.out.println("Postorder traversal:");
                postorderTraversal(root);
                break;
            default:
                System.out.println("Invalid traversal type");
        }
        System.out.println(); // Move to next line after traversal
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(30);
        bt.insert(70);
        bt.insert(20);
        bt.insert(40);
        bt.insert(60);
        bt.insert(80);

        bt.traverse("preorder");
        bt.traverse("inorder");
        bt.traverse("postorder");
    }
}
