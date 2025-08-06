import java.util.*;

public class BST {

    
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    
    static class BinarySearchTree {
        Node root;

        BinarySearchTree() {
            root = null;
        }

    
        public void insert(int key) {
            root = insertRec(root, key);
        }

    
        private Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key) {
                root.left = insertRec(root.left, key);
            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            return root;
        }

        // In-order traversal
        public void inorderTraversal() {
            System.out.print("In-order traversal: ");
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

        // Pre-order traversal
        public void preorderTraversal() {
            System.out.print("Pre-order traversal: ");
            preorderRec(root);
            System.out.println();
        }

        private void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

        // Post-order traversal
        public void postorderTraversal() {
            System.out.print("Post-order traversal: ");
            postorderRec(root);
            System.out.println();
        }

        private void postorderRec(Node root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.key + " ");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.print("Enter number of nodes to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            bst.insert(val);
        }

        // Display all traversals
        bst.inorderTraversal();
        bst.preorderTraversal();
        bst.postorderTraversal();

        sc.close();
    }
}
