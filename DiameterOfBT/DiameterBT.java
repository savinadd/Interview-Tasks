import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Tree {
        Node left;
        Node right;
      
        int diameter(Node root) {
            if (root == null)
                return 0;
            int lHeight = height(root.left);
            int rHeight= height(root.right);
            int lDiameter = diameter(root.left);
            int rDiameter = diameter(root.right);
            return Math.max(Math.max(lDiameter, rDiameter), (lHeight + rHeight + 1));
            
        }
        
        int height (Node n){
            if (n == null)
                return 0;
            else
                //1 + max of lh and rh
                return (1 + Math.max(height(n.left), height(n.right)));
        
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
  
    private static final Scanner sc = new Scanner(System.in);
  
	public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        HashMap<Integer, Node> m = new HashMap<>();
        int n = sc.nextInt();
        Node root = null;
        while (n > 0) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            char lr = sc.next().charAt(0);
            Node parent = m.get(n1);
            if (parent == null) {
                parent = new Node(n1);
                m.put(n1, parent);
                if (root == null)
                    root = parent;
            }
            Node child = new Node(n2);
            if (lr == 'L')
                parent.left = child;
            else
                parent.right = child;
            m.put(n2, child);
            n--;
        }
        Tree t = new Tree();
        int result = t.diameter(root);

        bw.write(String.valueOf(result));
        bw.close();
    }
}