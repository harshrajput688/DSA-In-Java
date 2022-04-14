/*
Largest BST

Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
The first and only line of output contains the height of the largest BST.
Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2
*/
public class LargestBST {
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
	
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
       Quartet ans= helper(root);
        return ans.height;
    }    
	public static Quartet helper(BinaryTreeNode<Integer> root) {
		// Write your code here
        if(root == null){
            Quartet ans = new Quartet();
            ans.min = Integer.MAX_VALUE;
            ans.max = Integer.MIN_VALUE;
            ans.height = 0;
            ans.isBST = true;
            return ans;
        }
        Quartet left = helper(root.left);
        Quartet right = helper(root.right);
        
        Quartet ans = new Quartet();
              
        if(left.isBST&&right.isBST){
            if(left.max<root.data&&right.min>root.data){
                ans.min = Math.min(left.min , Math.min(right.min , root.data));
                ans.max = Math.max(left.max , Math.max(right.max , root.data));
                ans.height =  1 + Math.max(left.height,right.height);   
                ans.isBST = true;
                return ans;
            }else{
                ans.min = Math.min(left.min , Math.min(right.min , root.data));
                ans.max = Math.max(left.max , Math.max(right.max , root.data));
                ans.isBST = false;
                ans.height = Math.max(left.height,right.height);
                return ans;
            }

        }else{
            ans.min = Math.min(left.min , Math.min(right.min , root.data));
            ans.max = Math.max(left.max , Math.max(right.max , root.data));
            ans.height = Math.max(left.height,right.height);
            ans.isBST = false;
            return ans;
            
        }    
	}

}
 class Quartet{
       public int  min;
       public int max;
       public int height;
       public boolean isBST;
   }
