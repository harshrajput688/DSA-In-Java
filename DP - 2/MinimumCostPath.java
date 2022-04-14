/*
Code : Minimum Cost Path

An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.
 Input format :
The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

The second line onwards, the next 'M' lines or rows represent the ith row values.

Each of the ith row constitutes 'N' column values separated by a single space.
Output format :
Print the minimum cost to reach the destination.
Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2

Time Limit: 1 sec
Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13
Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76
Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18
*/
public class MinimumCostPath {

	public static int minCostPath(int[][] input) {
		//Your code goes here
       if(input.length==0){
           return 0;
       }
        return minCostPath(input, 0 , 0);
	}
    private static int minCostPath(int input[][], int i , int j){
        int m = input.length;
        int n = input[0].length;
        if(i>=m||j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1&&j==n-1){
            return input[i][j];
        }
        int opt1 = minCostPath(input,i,j+1);
        int opt2 = minCostPath(input,i+1,j+1);
        int opt3 = minCostPath(input,i+1,j);
        
        
        return input[i][j] + Math.min(opt1,Math.min(opt2,opt3));
    }
}
