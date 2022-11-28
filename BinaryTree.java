import java.util.*;
import java.util.LinkedList;

class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
/* Class to print the inorder traversal */
public class BinaryTree
{
    Node root;

    ArrayList<Integer> inorder()
    {
        if (root == null)
            return null;
 
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
 
        // traverse the tree
        while (curr != null || s.size() > 0)
        {
 
            /* Reach the left most Node of the
            curr Node */
            while (curr !=  null)
            {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }
 
            /* Current must be NULL at this point */
            curr = s.pop();
 
            System.out.print(curr.data + " ");
            ans.add(curr.data);
            
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
        return ans;
    }

    ArrayList<Integer> postorder(Node head)
    {
        Node temp = root;   
        HashSet<Node> visited = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while ((temp != null  && !visited.contains(temp)))
        {
        
            // Visited left subtree
            if (temp.left != null &&
            !visited.contains(temp.left))
                temp = temp.left;
    
            // Visited right subtree
            else if (temp.right != null &&
            !visited.contains(temp.right))
                temp = temp.right;
    
            // Print node
            else
            {
                // System.out.printf("%d ", temp.data);
                ans.add(temp.data);
                visited.add(temp);
                temp = head;
            }
        }
        return ans;
    }

    static void levelOrder(Node root) {
        if (root == null)
            return;
          
        Queue<Node> q = new LinkedList<>();
        
        // Pushing root node into the queue.
        q.add(root);
        
        // Pushing delimiter into the queue.
        q.add(null);
        
        // Executing loop till queue becomes
        // empty
        while (!q.isEmpty()) {
        
            Node curr = q.poll();
        
            // condition to check the
            // occurrence of next level
            if (curr == null) {
            if (!q.isEmpty()) {
                q.add(null);
                System.out.println();
            }
            } else {
            // Pushing left child current node
            if (curr.left != null)
                q.add(curr.left);
        
            // Pushing right child current node
            if (curr.right != null)
                q.add(curr.right);
        
            System.out.print(curr.data + " ");
            }
        }
    }
        
    ArrayList<Integer> iterativePreorder()
    {
 
        Node node = root;
        // Base Case
        if (node == null) {
            return null;
        }
 
        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        ArrayList<Integer> ans = new ArrayList<>();
        nodeStack.push(root);
 
        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {
 
            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            // System.out.print(mynode.data + " ");
            ans.add(mynode.data);
            nodeStack.pop();
 
            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
        return ans;
    }
}
 