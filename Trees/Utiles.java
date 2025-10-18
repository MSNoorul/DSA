package Trees;

import java.util.*;

public class Utiles {

    // Function to build tree from level order input
    static Node buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("N"))
            return null;

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            Node curr = queue.poll();

            // Left child
            if (!values[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                queue.add(curr.left);
            }
            i++;
            if (i >= values.length) break;

            // Right child
            if (!values[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }


    // Function to print tree level by level


}
