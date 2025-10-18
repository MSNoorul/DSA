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
    // Entry method
    public static void printTree(Node root) {
        List<StringBuilder> lines = new ArrayList<>();
        printTreeRec(root, 0, lines, 0, 0);
        for (StringBuilder sb : lines) {
            System.out.println(sb.toString());
        }
    }

    private static int printTreeRec(Node node, int x, List<StringBuilder> lines, int depth, int offset) {
        if (node == null) return 0;

        String s = Integer.toString(node.val);
        int left = printTreeRec(node.left, x, lines, depth + 2, offset);
        int right = printTreeRec(node.right, x + left + s.length(), lines, depth + 2, offset + left + s.length());

        while (lines.size() <= depth) {
            lines.add(new StringBuilder());
        }
        StringBuilder line = lines.get(depth);
        while (line.length() < offset + left) {
            line.append(" ");
        }
        line.append(s);

        // Add / and \ branches
        if (node.left != null) {
            while (lines.size() <= depth + 1) {
                lines.add(new StringBuilder());
            }
            StringBuilder branchLine = lines.get(depth + 1);
            while (branchLine.length() < offset + left - 1) branchLine.append(" ");
            branchLine.append("/");
        }

        if (node.right != null) {
            while (lines.size() <= depth + 1) {
                lines.add(new StringBuilder());
            }
            StringBuilder branchLine = lines.get(depth + 1);
            while (branchLine.length() < offset + left + s.length()) branchLine.append(" ");
            branchLine.append("\\");
        }

        return left + s.length() + right;
    }





}
