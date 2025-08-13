import java.util.*;

public class BSTsearch {

                                                                    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

                                                                     // Insert into BST
        Node insert(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }
            if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

                                                                        // Inorder Traversal (L, Root, R)
        void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
            }
        }

                                                                  // Preorder Traversal (Root, L, R)
        void preorder(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }

                                                                // Postorder Traversal (L, R, Root)
        void postorder(Node root) {
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.data + " ");
            }
        }

                                                                // Search in BST
        boolean search(Node root, int key) {
            if (root == null) {
                return false;
            }
            if (root.data == key) {
                return true;
            }
            if (key < root.data) {
                return search(root.left, key);
            } else {
                return search(root.right, key);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            tree.root = tree.insert(tree.root, value);
        }

                                                                  // Display Traversals
        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

                                                                          // Search for a number
        System.out.print("\n\nEnter number to search: ");
        int searchValue = sc.nextInt();                                   // Scan The Input Given By Me 

        if (tree.search(tree.root, searchValue)) {
            System.out.println(searchValue + " is FOUND in the tree.");
        } else {
            System.out.println(searchValue + " is NOT found in the tree.");
        }

        sc.close();
    }
}
