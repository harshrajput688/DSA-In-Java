/*
ZigZag tree

Given a binary tree, print the zig zag order. In zigzag order, level 1 is printed from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even level right to left.
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output Format:
The binary tree is printed level wise, as described in the task. Each level is printed in new line.
Constraints
Time Limit: 1 second
Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5
10 6
2 3
9
*/

import java.util.Stack;
public class ZigZagtree {

	public static void printZigZag(BinaryTreeNode<Integer> root){
        
        if(root == null) return;
        
        Stack<BinaryTreeNode<Integer>> stk1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> stk2 = new Stack<>();
        
        stk1.push(root);
        
        while(!stk1.isEmpty() || !stk2.isEmpty()){
            
            while(!stk1.isEmpty()){
            
                BinaryTreeNode<Integer> pending = stk1.pop();
                
                if(pending.left!=null){
                    stk2.push(pending.left);
                }
                
                if(pending.right!=null){
                    stk2.push(pending.right);
                }
               
                System.out.print(pending.data+" ");
            }
                
            System.out.println();
            
            while(!stk2.isEmpty()){
            
                BinaryTreeNode<Integer> pending = stk2.pop();
               
                if(pending.right!=null){
                    stk1.push(pending.right);
                }

                if(pending.left!=null){
                    stk1.push(pending.left);
                }
                
                System.out.print(pending.data + " ");
            }
                
            System.out.println();
        }
	}
}
