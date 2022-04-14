/*
Code : BFS Traversal

Given an undirected and disconnected graph G(V, E), print its BFS traversal.
Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print the BFS Traversal, as described in the task.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2
*/
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class BFSTraversa {

    public static void BFSHelper(int edges[][] , int sv, boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while(q.size()!= 0){
            int front = q.remove();
            System.out.print(front + " ");
            for(int i = 0; i<edges.length;i++){
                if(edges[front][i] == 1&& !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
    public static void BFS(int edges[][]){
        boolean visited[] = new boolean[edges.length];
        for(int i = 0; i< edges.length;i++){
            if(!visited[i]){
                BFSHelper(edges,i,visited);
            }
        }
    }
	public static void main(String[] args){
        
      
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int edges[][] = new int[n][n];
        for(int i = 0; i<e; i++){
            int fv = s.nextInt();
            int sv = s.nextInt();
            
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        BFS(edges);
	}

}