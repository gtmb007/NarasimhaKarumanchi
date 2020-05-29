import java.util.*;
class Main {
	static ListNode findMid(ListNode head) {
		ListNode temp=head;
		int l=0;
		while(temp!=null) {
			l++;
			temp=temp.next;
		}
		l=l/2;
		temp=head;
		while(l-->0) {
			temp=temp.next;
		}
		return temp;
	}
	static ListNode findMid1(ListNode head) {
		HashMap<Integer, ListNode> hm=new HashMap<Integer, ListNode>();
		ListNode temp=head;
		int i=1;
		while(temp!=null) {
			hm.put(i++, temp);
			temp=temp.next;
		}
		i=--i/2+1;
		return hm.get(i);
	}
	static ListNode findMid2(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
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
		ListNode mid=findMid(head);
		if(mid!=null) System.out.println(mid.val);
		else System.out.println(mid); 
		mid=findMid1(head);
                if(mid!=null) System.out.println(mid.val);
                else System.out.println(mid);
		mid=findMid2(head);
                if(mid!=null) System.out.println(mid.val);
                else System.out.println(mid);
	}
}
