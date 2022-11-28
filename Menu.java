import java.util.Scanner;

public class Menu
{
    static Scanner sc = new Scanner(System.in);  

    public static void main(String[] args) {
        
        int choice = 0;
        while(true)
        {
            System.out.println("1. Merge Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Matrix transpose");
            System.out.println("6. Matrix Multiplication");
            System.out.println("7. Rotate Matrix");
            System.out.println("8. ZigZag Matrix");
            System.out.println("9. Inorder Traversal");
            System.out.println("10. Postorder Traversal");
            System.out.println("11. Preorder Traversal");
            System.out.println("12. Levelorder Traversal");
            System.out.println("13. Insert in Linked List");
            System.out.println("14. Delete Node at position in Linked List");
            System.out.println("15. Search in a Linked List");
            System.out.println("16. Get number of nodes in Linked List");
            System.out.println("17. Palindrome Linked List");
            System.out.println("18. BFS of a graph");
            System.out.println("19. DFS of a graph");
            choice = sc.nextInt();
            if(choice == -1){
                break;
            }
            selectFunction(choice);
            try {
                Thread.sleep(3000);
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            // sc.close();
        }
    }

    public static void selectFunction(int choice){
        if(choice == 1){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i]=sc.nextInt();
            }
            Functions.mergeSort(array, n);
            Functions.printArray(array, n);
        }
        else if(choice == 2){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i]=sc.nextInt();
            }
            Functions.insertionSort(array, n);
            Functions.printArray(array, n);
        }
        else if(choice == 3){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i]=sc.nextInt();
            }
            Functions.bubbleSort(array);
            Functions.printArray(array, n);
        }
        else if(choice == 4){
            int n = sc.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++)
            {
                array[i]=sc.nextInt();
            }
            Functions.selectionSort(array);
            Functions.printArray(array, n);
        }
        else if(choice == 5){
            int N = 2;
            int A[][] = { {1, 2},{1, 2} };

            Functions.transpose(A, N);

            System.out.print("Modified matrix is \n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                System.out.print(A[i][j] + " ");
                System.out.print("\n");
            }
        }
        else if(choice == 6){
            int row1 = 2, col1 = 2, row2 = 2, col2 = 2;
            int A[][] = { { 1, 1 },{ 2, 2} };
    
            int B[][] = {{ 1, 1 },{ 2, 2}};
    

            Functions.multiplyMatrix(row1, col1, A, row2, col2, B);
        }
        else if(choice == 7){
            int R = 4;
            int C = 4;
            int a[][] = { {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16} };
            Functions.rotatematrix(R, C, a, R, C);
        }
        else if(choice == 8){
            int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            Functions.zigZagMatrix(matrix, 3, 3);
        }
        else if(choice == 9){
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.inorder();
        }
        else if(choice == 10){
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(8);
            tree.root.left = new Node(3);
            tree.root.right = new Node(10);
            tree.root.left.left = new Node(1);
            tree.root.left.right = new Node(6);
            tree.root.left.right.left = new Node(4);
            tree.root.left.right.right = new Node(7);
            tree.root.right.right = new Node(14);
            tree.root.right.right.left = new Node(13);
            tree.postorder(tree.root);
        }
        else if(choice == 11){
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(10);
            tree.root.left = new Node(8);
            tree.root.right = new Node(2);
            tree.root.left.left = new Node(3);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(2);
            tree.iterativePreorder();
        }
        else if(choice == 12){
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.right = new Node(6);
            BinaryTree.levelOrder(root);
        }
        else if(choice == 13){
            LinkedList llist = new LinkedList();
            llist.append(6);
            llist.push(7);
            llist.push(1);
            llist.append(4);
            llist.insertAfter(llist.head.next, 8);
            System.out.println("\nCreated Linked list is: ");
            llist.printList();
        }
        else if(choice == 14){
            LinkedList llist = new LinkedList();
            llist.push(7);
            llist.push(1);
            llist.push(3);
            llist.push(2);
            llist.push(8);

            System.out.println("\nCreated Linked list is: ");
            llist.printList();
            llist.deleteLLNode(4); 
            System.out.println("\nLinked List after Deletion at position 4: ");
            llist.printList();
        }
        else if(choice == 15){
            LinkedList llist = new LinkedList();

            llist.push(10);
            llist.push(30);
            llist.push(11);
            llist.push(21);
            llist.push(14);
            
            if (llist.search(llist.head, 21))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        else if(choice == 16){
            LinkedList llist = new LinkedList();
            llist.push(1);
            llist.push(3);
            llist.push(1);
            llist.push(2);
            llist.push(1);

            // Function call
            System.out.println("Count of nodes is " + llist.getCount());
        }
        else if(choice == 17){
            LLNode one = new LLNode(1);
            LLNode two = new LLNode(2);
            LLNode three = new LLNode(3);
            LLNode four = new LLNode(4);
            LLNode five = new LLNode(3);
            LLNode six = new LLNode(2);
            LLNode seven = new LLNode(1);
            one.next = two;
            two.next = three;
            three.next = four;
            four.next = five;
            five.next = six;
            six.next = seven;
            boolean condition = LinkedList.isPalindrome(one);
            System.out.println("isPalidrome :" + condition);
        }
        else if(choice == 18){
            Graph g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);
            System.out.println("Following is Breadth First Traversal "+
            "(starting from vertex 2)");
            g.BFS(2);
        }
        else if(choice == 19){
            Graph g = new Graph(5);

            g.addEdge(1, 0);
            g.addEdge(0, 2);
            g.addEdge(2, 1);
            g.addEdge(0, 3);
            g.addEdge(1, 4);

            System.out.println("Following is the Depth First Traversal");
            g.DFS(0);
        }
        else{
            System.out.println("Wrong Choice! Select Again!");
        }
    }
}

