/*
Code: Number of Balanced BTs

Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
This number can be huge, so, return output modulus 10^9 + 7.
Write a simple recursive solution.
Input Format :
The first and only line of input contains an integer, that denotes the value of h. Here, h is the height of the tree.
Output Format :
The first and only line of output contains the count of balanced binary trees modulus 10^9 + 7.
Constraints :
1 <= h <= 24
Time Limit: 1 sec
Sample Input 1:
3
Sample Output 1:
15
Sample Input 2:
4
Sample Output 2:
315
*/
/*
    Time complexity: O(2^N)
    Space complexity: O(N)

    where N is the final height of the binary tree
*/

public class NumberofBalancedBTs {

	public static long balancedBTs(long n){

		

        if(n==1||n==0){

            return 1;
        }
        long opt1 =  balancedBTs(n-1);
        long opt2 =  balancedBTs(n-2);
        
        int mod = (int)Math.pow(10,9)+7;
        return (opt1*opt1+2*opt1*opt2)%mod;
	}
}
