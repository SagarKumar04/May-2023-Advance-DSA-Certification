package Tree.AssignmentQuestions.LeafSum;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LeafSum {
    public int leafSum(TreeNode root){
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = leafSum(root.left);
        int rightSum = leafSum(root.right);

        int sum = leftSum + rightSum;

        return sum;
    }
}

