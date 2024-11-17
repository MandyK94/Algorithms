package NeetCode150;

public class RandomPointerLinkedList {

	private class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
        
		
		if(head==null) {
			return null;
		}
		
		// Make a copy of nodes with val and insert them after original nodes
		Node l1 = head;
		while(l1!=null) {
			Node l2= new Node(l1.val);
			l2.next = l1.next;
			l1.next = l2;
			l1=l2.next;
		}
		
		// copy random pointers
		l1 = head;
		while(l1!=null) {
			if(l1.random!=null) {
				l1.next.random = l1.random.next;
			}
			l1=l1.next.next;
		}
		
		// remove the original nodes
		Node newHead = head.next;
		l1=head;
		while(l1!=null) {
			Node l2 = l1.next;
			l1.next = l2.next;
			if(l2.next!=null) {
				l2.next = l2.next.next;
			}
			l1 = l1.next;
		}
    
        return newHead;
	}
	
}
