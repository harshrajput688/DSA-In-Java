/*
Replace pi (recursive)

Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".
Constraints :
1 <= |S| <= 50
where |S| represents the length of string S. 
Sample Input 1 :
xpix
Sample Output :
x3.14x
Sample Input 2 :
pipi
Sample Output :
3.143.14
Sample Input 3 :
pip
Sample Output :
3.14p
Constraints:-
1<=|S|<=50
*/
public class Replacepirecursive {

     public static String replace(String input, String newInput, int idx){
        if(idx == input.length()){
            return newInput;
        }
        if(input.charAt(idx)=='p' && (idx+1)<input.length() && input.charAt(idx+1) == 'i' ){
            newInput += "3.14";
            idx=idx+1;
        }else{
            newInput += input.charAt(idx);
        }
        return replace(input,newInput, idx+1);

    }

	// Return the changed string
	public static String replace(String input){
		

        return replace(input, "", 0);
	}
    
}
