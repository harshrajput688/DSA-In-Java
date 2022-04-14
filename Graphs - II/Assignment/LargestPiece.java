/*
Largest Piece

It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
Input Format :
The first line of input contains an integer, that denotes the value of N. 
Each of the following N lines contain N space separated integers.
Output Format :
Print the count of '1's in the biggest piece of '1's, according to the description in the task.
Constraints :
1 <= N <= 1000
Time Limit: 1 sec
Sample Input 1:
2
1 1
0 1
Sample Output 1:
3
*/
public class LargestPiece {


	public static int dfs(String[] edge, int n) 
    {
		boolean[][] visited = new boolean[n][n];
        char[][] matrix = new char[n][n];
        
        
        for(int i = 0; i < n; i++)
        {
            String word = edge[i];
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = word.charAt(j);
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int temp = helper(matrix, i, j, n, visited);
                
                if(temp > ans)
                {
                    ans = temp;
                }
            }
        }
        
        return ans;
	}
    
    
    public static int helper(char[][] mat, int i, int j, int n, boolean[][] visited)
    {
        if(i >= n || i < 0 || j >= n || j < 0)
        {
            return 0;
        }
        
        int currAns = 0;
        int ans = 0;
        
        if(mat[i][j] == '1' && !visited[i][j])
        {
            currAns = 1;
            ans += 1;
            visited[i][j] = true;

            
            ans += helper(mat, i - 1, j, n, visited);

            
            ans += helper(mat, i, j + 1, n, visited);

            ans += helper(mat, i + 1, j, n, visited);

            
            ans += helper(mat, i, j - 1, n, visited);
        }
        else
        {
            return 0;
        }
        
        return ans;
    }

}
