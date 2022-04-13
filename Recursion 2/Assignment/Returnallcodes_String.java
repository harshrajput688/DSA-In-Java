/*
Return all codes - String

Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to return the list of all possible codes that can be generated from the given string.
Note : The order of codes are not important. And input string does not contain 0s.
Input format :
A numeric string
Constraints :
1 <= Length of String S <= 10
Sample Input:
1123
Sample Output:
aabc
kbc
alc
aaw
kw
*/
public class Returnallcodes_String {

	// Return a string array that contains all possible codes
	public static  String[] getCode(String input){
	
		if (input.length() == 0) {
            
            String[] ans = { "" };
            return ans;
        }
        int fd = (input.charAt(0) - '0');
        String[] ans1 = getCode(input.substring(1));
        String[] ans2 = new String[0];

        int ddn=0 ;
        if (input.length() >= 2) {
            ddn = (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0');
            if (ddn > 10 && ddn<= 26) {
                ans2 = getCode(input.substring(2));
            }
        }
        String[] ans = new String[ans1.length + ans2.length];
        int count = 0;
        for (int i = 0; i < ans1.length; i++) {
            char f =(char)(96+fd); 
            ans[count] = f + ans1[i];
            count++;

        }
        for (int i = 0; i < ans2.length; i++) {
            char f =(char)(96+ddn);
            ans[count] = f + ans2[i];
            count++;
        }
        return ans;

    }
}
