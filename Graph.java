import java.util.*;
import java.util.LinkedList;
public class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    ArrayList<Integer> BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            // System.out.print(s+" ");
            ans.add(s);
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return ans;
    }

    // prints all not yet visited vertices reachable from s
    ArrayList<Integer> DFS(int s)
    {
        // Initially mark all vertices as not visited
        Vector<Boolean> visited = new Vector<Boolean>(V);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++)
            visited.add(false);
    
        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();
            
        // Push the current source node
        stack.push(s);
            
        while(stack.empty() == false)
        {
            // Pop a vertex from stack and print it
            s = stack.peek();
            stack.pop();
                
            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if(visited.get(s) == false)
            {
                // System.out.print(s + " ");
                ans.add(s);
                visited.set(s, true);
            }
                
            // Get all adjacent vertices of the popped vertex s
            // If a adjacent has not been visited, then push it
            // to the stack.
            Iterator<Integer> itr = adj[s].iterator();
                
            while (itr.hasNext())
            {
                int v = itr.next();
                if(!visited.get(v))
                    stack.push(v);
            }
                
        }
        return ans;
    }
}