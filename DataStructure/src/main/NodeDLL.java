package main;

public class NodeDLL {
	public static void main(String[] args) {
		NodeDLL d1 = new NodeDLL();
		
		Node node = new Node();
		node.data = 2;
		
		Node s1 = d1.SortedInsert(null, 1);
		
		Node s2 = d1.SortedInsert(s1, 4);
		
		Node s3 = d1.SortedInsert(s2, 2);
		
		
		Node s4 = d1.SortedInsert(s3, 3);
		
		Node s5 = d1.SortedInsert(s4, 7);
		
		Node s6 = d1.SortedInsert(s5, 6);
		
		Node s7 = d1.SortedInsert(s6, 9);
		
		Node s8 =d1.SortedInsert(s7, 10);
		
		d1.print(s8);
	}

	Node SortedInsert(Node head, int data) {
		Node curr = head;
		Node newNode = new Node();
		newNode.data = data;
		if (curr == null) {
			return newNode;
		} else if (curr.next != null) {
			while (curr != null) {
				Node next = curr.next;
				if (curr.data < data && next.data > data) {
					newNode.next = next;
					newNode.prev = curr;
					curr.next = null;
					curr.next = newNode;
					next.prev = newNode;
					break;
				}if(curr.data < data && next.data < data) {
					if(next.next != null) {
						curr = curr.next;
						continue;
					}else {
						next.next = newNode;
						newNode.prev = next;
					}
					
					break;
				}
				curr = curr.next;
			}
			return head;
		} else if (curr.next == null && curr.data < data) {
			curr.next = newNode;
			newNode.prev = curr;
			return curr;
		} else {
			newNode.next = curr;
			curr.prev = newNode;
			return newNode;
		}
	}

	public void print(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

}
