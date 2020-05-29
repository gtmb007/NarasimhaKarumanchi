import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
}
class Main {
	static ListNode merge(ListNode head1, ListNode head2) {
		if(head1==null) return head2;
		if(head2==null) return head1;
		ListNode head=null;
		if(head1.val<=head2.val)  {
			head=head1;
			head.next=merge(head1.next, head2);
		} else {
			head=head2;
			head.next=merge(head1, head2.next);
		}
		return head;
	}
	static ListNode merge1(ListNode head1, ListNode head2) {
		ListNode head=new ListNode(0);
		ListNode temp=head;
		while(head1!=null && head2!=null) {
			if(head1.val<=head2.val) {
				temp.next=head1;
				temp=temp.next;
				head1=head1.next;
			} else {
				temp.next=head2;
				temp=temp.next;
				head2=head2.next;
			}
		}
		if(head1!=null) temp.next=head1;
		if(head2!=null) temp.next=head2;
		return head.next;
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
		n=sc.nextInt();
		ListNode head1=null;
		temp=null;
		while(n-->0) {
			ListNode node=new ListNode(sc.nextInt());
			if(head1==null) {
				head1=node;
				temp=head1;
			} else {
				temp.next=node;
				temp=temp.next;
			}
		}
		/*temp=merge(head, head1);
                while(temp!=null) {
                        System.out.print(temp.val+" ");
                        temp=temp.next;
                }
                System.out.println();*/
		temp=merge1(head, head1);
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}
}
