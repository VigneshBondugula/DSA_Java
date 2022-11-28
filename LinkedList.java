import java.util.*;

class LLNode
	{
		int data;
		LLNode next;
		LLNode(int d) {data = d; next = null; }
	}

public class LinkedList
{
	LLNode head; // head of list

	/* Linked list LLNode*/
	

	/* Inserts a new LLNode at front of the list. */
    LLNode deleteLLNode(int key)
    {
        // Store head node
        LLNode temp = head, prev = null;
  
        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return temp;
        }
  
        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
  
        // If key was not present in linked list
        if (temp == null)
            return null;
  
        // Unlink the node from linked list
        prev.next = temp.next;
        return temp;
    }

    LLNode deleteLLNodeAtPos(int position)
    {
        // If linked list is empty
        if (head == null)
            return null;
 
        // Store head node
        LLNode temp = head;
 
        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return temp;
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return null;
 
        // LLNode temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        LLNode next = temp.next.next;
        LLNode del = temp.next;
        temp.next = next; // Unlink the deleted node from list
        return del;
    }

	public void push(int new_data)
	{
		/* 1 & 2: Allocate the LLNode &
				Put in the data*/
		LLNode new_node = new LLNode(new_data);

		/* 3. Make next of new LLNode as head */
		new_node.next = head;

		/* 4. Move the head to point to new LLNode */
		head = new_node;
	}

	/* Inserts a new node after the given prev_node. */
	public LLNode insertAfter(LLNode prev_node, int new_data)
	{
		/* 1. Check if the given LLNode is null */
		if (prev_node == null)
		{
			System.out.println("The given previous node cannot be null");
			return null;
		}

		/* 2 & 3: Allocate the LLNode &
				Put in the data*/
		LLNode new_node = new LLNode(new_data);

		/* 4. Make next of new LLNode as next of prev_node */
		new_node.next = prev_node.next;

		/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;

        return new_node;
	}
	
	/* Appends a new node at the end. This method is
	defined inside LinkedList class shown above */
	public LLNode append(int new_data)
	{
		/* 1. Allocate the LLNode &
		2. Put in the data
		3. Set next as null */
		LLNode new_node = new LLNode(new_data);

		/* 4. If the Linked List is empty, then make the
			new node as head */
		if (head == null)
		{
			head = new LLNode(new_data);
			return head;
		}

		/* 4. This new node is going to be the last node, so
			make next of it as null */
		new_node.next = null;

		/* 5. Else traverse till the last node */
		LLNode last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
		return new_node;
	}

	/* This function prints contents of linked list starting from
		the given node */
	public void printList()
	{
		LLNode tnode = head;
		while (tnode != null)
		{
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}
    
    public boolean search(LLNode head, int x)
    {
        LLNode current = head; // Initialize current
        while (current != null) {
            if (current.data == x)
                return true; // data found
            current = current.next;
        }
        return false; // data not found
    }

    public int getCount()
    {
        LLNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
 
    static boolean isPalindrome(LLNode head)
    {
 
        LLNode slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();
 
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }
 
        while (head != null) {
 
            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
                head = head.next;
            }
            else {
                ispalin = false;
                break;
            }
        }
        return ispalin;
    }
}
// This code is contributed by Rajat Mishra
