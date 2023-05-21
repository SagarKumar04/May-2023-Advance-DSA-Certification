package Tree.AssignmentQuestions.HeightOfBinaryTree;

class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
public class HeightOfBinaryTree {
    static int getHeight(Node node) {
        // Your code here
        if(node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }
}
