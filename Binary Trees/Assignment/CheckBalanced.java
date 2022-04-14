/*
Check Balanced

Given a binary tree, check if it is balanced. Return true if given binary tree is balanced, false otherwise.
Balanced Binary Tree:
A empty binary tree or binary tree with zero nodes is always balanced. For a non empty binary tree to be balanced, following conditions must be met:
1. The left and right subtrees must be balanced.
2. |hL - hR| <= 1, where hL is the height or depth of left subtree and hR is the height or depth of right subtree.    
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format
The first and only line of output contains true or false.
Constraints
Time Limit: 1 second
Sample Input 1 :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
false
Sample Input 2 :
1 2 3 -1 -1 -1 -1
Sample Output 2 :
true
*/

// /*
	
// 	Following is the structure used to represent the Binary Tree Node

// 	class BinaryTreeNode<T> {
// 		T data;
// 		BinaryTreeNode<T> left;
// 		BinaryTreeNode<T> right;

// 		public BinaryTreeNode(T data) {
// 			this.data = data;
// 			this.left = null;
// 			this.right = null;
// 		}
// 	}

//  */

public class CheckBalanced {

	public static boolean checkBalanced(BinaryTreeNode<Integer> root) {

	
        Pair<Integer, Boolean> ans = helper(root);
        return ans.isBalanced;
      
	}
    public static Pair<Integer, Boolean> helper(BinaryTreeNode<Integer> root){
        if(root == null){
            Pair<Integer, Boolean> ans = new Pair<>();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }
        
        Pair<Integer, Boolean> leftAns = helper(root.left);
        Pair<Integer, Boolean> rightAns = helper(root.right);
        
        Pair<Integer, Boolean> ans = new Pair<>();
        int height = 1 + Math.max(leftAns.height,rightAns.height);
       
        if(leftAns.isBalanced&&rightAns.isBalanced){
            if(leftAns.height - rightAns.height <= 1&&leftAns.height - rightAns.height >= -1){
                
                ans.height = height;
                ans.isBalanced = true;
                return ans;
            }else{
                ans.height = height;
                ans.isBalanced = false;
                return ans;
            }
        }else{
                ans.height = height;
                ans.isBalanced = false;
                return ans;
        }
    }

}
class Pair<T,V>{
    public T height;
    public V isBalanced;
}
