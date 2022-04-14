/*
Ways To Make Coin Change

For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.
Input Format
The first line of the input contains an integer value N, which denotes the total number of denominations.

The second line of input contains N values, separated by a single space. These values denote the value of denomination.

The third line of the input contains an integer value, that denotes the value of V.
Output Format
Print the total total number of ways i.e. W.
Constraints :
1 <= n <= 10
1 <= V <= 1000

Time Limit: 1sec
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903
*/
import java.util.Arrays;

class WaysToMakeCoinChange
{
    
    public static int countWaysToMakeChange(int weight[], int value){
     int storage[][]=new int[weight.length+1][value+1];
        for(int j=0;j<value+1;j++)
        {
            storage[0][j]=0;
        }
		
         for(int i=0;i<weight.length+1;i++)
        {
            storage[i][0]=1;
        }
        
        
        for(int i=1;i<weight.length+1;i++)
        {
            for(int j=1;j<value+1;j++)
            {
                if(weight[i-1]<=j)
                storage[i][j]=storage[i][j-weight[i-1]]+storage[i-1][j];
                else
                    storage[i][j]=storage[i-1][j];
            }
        }
        return storage[weight.length][value];
	}
}
