import java.util.*;
class Main {
	static ListNode reverseInPair(ListNode head) {
		if(head==null || head.next==null) return head;
		else {
			ListNode temp=head.next;
			head.next=temp.next;
			temp.next=head;
			head=temp;
			head.next.next=reverseInPair(head.next.next);
			return head;
		}
	}
	static ListNode reverseInPair1(ListNode head) {
		ListNode temp1=null;
		ListNode temp2=null;
		while(head!=null && head.next!=null) {
			if(temp1!=null) temp1.next.next=head.next;
			temp1=head.next;
			head.next=temp1.next;
			temp1.next=head;
			head=head.next;
			if(temp2==null) temp2=temp1;
		}
		if(temp2==null) temp2=head;	
		return temp2;
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
		ListNode temp1=reverseInPair(head);
		temp=temp1;
		while(temp!=null) {
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
		temp=reverseInPair1(temp1);
                while(temp!=null) {
                        System.out.print(temp.val+" ");
                        temp=temp.next;
                }
                System.out.println();
	}
}
