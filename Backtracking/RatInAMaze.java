/*
Code: Rat In A Maze

You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
Input Format
Line 1: Integer N
Next N Lines: Each line will contain ith row elements (separated by space)
Output Format :
The output line contains true if any path exists for the rat to reach its destination otherwise print false.
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true
Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
 false
*/
public class  RatInAMaze {

	public static boolean ratInAMaze(int maze[][]){

		

        int n = maze.length;	//row length
		int path[][]= new int[n][n];
		return solveMaze(maze, 0, 0, path);
	}
    public static boolean solveMaze(int maze[][],int i,int j, int path[][])
	{
		int n = maze.length;
		//checking if the cell is a valid cell or not 
		if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1)
		{
			return false;
		}
		//include cell in current path
		path[i][j]=1;

		//destination cell
		if(i==n-1 && j==n-1)
		{
			return true;
		}

		//explore in all directions
		//top
		if(solveMaze(maze, i-1, j, path))
		{
			return true;
		}
		//right
		if(solveMaze(maze, i, j+1, path))
		{
			return true;
		}
		//down
		if(solveMaze(maze, i+1, j, path))
		{
			return true;
		}
		//left
		if(solveMaze(maze, i, j-1, path))
		{
			return true;
		}
		
		return false;
		

	}
}
