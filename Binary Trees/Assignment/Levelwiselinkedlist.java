/*
Level wise linkedlist

Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format :
Each level linked list is printed in new line (elements are separated by space).
Constraints:
Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
5 
6 10 
2 3 
9
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Levelwiselinkedlis {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	/*
	 * LinkedListNode Class
	 * class LinkedListNode<T> 
	 * { 
	 * 		T data; 
	 * 		LinkedListNode<T> next;
	 * 		public LinkedListNode(T data) 	
	 * 		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
        if(root == null){


            return null; 
        }
        
        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> isPending = new LinkedList<>();
        isPending.add(root);
        isPending.add(null);
        
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
        
        while(!isPending.isEmpty()){
            BinaryTreeNode<Integer> take = isPending.poll();
            
          
            
            if(take == null){
                ans.add(head);
                
                
                if(!isPending.isEmpty()){
                    isPending.add(null);
                }
                head = null;
                tail = null;
            }
            else{
                
                if(take.left!=null) isPending.add(take.left);
                if(take.right!=null) isPending.add(take.right);
            	LinkedListNode<Integer> node = new LinkedListNode<>(take.data);
                if(head == null){
                    head = node;
                    tail = node;
                }else{
                    tail.next = node;
                    tail = node;
                }
        	}
        
		}
        return ans;
    }


}
