import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
}
class Main {
	static ListNode insertNode(ListNode head, ListNode node) {
		if(head==null) head=node;
                else if(head.val>node.val) {
                        node.next=head;
                        head=node;
                } else {
                        ListNode temp=head;
                        while(temp.next!=null && temp.next.val<node.val) {
                                temp=temp.next;
                        }
                        node.next=temp.next;
                        temp.next=node;
                        temp=head;
                }
		return head;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ListNode head=null;
		ListNode temp=null;
		while(n-->0) {
			ListNode node=new ListNode(sc.nextInt());
			if(head==null) {
				head=node;
				temp=head;
			} else {
				temp.next=node;
				temp=temp.next;
			}
		}
		ListNode node=new ListNode(sc.nextInt());
		insertNode(head, node);
		temp=head;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
