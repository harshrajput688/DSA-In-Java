/*
Replace Character Recursively

Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
Do this recursively.
Input Format :
Line 1 : Input String S
Line 2 : Character c1 and c2 (separated by space)
Output Format :
Updated string
Constraints :
1 <= Length of String S <= 10^6
Sample Input :
abacd
a x
Sample Output :
xbxcd
*/
public class ReplaceCharacterRecursively {

    public static String replaceCharacter(String input,String newInput, char c1, char c2,int idx){
        if(idx == input.length()){
            return newInput;
        }
        if(input.charAt(idx) == c1){
            newInput += c2;
        }else{
            newInput += input.charAt(idx);
        }
        return replaceCharacter(input, newInput, c1, c2, idx+1);
    }
	public static String replaceCharacter(String input, char c1, char c2) {


         return replaceCharacter(input, "", c1, c2, 0);
	}
}
