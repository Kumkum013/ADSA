



    // Class representing each node in the tree
class Node {
    int data;
    Node left, right;

    // Constructor to initialize a new node
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    // Root node of the tree
    Node root;

    // Constructor to create an empty tree
    BinarySearchTree() {
        root = null;
    }

    // Function to insert a new node into the BST
    Node insert(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        // return the unchanged node pointer
        return root;
    }

    // Inorder Traversal: Left -> Root -> Right
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal: Root -> Left -> Right
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal: Left -> Right -> Root
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Function to search for a value in BST
    boolean binarySearch(Node root, int key) {
        // Base cases: root is null or key is present at root
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }

        // Key is greater than root's data
        if (key > root.data) {
            return binarySearch(root.right, key);
        }

        // Key is smaller than root's data
        return binarySearch(root.left, key);
    }

    // Main method to test the code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();


        // Insert nodes into the BST
        int[] elements = {50, 30, 20, 40, 70, 60, 80};
        for (int element : elements) {
            tree.root = tree.insert(tree.root, element);
        }

        // Display traversal outputs
        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        // Search for a value in BST
        int searchKey = 60;
        if (tree.binarySearch(tree.root, searchKey)) {
            System.out.println("Element " + searchKey + " found in the tree.");
        } else {
            System.out.println("Element " + searchKey + " not found in the tree.");
        }
    }
}

