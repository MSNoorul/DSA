package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class GreaterSumTreeBST {

//    using two traversal O(N2)
    public Node brute(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node cur = q.poll();
            int size = q.size();
            for(int i=0;i<size;i++){
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                System.out.println(cur.val + " ");
            }
            System.out.println();

        }
        return root;
    }


    void main(){
        String input= "11, 2, 29, 1, 7, 15, 40, N, N, N, N, N, N, 35, N";
        String[] values = input.split(",\\s*");
        Node root = Utiles.buildTree(values);
        Utiles.printTree(root);
        GreaterSumTreeBST gst = new GreaterSumTreeBST();
        gst.brute(root);
    }
}
