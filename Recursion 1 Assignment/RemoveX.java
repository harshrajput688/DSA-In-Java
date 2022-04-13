/*
Remove X

Given a string, compute recursively a new string where all 'x' chars have been removed.
Input format :
String S
Output format :
Modified String
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string S. 
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3:
*/
public class RemoveX {

    public static String removeX(String input, String newInput, int idx){
        if(idx == input.length()){
            return newInput;
        }
        if(input.charAt(idx)!='x'){
            newInput += input.charAt(idx);
        }
        return removeX(input, newInput, idx+1);
    }
	// Return the changed string
	public static String removeX(String input){
		// Write your code here

         return removeX(input, "", 0);
	}
}
