import java.util.*;
class Main {
	static ListNode reverseInBlocks(ListNode head, int k) {
		ListNode curr=head, prev=null, next=null;
		int count=k;
		while(curr!=null && count-->0) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		if(next!=null) head.next=reverseInBlocks(curr, k);
		return prev;
	}
	static ListNode reverseInBlocks1(ListNode head, int k) {
		ListNode curr=head, prevCurr=head, prevPrev=null;
		while(curr!=null) {
			int count=k;
			ListNode prev=null, next=null;
			while(curr!=null && count-->0) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}	
			if(prevPrev==null) head=prev;
			else prevPrev.next=prev;
			prevPrev=prevCurr;
			prevCurr=curr;
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
		int k=sc.nextInt();
		ListNode temp1=reverseInBlocks(head, k);
		temp=temp1;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
		temp=reverseInBlocks1(temp1, k);
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
