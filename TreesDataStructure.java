class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class TreesDataStructure {
    Node root;

    
    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
    
    public void inorder() {
        inorderRec(root);
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
    
    public boolean search(int value) {
        return searchRec(root, value);
    }
    
    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return (value < root.value) ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    public static void main(String[] args) {
        TreesDataStructure tree = new TreesDataStructure();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the tree:");
        tree.inorder();

        System.out.println("\nSearch for 40: " + tree.search(40));
        System.out.println("Search for 100: " + tree.search(100));
    }
}
