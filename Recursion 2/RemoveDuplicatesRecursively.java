/*
Remove Duplicates Recursively

Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz
*/
public class RemoveDuplicatesRecursively{

    public static String removeConsecutiveDuplicates(String s, char uniEl, int idx, String output) {
		if(idx == s.length()){
            return output;
        }
        if(uniEl != s.charAt(idx)){
            output += s.charAt(idx);
            uniEl = s.charAt(idx);
        }
        return removeConsecutiveDuplicates(s, uniEl, idx+1, output);

	}
	public static String removeConsecutiveDuplicates(String s) {
		

        char uniEl = ' ';
		return removeConsecutiveDuplicates(s, uniEl, 0, "");
	}

}
