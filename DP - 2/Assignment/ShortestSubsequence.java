/*
Shortest Subsequence

Gary has two string S and V. Now, Gary wants to know the length shortest subsequence in S, which is not a subsequence in V.
Note: The input data will be such that there will always be a solution.
Input Format :
The first line of input contains a string, that denotes the value of S. The following line contains a string, that denotes the value of V.
Output Format :
Length of shortest subsequence in S such that it is not a subsequence in V
Constraints:
1 <= |S| <= 1000 (|x| implies the length of the string x)
1 <= |V| <= 1000 
Time Limit: 1 second
Sample Input 1:
babab
babba
Sample Output 1:
3
Explanation:
"aab" is the shortest subsequence which is present in S and absent in V.
*/
import java.util.*;
public class ShortestSubsequence {

	static final int MAX = 1005;
	public static int solve(String S,String V){
		 	char R[] = S.toCharArray();
		    char T[] = V.toCharArray();
		    int m = R.length;
		    int n = T.length;
		    int ans = shortestSeq(R, T, m, n);
		    
		    return ans;
	}
	private static int shortestSeq(char[] S, char[] T, int m, int n) {
		  // int m = S.length, n = T.length;
 
        // declaring 2D array of m + 1 rows and
        // n + 1 columns dynamically
        int dp[][] = new int[m + 1][n + 1];
 
        // T string is empty
        for (int i = 0; i <= m; i++)
        {
            dp[i][0] = 1;
        }
 
        // S string is empty
        for (int i = 0; i <= n; i++)
        {
            dp[0][i] = MAX;
        }
 
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                char ch = S[i - 1];
                int k;
                for (k = j - 1; k >= 0; k--)
                {
                    if (T[k] == ch)
                    {
                        break;
                    }
                }
 
                // char not present in T
                if (k == -1)
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j] = Math.min(dp[i - 1][j],
                                    dp[i - 1][k] + 1);
                }
            }
	}
	
         int ans = dp[m][n];
        if (ans >= MAX)
        {
            ans = -1;
        }
        return ans;
    }
}
