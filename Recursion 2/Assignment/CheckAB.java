/*
Check AB

Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.
Input format :
String S
Output format :
'true' or 'false'
Constraints :
1 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
abb
Sample Output 1 :
true
Sample Input 2 :
abababa
Sample Output 2 :
false
Explanation for Sample Input 2
In the above example, a is not followed by either "a" or "bb", instead it's followed by "b" which results in false to be returned.
*/
public class CheckAB {

	public static boolean checkAB(String input) {
		

        if(input.charAt(0)!='a'){
            return false;
        }
        return checkAB(input,1);
	}
    
    public static boolean checkAB(String input, int n){
        if(n>=input.length()){
            return true;
        }
        if(input.charAt(n)=='a'){
            if(n+1>=input.length()){

                return true;
            }
            if(input.charAt(n+1)=='a'){

            }else if(input.charAt(n+1)=='b'&&n+2<input.length()&& input.charAt(n+2)=='b'){
                n=n+2;
            }else{
                return false;
            }
        }else if(input.charAt(n)=='b'&&n+1<input.length()&& input.charAt(n+1)=='b'){
            n++;
            if(n+1>=input.length()){
                return true;
            }
            if(input.charAt(n+1)=='a'){

            }else if(input.charAt(n+1)!='a'){
                return false;
            }
        }else{
            return false;
        }

        return checkAB(input,n+1);
        
    }
}
