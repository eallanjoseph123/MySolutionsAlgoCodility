package tree;

import java.util.Arrays;

public class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
	public static void main(String[] args) {
		Node a = new Node(1);
		
		a.left = new Node(2);
		a.left.left = new Node(4);
		a.left.right = new Node(5);
		
		a.right = new Node(3);
		a.right.left = new Node(6);
		a.right.right = new Node(7);
		
		a.levelOrder(a);
		
	}
	
	  int max = 0 ;  
	   void levelOrder(Node root) {
		   gSize(root);
	        Node[] a = new Node[max];
	         a[0] = root;
	         int temp = 0;
	       for(int x = 0 ;x < max; x++){
	           Node ap = a[x];
	         System.out.print(ap.data+" ");
	           if(ap.left != null){
	        	   temp +=1;
	               a[temp] = ap.left;
	           }
	             if(ap.right != null){
	            	 temp +=1;
	               a[temp] = ap.right;
	           }
	       }
	       
	      
	   }
	 
	   void gSize(Node root){
	    if(root.left != null){
	        gSize(root.left);
	    }
	     max+=1;
	    if(root.right != null){
	        gSize(root.right);
	    }   
	   }
	
	public int findMax(Node root) {
		int max = 0;
		if(root != null) {
			int l = findMax(root.left);
			int r = findMax(root.right);
			
			if(l > r) {
				max = l;
			}else {
				max = r;
			}
			if(root.data > max) {
				max = root.data;
			}
		}
		
		return max;
	}
	
	int size = 0;
    int []b = null;
    int c =0;
    boolean checkBST(Node root) {
    	Node t = root;
		int l = 0;
		int r = 0;
		while(t != null && t.left !=null) {
			l = t.left.data;
			t = t.left;
		}
		Node t2 = root;
		while(t2 != null && t2.right != null) {
			r = t2.right.data;
			t2 = t2.right;
		}
		
		return l < r;
    }

    public void printInOrder2(Node root,int[]a) {
		
		if(root.left != null){
			printInOrder2(root.left,a);
		}
		a[c] = root.data;
        c+=1;
		if(root.right != null){
			printInOrder2(root.right,a);
		}
	}

    public void printInOrder1(Node root) {

		
		if(root.left != null){
			printInOrder1(root.left);
		}
		 size+=1;
		if(root.right != null){
			printInOrder1(root.right);
		}
	}
	
	static int res = 1;
     int l1,r2 = 0;
	public int height(Node root) {
		if(root.left != null) {
			 l1 +=height(root.left)+1;
			System.out.println("l1="+l1);
		}
		if(root.right != null){
			r2+=height(root.right)+1;
			System.out.println("r2="+r2);
		}
	     
		
		return 0;
	}
	
	public void insert(int value) {
		if (value < data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		}else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if(data == value) {
			return true;
		}else if(value < data){
			if(left == null){
				return false;
			}else {
				return left.contains(value);
			}
		}else{
			if(right == null){
				return false;
			}else {
				return right.contains(value);
			}
		}
	}

	public void printInOrder() {

		
		if(left != null){
			left.printInOrder();
		}
		System.out.print(data+" ");
		if(right != null){
			right.printInOrder();
		}
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + ", size=" + size + ", b="
				+ Arrays.toString(b) + ", c=" + c + ", l1=" + l1 + ", r2=" + r2 + "]";
	}
	
	
}
