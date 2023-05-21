package Tree.AssignmentQuestions.BinaryTreeCreationII;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTreeCreationII {
    public static void main(String[] args) {
        // write your code here to create the tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(5);
        root.left.right = new Node(6);

        System.out.print(root.value+ " ");
        System.out.print(root.left.value+ " ");
        System.out.print(root.left.left.value+ " ");
        System.out.print(root.left.right.value+ " ");
        System.out.print(root.right.value+ " ");
    }
}

