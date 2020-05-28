import java.util.*;
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val=val;
	}
}
class Main {
	static int counter;
	static ListNode res;
	static ListNode nthNodeFromLast(ListNode head, int k) {
		ListNode temp=head;
		int l=0;
		while(temp!=null) {
                        l++;
                        temp=temp.next;
                }
		temp=head;
		k=l-k+1;
		while(k-->1) {
			temp=temp.next;
		}
		return temp;
	}
	static ListNode nthNodeFromLast1(ListNode head, int k) {
		ListNode slow=head, fast=head;
		while(fast.next!=null) {
			if(k>1) {
				fast=fast.next;
				k--;
			} else {
				fast=fast.next;
				slow=slow.next;
			}
		}
		return slow;
	}
	static void nthNodeFromLast2(ListNode head, int k) {
		if(head!=null) {
			nthNodeFromLast2(head.next, k);
			counter++;
			if(counter==k) res=head;	
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ListNode head=null;
		ListNode temp=head;
		int n=sc.nextInt();
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
		System.out.println(nthNodeFromLast(head, k).val);	
		System.out.println(nthNodeFromLast1(head, k).val);
		nthNodeFromLast2(head, k);
		System.out.println(res.val);
	}	
}
