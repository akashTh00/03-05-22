// java program to sort the given elements in the Doubly Linked List**

class SortingDLL{
	Node head = null;

	class Node{
	int data;
	Node prev, next;
	Node(int d){
		this.data = d;
		prev = null;
		next = null;
	}
}

	public void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		new_node.prev = null;

		if (head != null)
			head.prev = new_node;

		head = new_node;

	}

	public void sortList(){
		Node curr = null, index = null;

		int temp;

		if(head == null){
			return;
		}
		else{
			for(curr = head; curr != null; curr=curr.next){
				for(index = curr.next; index != null; index = index.next){
					if(curr.data > index.data){
						temp = curr.data;
						curr.data = index.data;
						index.data = temp;
					}
				}
			}
		}
	}

	public void printList(Node node)
    {
        Node last = null;
 
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
 
        System.out.println();
    }


public static void main(String[] args) {
	SortingDLL llist = new SortingDLL();
	llist.push(5);
	llist.push(4);
	llist.push(2);
	llist.push(1);
	llist.push(7);
	llist.push(19);
	llist.push(3);
	llist.push(10);

	llist.printList(llist.head);

	llist.sortList();
	llist.printList(llist.head);

}

}