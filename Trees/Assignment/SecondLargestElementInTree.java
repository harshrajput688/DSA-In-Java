/*
Second Largest Element In Tree

Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40
*/
public class SecondLargestElementInTree {

// /*	TreeNode structure 
//  * 
//  * class TreeNode<T> {
// 		T data;
// 		ArrayList<TreeNode<T>> children;

// 		TreeNode(int n,T data){
// 			this.data = data;
// 			children = new ArrayList<TreeNode<T>>();
// 		}
// 	}*/
	
		
	static TreeNode<Integer> largest;
    static TreeNode<Integer> slargest;
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        


		largest = new TreeNode<Integer>(Integer.MIN_VALUE);
        slargest = largest;
         
        findSecondLargestHelper(root);
        return slargest;

	}
    public static void findSecondLargestHelper(TreeNode<Integer> root)
    {
       
        
        if (root == null) 
            return;
        
         
        
        if (root.data > largest.data) {
            slargest = largest;
            largest = root;
        } 
        else if (root.data > slargest.data && root.data != largest.data)
            slargest = root;
         
        
        for (int i=0;i<root.children.size();i++)
            findSecondLargestHelper(root.children.get(i));
    }
    
	
	
}
