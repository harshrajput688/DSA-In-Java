/*
Pair sum in a BST

Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).
Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of S.
Output format:
You have to print each pair in a different line (pair elements separated by space). The order of different pairs, to be printed, does not matter.
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7
*/
import java.util.*;
public class PairsuminaBST {
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
	
    public static void preOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> ar){   
        if(root == null) return;
         ar.add(root.data);
        preOrder(root.left, ar);
       
        preOrder(root.right, ar);
           
   }
    
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		
        ArrayList<Integer> ar = new ArrayList<>();
        // store all the values of tree nodes into the arrayList. Here pattern is not important. 
        // means we can either store in preorder or postorder or inorder or in any other order.
        preOrder(root, ar);
        Collections.sort(ar);
        int i=0, l=ar.size()-1;
        while(i<l){
          	int a = ar.get(i);
          	int b = ar.get(l);
            if(s == (a+b)){
               System.out.println(a + " " + b); 
               i++;
               l--;
            }
            else if(s < (a+b))
                l--;
            else
                i++;
        }
        
        return;
        
	}

}
