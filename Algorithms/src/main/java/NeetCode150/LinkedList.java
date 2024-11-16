package NeetCode150;

public class LinkedList {

	public class ListNode {
		
		public int val;
		public ListNode next;
		
		public ListNode() {}

		public ListNode(int val) {
			this.val = val;
		}
		
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}	
	}
	
	public static ListNode reverseList(ListNode head) {
		
        ListNode prev = null;
        ListNode node = head;
        while(node!=null) {
        	ListNode temp = node.next;
        	node.next=prev;
        	prev = node;
        	node = temp;
        }
        return prev;
	}
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		
		while(list1!=null && list2!=null) {
			if(list1.val<=list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2=list2.next;
			}
			node = node.next;
		}
		if(list1!=null) {
			node.next=list1;
		}
		if(list2!=null) {
			node.next=list2;
		}
		return dummy.next;
	}
	
	public boolean hasCycle(ListNode head) {
		
		ListNode ptr1=head;
		ListNode ptr2=head;
		
		while(ptr2!=null && ptr2.next!=null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if(ptr1==ptr2) {
				return true;
			}
		}
		return false;
	}
	
	public void reorderList(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode second = slow.next;
		ListNode prev = slow.next=null;
		while(second!=null) {
			ListNode temp = second.next;
			second.next = prev;
			prev = second;
			second = temp;
		}
		
		ListNode first = head;
		second = prev;
		while(second!=null) {
			ListNode temp1 = first.next;
			ListNode temp2 = second.next;
			first.next = second;
			second.next = temp1;
			first=temp1;
			second = temp2;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode dummy = new ListNode(0, head);
        ListNode ptr2 = dummy;
		ListNode ptr1 = head;
		while(n>0 ) {
			ptr1 = ptr1.next;
			n--;
		}
        
		while(ptr1!=null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		ptr2.next = ptr2.next.next;
		return dummy.next;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode();
		ListNode node = dummy;
		int carry = 0;
		while(l1!=null || l2!=null || carry!=0) {
			int val1 = l1!=null?l1.val:0;
			int val2 = l2!=null?l2.val:0;
			
			int x = val1+val2+carry;
			carry =x/10;
			x = x%10;
			node.next = new ListNode(x);
			node = node.next;
			l1 = l1!=null?l1.next:null;
			l2 = l2!=null?l2.next:null;	
		}
		return dummy.next;
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode l1= list.new ListNode(1);
		ListNode l2= list.new ListNode(2);
		ListNode l3= list.new ListNode(3);
		l1.next = l2;
		l2.next=l3;
		ListNode l11= list.new ListNode(4);
		ListNode l12= list.new ListNode(5);
		ListNode l13= list.new ListNode(6);
		l11.next=l12;
		l12.next=l13;
		System.out.println(list.addTwoNumbers(l1, l11).val);
	}
}
