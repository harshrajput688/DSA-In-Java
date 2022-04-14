/*
Coding Ninjas

Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.
Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix. 
Each of the following N lines contain M characters. Please note that characters are not space separated.
Output Format :
Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
Constraints :
1 <= N <= 1000
1 <= M <= 1000
Time Limit: 1 second
Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1
*/
public class CodingNinjas { 
     int[][] a = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}}; 
     String pattern = "CODINGNINJA";
     int[][] used; 
     int validPoint(int x,int y,int N,int M){ 
         if(x >= 0 && x < N && y >= 0 && y < M) 
             return 1;
         
         return 0; 
     } int DFS(String[] G,int x, int y, int index, int N, int M){
         if(index == 11) 
             return 1;
         used[x][y] = 1; 
         int i, newx, newy; 
         int found = 0;
         for(i = 0; i < 8; i++){ 
             newx = x + a[i][0];
             newy = y + a[i][1];
             if(validPoint(newx,newy,N,M) == 1 && G[newx].charAt(newy) == pattern.charAt(index) && used[newx][newy] == 0){ 
                 found = found | DFS(G,newx,newy,index+1,N,M); 
             } 
         }
         used[x][y] = 0;
         return found;
     }
     int solve(String[] Graph , int N, int M) {
         int i,j,found = 0;
         used = new int[N][M];
         for(i = 0;i < N; i++){ 
             for( j = 0 , found = 0; j < M; j++ ){ 
                 if(Graph[i].charAt(j)== 'C'){ 
                     found = DFS(Graph,i,j,1,N,M);
                     if(found == 1) break; 
                 }
             }
             if(found == 1) break;
         }
         return found;
     }
 }
