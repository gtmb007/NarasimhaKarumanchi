import java.util.*;
class ListNode {
	Integer val;
	ListNode next;
	ListNode(Integer val) {
		this.val=val;
	}
}
public class MyStack {
	private ListNode top;
	public Integer push(Integer val) {
		if(top==null) top=new ListNode(val);
		else {
			ListNode node=new ListNode(val);
			node.next=top;
			top=node;
		}
		return top.val;
	}
	public Integer pop() {
		if(top==null) return null;
		Integer res=top.val;
		top=top.next;
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		MyStack stack=new MyStack();
		while(true) {
			System.out.println("1.) push \t 2.) pop \t 3.) Exit");
			int option=sc.nextInt();
			switch(option) {
				case 1 : System.out.println(stack.push(sc.nextInt()));
					break;
				case 2 : System.out.println(stack.pop());
					break;
				case 3 : System.exit(0);
			}
		}
	}
}
