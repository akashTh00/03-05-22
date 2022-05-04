// Java implementation to delete all
// the even nodes from the doubly
// linked list

class DeleteEvenNodeDLL
{
     
// Node of the doubly linked list
static class Node
{
    int data;
    Node prev, next;
};
 
// function to insert a node at the beginning
// of the Doubly Linked List
static Node push(Node head_ref, int new_data)
{
    // allocate node
    Node new_node = new Node();
 
    // put in the data
    new_node.data = new_data;
 
    // since we are adding at the beginning,
    // prev is always null
    new_node.prev = null;
 
    // link the old list off the new node
    new_node.next = (head_ref);
 
    // change prev of head node to new node
    if ((head_ref) != null)
        (head_ref).prev = new_node;
 
    // move the head to point to the new node
    (head_ref) = new_node;
    return head_ref;
}
 
// function to delete a node in a Doubly Linked List.
// head_ref -. pointer to head node pointer.
// del -. pointer to node to be deleted
static Node deleteNode(Node head_ref, Node del)
{
    // base case
    if (head_ref == null || del == null)
        return null;
 
    // If node to be deleted is head node
    if (head_ref == del)
        head_ref = del.next;
 
    // Change next only if node to be
    // deleted is NOT the last node
    if (del.next != null)
        del.next.prev = del.prev;
 
    // Change prev only if node to be
    // deleted is NOT the first node
    if (del.prev != null)
        del.prev.next = del.next;
 
 
    return head_ref;
}
 
// function to delete all the even nodes
// from the doubly linked list
static Node deleteEvenNodes(Node head_ref)
{
    Node ptr = head_ref;
    Node next;
 
    while (ptr != null)
    {
        next = ptr.next;
         
        // if true, delete node 'ptr'
        if (ptr.data % 2 == 0)
            deleteNode(head_ref, ptr);
        ptr = next;
    }
    return head_ref;
}
 
// function to print nodes in a
// given doubly linked list
static void printList(Node head)
{
    while (head != null)
    {
        System.out.print( head.data + " ");
        head = head.next;
    }
}
 
// Driver code
public static void main(String args[])
{
    // start with the empty list
    Node head = null;
 
    // create the doubly linked list
    // 15 <. 16 <. 7 <. 6 <. 17
    head = push(head, 17);
    head = push(head, 6);
    head = push(head, 7);
    head = push(head, 16);
    head = push(head, 15);
 
    System.out.print("Original List: ");
    printList(head);
 
    head=deleteEvenNodes(head);
 
    System.out.print( "\nModified List: ");
    printList(head);
}
}