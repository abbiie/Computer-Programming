
package avlnew;
import java.util.Scanner;
public class AVLNew {
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BinarySearch tree = new BinarySearch();
        int node, input;
            do {
                System.out.println("AVL TREE IMPLEMENTATION "  + "\n" +
                "[1] INSERT NODE" + "\n" + "[2] DELETE NODE"+ "\n" + "[3] EXIT");
                input = sc.nextInt();
                try {
                    switch (input) {
                        case 1:
                            System.out.print("Insert a node: ");
                            node = sc.nextInt();
                            tree.root = tree.insertBinary(tree.root, node);
                            break;
                        case 2:
                            if (tree.getHeight() == 0) {
                                System.out.println(" ");
                                break;
                            } else {
                                System.out.print("Delete a node: ");
                                node = sc.nextInt();
                                tree.root = tree.deleteBST(tree.root, node);
                                break;
                            }
                        case 3:
                            System.exit(0);

                        default:
                            break;
                    }
                } catch (NullPointerException e) {
                    System.out.println("Node not found!");
                }
                tree.printBST();
                System.out.println();
            } while (input != 4);
            System.exit(0);
        }
    }

    // Node left & right implementation
    class Node {

        int key, height;
        Node left, right;

        Node (int x) {
            key = x;
            height = 1;
        }
    }

    class BinarySearch {
        Node root;
        // gets the height of the binary tree
        private int heightBST(Node tree) {
            if (tree == null) {
                return 0;
            }
            return tree.height;
        }

        // Gets the maximum value between two integers
        private int maxInt (int x, int y) {
            return (x > y) ? x : y;
        }
Node rightRotate(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = maxInt(heightBST(y.left), heightBST(y.right)) + 1; 
        x.height = maxInt(heightBST(x.left), heightBST(x.right)) + 1; 
  
        // Return new root 
        return x; 
    } 
  
    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    Node leftRotate(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights 
        x.height = maxInt(heightBST(x.left), heightBST(x.right)) + 1; 
        y.height = maxInt(heightBST(y.left), heightBST(y.right)) + 1; 
  
        // Return new root 
        return y; 
    } 
        int getBalance(Node node){
            if (node == null)
                return 0;
            return (heightBST(node.left)) - (heightBST(node.right));
        }
        // Method that performs BST insertion
        Node insertBinary(Node node, int key) {
            // BST rotation
            if (node == null) {
                return (new Node(key));
            }
            if (key < node.key) {
                node.left = insertBinary(node.left, key);
            } else if (key > node.key) {
                node.right = insertBinary(node.right, key);
            } else
            {
                return node;
            }

            // Update height of descendant node
            node.height = 1 + maxInt(heightBST(node.left),
                    heightBST(node.right));
            int balance = getBalance(node); 
  
        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 
  
        // Right Right Case 
        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 
  
        // Left Right Case 
        if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        /* return the (unchanged) node pointer */
        return node; 
    } 
            

            //gets the minimum value of the node
            private Node minNode(Node node) {
            Node updt = node;
            // Finding the leftmost leaf
            while (updt.left != null) {
                updt = updt.left;
            }
            return updt;
        }

        // Method that performs node deletion
        public Node deleteBST(Node root, int key) {
            if (root == null) {
                return root;
            }
            if (key < root.key) {
                root.left = deleteBST(root.left, key);
            } else if (key > root.key) {
                root.right = deleteBST(root.right, key);
            } // deletes the target key node
            else {
                // condition if node has only one child or no child
                if ((root.left == null) || (root.right == null)) {
                    Node temp = null;
                    if (temp == root.left) {
                        temp = root.right;
                    } else {
                        temp = root.left;
                    }

                    // Condition if there's no child
                    if (temp == null) {
                        temp = root;
                        root = null;
                     // else if there's one child
                    } else
                    {
                        root = temp;
                    }
                } else {
                    // Gets the Inorder traversal inlined with the node w/ two children
                    Node temp = minNode(root.right);
                    // Stores the inorder successor's node to this node
                    root.key = temp.key;
                    // Delete the inorder successor
                    root.right = deleteBST(root.right, temp.key);
                }
            }
            // Condition if there's only one child then returns the root
            if (root == null) {
                return root;
            }
            // Gets the updated height of the BST
            root.height = maxInt(heightBST(root.left), heightBST(root.right)) + 1;
            int balance = getBalance(root);  
  
            // If this node becomes unbalanced, then there are 4 cases  
            // Left Left Case  
            if (balance > 1 && getBalance(root.left) >= 0)  
                return rightRotate(root);  

            // Left Right Case  
            if (balance > 1 && getBalance(root.left) < 0)  
            {  
                root.left = leftRotate(root.left);  
                return rightRotate(root);  
            }  

            // Right Right Case  
            if (balance < -1 && getBalance(root.right) <= 0)  
                return leftRotate(root);  

            // Right Left Case  
            if (balance < -1 && getBalance(root.right) > 0)  
            {  
                root.right = rightRotate(root.right);  
                return leftRotate(root);  
            }  
                return root;

            }
            // Gets the height
            public int getHeight() {
                return root.height;
            }
            // variable declarations
            private String prnt, y;
            private int[] ArrayTree;
            private int lastIndex = 0;

            // performs the printing of nodes in the binary tree
            public void printBST() {
                prnt = " ";
                try {
                    int size = ((int) Math.pow(2, root.height)) - 1;
                    if (size > 0) {
                        ArrayTree = new int[size];

                        int index = 0;
                        ArrayTree[index] = root.key;

                        if (size > 1) {
                            BinarySearch(root, index);
                        }
                        for (int i = 0; i < ArrayTree.length; i++) {
                            if (i <= lastIndex) {
                                String bstoutput = (ArrayTree[i] == 0) ? "null " : ArrayTree[i] + " ";
                                prnt = prnt + " " + bstoutput + ", ";
                            }
                        }
                        System.out.print("\nBinary Tree: {" + prnt + "}");
                    }
                } catch (NullPointerException e) {
                    System.out.println("null");

                }
            }
            // method that does BST searching to perform insertion or deletion
            private void BinarySearch(Node node, int index) {
                Node left, right;
                left = node.left;
                right = node.right;

                int leftIndex = (2 * index) + 1;
                int rightIndex = (2 * index) + 2;
                if (left != null) {
                    ArrayTree[leftIndex] = left.key;
                    BinarySearch(left, leftIndex);
                    lastIndex = Math.max(leftIndex, lastIndex);
                } else {
                    if (leftIndex < ArrayTree.length - 1) {
                        ArrayTree[leftIndex] = 0;
                    }
                }

                if (right != null) {
                    ArrayTree[rightIndex] = right.key;
                    BinarySearch(right, rightIndex);
                    lastIndex = Math.max(rightIndex, lastIndex);
                } else {
                    if (rightIndex < ArrayTree.length - 1) {
                        ArrayTree[rightIndex] = 0;
                    }
                }
            }
        }

