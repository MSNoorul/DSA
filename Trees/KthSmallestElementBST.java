package Trees;
import  java.util.*;


public class KthSmallestElementBST {


    public  int usingInorderWithList(Node node , int k){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(node,list);
        if(k >list.size()) return -1;
        return list.get(k-1);
    }

    public void inOrder(Node root ,List<Integer> list){
        if(root == null) return;
        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right , list);
    }

    void main(){
        // Input: 1 N 2 N 3 N 4 N N
        String input = "1 N 2 N 3 N 4 N N";
        int k = 4;

        // Convert input string to array
        String[] values = input.split(" ");

        // Build the tree
        Node root = Utiles.buildTree(values);
        KthSmallestElementBST kse = new KthSmallestElementBST();

        System.out.println(kse.usingInorderWithList(root , 4));
    }
}
