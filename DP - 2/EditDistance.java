/*
Code: Edit Distance

Given two strings s and t of lengths m and n respectively, find the edit distance between the strings.
Edit Distance
Edit Distance of two strings is minimum number of operations required to make one string equal to other. In order to do so you can perform any of the following three operations only :
1. Delete a character
2. Replace a character with another one
3. Insert a character
Note
Strings don't contain spaces
Input Format :
The first line of input contains a string, that denotes the value of s. The following line contains a string, that denotes the value of t.
Output Format :
The first and only line of output contains the edit distance value between the given strings.
Constraints :
1<= m,n <= 10
Time Limit: 1 second
Sample Input 1 :
abc
dc
Sample Output 1 :
2
*/
public class EditDistance {

	public static int editDistance(String s, String t) {
        
        if(s.length() == 0 && t.length() == 0)
        {
            return 0;
        }
        if(s.length() != 0 && t.length() == 0)
        {
            return s.length();
        }
        if(s.length() == 0 && t.length() != 0)
        {
            return t.length();
        }
        
        int ans;
        
        if(s.charAt(0) == t.charAt(0))
        {
            ans = editDistance(s.substring(1), t.substring(1));
        }
        else
        {
            int ans1, ans2, ans3;
            ans1 = 1 + editDistance(s.substring(1), t.substring(1));
            ans2 = 1 + editDistance(s.substring(1), t);
            ans3 = 1 + editDistance(s, t.substring(1));
            
            ans = Math.min(ans1, Math.min(ans2, ans3));
        }
        
        return ans;
    }

}
