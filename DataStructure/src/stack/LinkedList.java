package stack;

import main.ListNode;

public class LinkedList {
	
	ListNode top;
	int count = 0;
	
	public static void main(String[] args) throws Exception {
		
		LinkedList l1 = new LinkedList();
		l1.push(1);
		l1.push(2);
		l1.push(3);
		l1.push(4);
		System.out.println(l1.top());
		l1.pop();
		System.out.println(l1.top());
		
	}
	
	public void print() {
		ListNode temp = top;
		while(temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}System.out.println();
	}
	
	public void push(int item){
		count +=1;
		ListNode temp = new ListNode(item);
		temp.next = top;
		top = temp;
		
	}
	
	public int size() {
		return count;
	}
	
	public int pop() throws Exception {
		int result = 0;
		if(top == null) {
			throw new Exception("stack is underflow");
		}
		result = top.data;
		top = top.next;
		count -=1;
		return result;
	}
	
	public int top() throws Exception {
		int result = 0;
		if(count <= 0 || top == null) throw new Exception("stack is underflow");
		result = top.data;
		return result;
	}
	
}
