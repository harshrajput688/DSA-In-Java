/*
Pair Star

Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
Input format :
String S
Output format :
Modified string
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a
*/
public class PairStar {

    public static String addStars(String input,String newInput, int idx){
        if(idx == input.length()-1){
            newInput += input.charAt(idx);
            return newInput;
        }
        newInput += input.charAt(idx);

        if(input.charAt(idx) == input.charAt(idx+1)){
            newInput += '*';
        }
        return addStars(input, newInput, idx+1);
    }
	// Return the updated string
	public static String addStars(String s) {
	

        return addStars(s, "", 0);
	}
}
