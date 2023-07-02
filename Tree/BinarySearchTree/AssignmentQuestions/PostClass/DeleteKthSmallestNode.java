package Tree.BinarySearchTree.AssignmentQuestions.PostClass;

public class DeleteKthSmallestNode {
    class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int count = 0, result;

    private static int findInorderPredecessor(Node node) {
        int inorderPredecessor = node.data;

        while(node.right != null) {
            node = node.right;
            inorderPredecessor = node.data;
        }

        return inorderPredecessor;
    }

    static Node deleteInBST(Node root, int value) {
        if(root == null) {
            return null;
        }

        if(value < root.data) {
            root.left = deleteInBST(root.left, value);
        }
        else if(value > root.data) {
            root.right = deleteInBST(root.right, value);
        }
        else {
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            else {
                int inorderPredecessor = findInorderPredecessor(root.left);
                root.data = inorderPredecessor;

                root.left = deleteInBST(root.left, inorderPredecessor);
            }
        }

        return root;
    }

    static void kthSmallestInBST(Node node, int k) {
        if(node != null) {
            kthSmallestInBST(node.left, k);
            count++;
            if(count == k) {
                result = node.data;
                return;
            }
            kthSmallestInBST(node.right, k);
        }
    }

    static Node deleteKthSmallest(Node root, int k) {
        //Write your code here
        kthSmallestInBST(root, k);

        return deleteInBST(root, result);
    }
}
