package Trees;



public class GreaterSumTreeBST {

    //    using two traversal O(N2)
    public Node brute(Node root, Node cur) {
        int sum = getSumVal(root, cur.val);
        Node newRoot = new Node(sum);
        if (cur.left != null) {
            newRoot.left = brute(root, cur.left);
        }
        if (cur.right != null) {
            newRoot.right = brute(root, cur.right);
        }
        return newRoot;
    }

    // intution
    // this is the bst so all the creater value will be the right side
    // so traverse the tree from the right side will make sense
    public Node optimal(Node root){
        helper(root,new int[]{0});
        return  root;
    }
    public void helper(Node root ,int[] sum){
        if(root == null) return;
        helper(root.right,sum);
        int rootVal = root.val;
        root.val = sum[0];
        sum[0]+= rootVal;
        helper(root.left,sum);
    }

    private int getSumVal(Node root, int val) {
        if (root == null) return 0;
        int leftSum = getSumVal(root.left, val);
        int rightSum = getSumVal(root.right, val);
        int sum = leftSum + rightSum;
        if (val < root.val) sum += root.val;
        return sum;
    }


    void main() {
        String input = "11, 2, 29, 1, 7, 15, 40, N, N, N, N, N, N, 35, N";
        String[] values = input.split(",\\s*");
        Node root = Utiles.buildTree(values);
        Utiles.printTree(root);
        GreaterSumTreeBST gst = new GreaterSumTreeBST();
        Node newTree = gst.optimal(root);
        Utiles.printTree(newTree);
    }
}
