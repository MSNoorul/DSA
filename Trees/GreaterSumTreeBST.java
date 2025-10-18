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
        String input= "2 1 6 N N 3 7";
        String[] values = input.split(" ");
        Node root = Utiles.buildTree(values);
        Utiles.printTree(root);
        GreaterSumTreeBST gst = new GreaterSumTreeBST();
        gst.brute(root);
    }
}
