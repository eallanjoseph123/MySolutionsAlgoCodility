package main;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	
	private ListNode head;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtHead('r');
		list.insertAtHead('a');
		list.insertAtHead('c');
		list.insertAtHead('e');
		list.insertAtHead('c');
		list.insertAtHead('a');
		list.insertAtHead('r');
		
		System.out.println(list.isPalindrome());
	}
	
	public boolean isPalindrome() {
		ListNode old = head;
		
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		while(prev != null && old != null) {
			if(prev.data != old.data) {
				return false;
			}
			prev = prev.next;
			old = old.next;
		}
		
		return true;
	}
	
	public void removeDuplicatesUnsorted() {
		Set<Integer> set = new HashSet<>();
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		while(curr!=null) {
			int data = curr.data;
			boolean isDuplicate = set.add(data);
			if(isDuplicate == false){
				next = curr.next;
				curr = null;
				prev.next = next;
				curr = prev;
			}else {
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	public void removeDuplicates() {
		ListNode curr = head;
		if(curr != null) {
			ListNode prev = null;
			ListNode next = null;
			while(curr != null) {
				if(prev != null) {
					if(curr.data == prev.data) {
						next = curr.next;
						prev.next = next;
						curr = prev.next;
						continue;
					}
				}
				prev = curr;
				curr = curr.next;
			}
		}
	}
	

	
	public void reverse() {
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	
	
	public void deleteMiddle(int position) {
		ListNode temp = head;
		ListNode prev = null;
		int count = 0;
		while(temp != null){
			if(count == position && prev != null) {
				ListNode node = temp.next;
				prev.next = node;
				break;
			}
			count+=1;
			prev = temp;
			temp = temp.next;
			
		}
	}
	
	public void deleteEnd() {
		ListNode temp = head;
		ListNode prev = null;
		while(temp != null) {
			if(temp.next == null){
				prev.next = null;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		
		
	}
	
	public void deleteHead() {
		if(head != null) {
			ListNode temp = head.next;
			head = null;
			head = temp;
		}
	}
	
	public void insertAtEnd(int data) {
		ListNode temp = head;
		ListNode prev = null;
		while(temp != null) {
			prev = temp;
			 temp = temp.next;
		}
		if(temp == null) {
			prev.next = new ListNode(data);
		}
		
	}
	
	public void insertAtHead(int data) {
		if(head == null) {
			head = new  ListNode(data);
		}else{
			ListNode temp = head;
			ListNode newNode = new ListNode(data);
			head = newNode;
			head.next = temp;
			
		}
	}
	
	public void insetAtMiddle(int data, int position) {
		ListNode newNode = new ListNode(data);
		if(head == null) {
			head = new  ListNode(data);
		}else if(position <= 0){
			ListNode old = head;
			head = newNode;
			head.next = old;
		}else {
			ListNode temp = head;
			for(int x = 1 ; x < position ; x++) {
				temp = temp.next;
			}
				ListNode oldNode = temp.next;
				newNode.next = oldNode;
				temp.next = newNode;
		}
	}

	public void print(ListNode node){
		ListNode temp = node;
		if(temp == null){
			temp = head;
		}
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}
	
}
