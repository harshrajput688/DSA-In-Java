/*
	
	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

 */

public class CheckifaBinaryTreeisBST {

	public static boolean isBST(BinaryTreeNode<Integer> root) {

	
        boolean ans=solve(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return ans;
}
    static boolean solve(BinaryTreeNode<Integer> root,int minrange,int maxrange)
    {
        if(root==null)
            return true;
        if(root.data<minrange || root.data>maxrange)
        {
            return false;
        }
        boolean leftans=solve(root.left,minrange,root.data-1);
        boolean rightans=solve(root.right,root.data,maxrange);
        return leftans && rightans;
    }
}
