/*
Code: BST Class

Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BST or not. Return true or false.
2. insert -
Given an element, insert that element in the BST at the correct position. If element is equal to the data of the node, insert it in the left subtree.
3. delete -
Given an element, remove that element from the BST. If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.

*/
/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree {
		    private BinaryTreeNode<Integer> root;
		    private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data) {
				if(root == null) {
					BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
					return node;
				}
				if(root.data>=data) {
						BinaryTreeNode<Integer> node = insertDataHelper(root.left,data);
						root.left = node;
						return root;
				}else{
					BinaryTreeNode<Integer> node = insertDataHelper(root.right,data);
					root.right = node;
					return root;
				}
			}
			public void insert(int data) {
				//Implement the insert() function
		        this.root = insertDataHelper(this.root, data);
			}
			
		    
		    
		    	private int findMinAtRight(BinaryTreeNode<Integer> root){
				
				if(root.left == null) {
					return root.data;
				}
			    return findMinAtRight(root.left);
				
			}
			private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int data){
				if(root == null) {
					return null;
				}
				if(root.data == data) {
					if(root.left==null) {
						root = root.right;
						return root;
					}else if(root.right == null) {
						root = root.left;
						return root;
					}else {
						root.data = findMinAtRight(root.right);
						root.right = deleteDataHelper(root.right, root.data);
						return root;
					}
				}
				if(root.data>data) {
					BinaryTreeNode<Integer> node = deleteDataHelper(root.left,data);
					root.left = node;
					return root;
				}else if(root.data<data) {
					BinaryTreeNode<Integer> node = deleteDataHelper(root.right, data);
					root.right = node;
					return root;
				}else {
					return root;
				}
				
			}
			public void remove(int data) {
				//Implement the remove() function
		        this.root = deleteDataHelper(this.root,data);
			}
			
		    
		    private void printTreeHelper(BinaryTreeNode<Integer> root) {
				if(root == null) {
					return ;
				}
				System.out.print(root.data+":");
				if(root.left!=null) {
					System.out.print("L:"+root.left.data+",");
				}
				if(root.right!=null) {
					System.out.print("R:"+root.right.data);
				}
				System.out.println();
				printTreeHelper(root.left);
				printTreeHelper(root.right);
			}
			public void printTree() {
				//Implement the printTree() function
		        printTreeHelper(this.root);
			}
			
		    
		    private boolean hasDataHelper(BinaryTreeNode<Integer> root,int data) {
				if(root == null) {
					return false;
				}
				if(root.data == data ) {
					return true;
				}
				if(root.data>data) {
					return hasDataHelper(root.left,data);
				}else if(root.data<data) {
					return hasDataHelper(root.right, data);
				}else {
					return false;
				}
			}
			public boolean search(int data) {
				//Implement the search() function
		        return hasDataHelper(this.root , data);
			}
			

		}
