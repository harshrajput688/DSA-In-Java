/*
Code : Print Level Wise

Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in differnet lines.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Level wise print
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50
*/
import java.util.*;
public class PrintLevelWise {

public static void printLevelWise(TreeNode<Integer> root){
       Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
                       TreeNode<Integer> frontNode = q.remove();
            if(frontNode==null){
                if(q.isEmpty()){
                    break;
                }
                System.out.println();
                q.add(null);
            }
            else{
                System.out.print(frontNode.data + " ");
                for(int i=0;i<frontNode.children.size();i++){
                    q.add(frontNode.children.get(i));
                }

            }
        }
       

	}
		
}
