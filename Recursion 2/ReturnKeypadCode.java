/*
Return Keypad Code

Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count of elements populated in the output array.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
*/
public class ReturnKeypadCode {

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
	

        if(n == 0){
            String ans[] = {""};
            return ans;
        }
        
        String smallAns[] = keypad(n/10);
        int r = n%10;
        String str = helper(r);
        String ans [] = new String[smallAns.length*str.length()];
        int k =0;
        for(int i = 0;i<smallAns.length;i++){
            for(int j = 0;j<str.length();j++){
                ans[k] = smallAns[i]+str.charAt(j);
                k++;
            }
        }

        return ans;

	}
    
    public static String helper(int r){
        String str = " ";
        switch(r){
            case 0:
            return str;
            case 1:
            return str;
            case 2:
            str = "abc";
            return str;
            case 3:
            str = "def";
            return str;
            case 4:
            str = "ghi";
            return str;
            case 5:
            str = "jkl";
            return str;
            case 6:
            str = "mno";
            return str;
            case 7:
            str = "pqrs";
            return str;
            case 8:
            str = "tuv";
            return str;
            case 9:
            str = "wxyz";
            return str;
            default:
            return str;
        }

        // return str;

    }
	
}
