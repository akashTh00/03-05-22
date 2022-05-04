// 

public class InsertionDLL{
	Node head;

	class Node{
		int data;
		Node prev;
		Node next;

		Node(int d){ data = d;}
	}

	//adding a node at the front of the list***
	public void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		new_node.prev = null;

		if(head != null)
			head.prev = new_node;
		head = new_node;
	}

	//adding the node before the given node***
	public void InsertBefore(Node next_node, int new_data){
		if(next_node == null){
			System.out.println("The given next node cannot be null");
			return;
		}
		Node new_node = new Node(new_data);

		new_node.prev = next_node.prev;
		next_node.prev = new_node;
		new_node.next = next_node;
		if(new_node.prev != null){
			new_node.prev.next = new_node;
		}
		else
			head = new_node;
	}

	/* Given a node as prev_node, insert
    a new node after the given node */
    public void InsertAfter(Node prev_Node, int new_data)
    {
    	if(prev_Node == null){
    		System.out.println("The given previous node cannot be empty");
    		return;
    	}
    	Node new_node = new Node(new_data);
    	new_node.next = prev_Node.next;
    	prev_Node.next = new_node;
    	new_node.prev = prev_Node;

    	if(new_node.next != null)
    		new_node.next.prev = new_node;
    }

    //adding a node at the end of the list**
    public void append(int new_data){
    	Node new_node = new Node(new_data);

    	Node last = head;

    	new_node.next = null;

    	if(head == null){
    		new_node.prev = null;
    		head = new_node;
    		return;
    	}
    	while(last.next != null){
    		last = last.next;
    	}
    	last.next = new_node;

    	new_node.prev = last;
    }

	public void printList(Node node){
		Node last = null;
		System.out.println("Traversal in forward direction");
		while (node != null ){
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direciton");
		while( last != null )
		{
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

	public static void main(String[] args) {
		InsertionDLL dll = new InsertionDLL();
 
        // Insert 6. So linked list becomes 6->NULL
        dll.append(6);
 
        // Insert 7 at the beginning. So
        // linked list becomes 7->6->NULL
        dll.push(7);
 
        // Insert 1 at the beginning. So
        // linked list becomes 1->7->6->NULL
        dll.push(1);
 
        // Insert 4 at the end. So linked
        // list becomes 1->7->6->4->NULL
        dll.append(4);
 
        // Insert 8, after 7. So linked
        // list becomes 1->7->8->6->4->NULL
        dll.InsertAfter(dll.head.next, 8);
       
        // Insert 5, before 8.So linked
        // list becomes 1->7->5->8->6->4
        dll.InsertBefore(dll.head.next.next, 5);
 
        System.out.println("Created DLL is: ");
        dll.printList(dll.head);
    }
}
	