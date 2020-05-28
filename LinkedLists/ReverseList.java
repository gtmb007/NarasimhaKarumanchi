import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
}
class Main {
	static ListNode reverseList(ListNode head) {
		ListNode prev=null;
		ListNode curr=head;
		ListNode next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
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
		temp=reverseList(head);
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
