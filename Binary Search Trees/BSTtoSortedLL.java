/*
Code: BST to Sorted LL

Given a BST, convert it into a sorted linked list. You have to return the head of LL.
Input format:
The first and only line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
Output Format:
The first and only line of output prints the elements of sorted linked list.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2 5 6 7 8 10
*/

public class BSTtoSortedLL {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T>
	 * right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */

	/*
	 * LinkedList Node Class
	 *
	 * 
	 * class LinkedListNode<T> { T data; LinkedListNode<T> next;
	 * 
	 * public LinkedListNode(T data) { this.data = data; } }
	 */

	/*public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

       
        Pair<LinkedListNode<Integer>> ans = helper(root);
        return ans.head;
        
	}
    
    public static Pair<LinkedListNode<Integer>> helper(BinaryTreeNode<Integer> root){
        if(root==null){

            Pair<LinkedListNode<Integer>> ans = new Pair<>();
            LinkedListNode<Integer> Head = new LinkedListNode<>(null);
            LinkedListNode<Integer> Tail = new LinkedListNode<>(null);
            
            ans.head = Head;
            ans.tail = Tail;
            
            return ans;
        }
        
        Pair<LinkedListNode<Integer>> leftAns = helper(root);
        Prir<LinkedListNode<Integer>> rightAns = helper(root);
        
        LinkedListNode<Integer> head = new LinkedListNode<>()
    }*/
    static  LinkedListNode<Integer> head=null,temp=null;
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
       
        solve(root);
        return head;

	}
    public static void solve(BinaryTreeNode<Integer> root)
    {
      if(root==null)
          return;
       
       solve(root.left);
         LinkedListNode<Integer> toadd=new LinkedListNode<Integer>(root.data);
      if(head==null)
      {
         head=toadd;
          temp=toadd;
      }
        else{
            temp.next=toadd;
            temp=temp.next;
        }
       solve(root.right);
      
    }
}
