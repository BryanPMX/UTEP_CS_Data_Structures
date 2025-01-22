package Java;

/*

  University of Texas at El Paso, Department of Computer Science.

  Contributor: Bryan Perez
  
*/

public class BinarySearchTree {
    private BinaryTreeNode root; // The root node of the binary tree.

    /**
     * Constructor to create an empty binary tree.
     */
    public BinarySearchTree() {
        this.root = null; // Initially, the tree has no nodes.
    }

    /**
     * Inserts a new node with the specified data into the binary tree following binary search tree rules.
     * @param data The integer value to insert into the tree.
     */
    public void insert(int data) {
        BinaryTreeNode newNode = new BinaryTreeNode(data); // Create a new node with the given data.
        if (root == null) {
            root = newNode; // If the tree is empty, set the new node as the root.
        } else {
            BinaryTreeNode temp = root; // Start from the root.
            BinaryTreeNode parent;
            while (true) {
                parent = temp;
                if (data < temp.getData()) { // Decide to go to the left subtree if data is less than current node's data.
                    temp = temp.getLeft();
                    if (temp == null) {
                        parent.setLeft(newNode); // Insert new node at the left of the parent.
                        return;
                    }
                } else { // Decide to go to the right subtree if data is greater or equal to current node's data.
                    temp = temp.getRight();
                    if (temp == null) {
                        parent.setRight(newNode); // Insert new node at the right of the parent.
                        return;
                    }
                }
            }
        }
    }

    /**
     * Performs preorder traversal of the binary tree starting from a given node.
     * @param node The starting node for the preorder traversal.
     */
    public void preorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " "); // Process the root node first.
            preorderTraversal(node.getLeft()); // Recursively traverse the left subtree.
            preorderTraversal(node.getRight()); // Recursively traverse the right subtree.
        }
    }

    /**
     * Performs inorder traversal of the binary tree starting from a given node.
     * @param node The starting node for the inorder traversal.
     */
    public void inorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inorderTraversal(node.getLeft()); // Recursively traverse the left subtree.
            System.out.print(node.getData() + " "); // Process the root node.
            inorderTraversal(node.getRight()); // Recursively traverse the right subtree.
        }
    }

    /**
     * Performs postorder traversal of the binary tree starting from a given node.
     * @param node The starting node for the postorder traversal.
     */
    public void postorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postorderTraversal(node.getLeft()); // Recursively traverse the left subtree.
            postorderTraversal(node.getRight()); // Recursively traverse the right subtree.
            System.out.print(node.getData() + " "); // Process the root node last.
        }
    }

    /**
     * Helper method to start the tree traversal from the root based on the specified type.
     * @param type The type of traversal to perform ("preorder", "inorder", "postorder").
     */
    public void traverse(String type) {
        switch (type) {
            case "preorder":
                System.out.println("Preorder traversal:");
                preorderTraversal(root); // Perform preorder traversal starting from the root.
                break;
            case "inorder":
                System.out.println("Inorder traversal:");
                inorderTraversal(root); // Perform inorder traversal starting from the root.
                break;
            case "postorder":
                System.out.println("Postorder traversal:");
                postorderTraversal(root); // Perform postorder traversal starting from the root.
                break;
            default:
                System.out.println("Invalid traversal type");
        }
        System.out.println(); // Print a new line after the traversal.
    }

    /**
     * Main method to demonstrate the functionality of the BinaryTree class.
     */
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        // Insert nodes into the binary tree.
        bt.insert(50);
        bt.insert(30);
        bt.insert(70);
        bt.insert(20);
        bt.insert(40);
        bt.insert(60);
        bt.insert(80);

        // Perform and display different types of traversals.
        bt.traverse("preorder");
        bt.traverse("inorder");
        bt.traverse("postorder");
    }
}
