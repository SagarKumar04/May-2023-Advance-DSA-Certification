package Tree.BinarySearchTree.AssignmentQuestions.PostClass;

public class FindKthSmallestNode {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static int count = 0, result;
    private static void kthSmallestInBSTHelper(Node node, int k) {
        if(node != null) {
            kthSmallestInBSTHelper(node.left, k);
            count++;
            if(count == k) {
                result = node.data;
                return;
            }
            kthSmallestInBSTHelper(node.right, k);
        }
    }

    public static void kthSmallestInBST(Node root, int k) {
        // Write your code here
        kthSmallestInBSTHelper(root, k);

        System.out.println(result);
    }
}
