/*
Running Median

You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
Input Format :
The first line of input contains an integer 'N', denoting the number of integers in the stream.

The second line of input contains 'N' integers separated by a single space.
Output Format :
Print the running median for every integer added to the running list in one line (space-separated).
Input Constraints
0 <= N <= 10 ^ 5
1 <= ARR[i] <= 10 ^ 5

Time Limit: 1 sec
Sample Input 1 :
6
6 2 1 3 7 5
Sample Output 1 :
6 4 2 2 3 4
Explanation of Sample Output 1 :
S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
Sample Input 2 :
5
5 4 3 2 1
Sample Output 2 :
5 4 4 3 3
*/
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

	public static void findMedian(int arr[])  {
        
    
        if(arr.length == 0){
            return;
        }
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
        maxheap.add(arr[0]);
        System.out.print(maxheap.peek()+" ");
        for(int i = 1; i<arr.length;i++){
            if(arr[i]<maxheap.peek()){
                maxheap.add(arr[i]);
                if((maxheap.size() - minheap.size())>1){
                    minheap.add(maxheap.remove());
                }
            }else{
                minheap.add(arr[i]);
                if((minheap.size()-maxheap.size())>1){
                    maxheap.add(minheap.remove());
                }
            }
            
            if(minheap.size() == maxheap.size()){
                int median = (minheap.peek()+maxheap.peek())/2;
                System.out.print(median+" ");
            }else if(minheap.size()>maxheap.size()){
                System.out.print(minheap.peek()+" ");
            }else{
             
                System.out.print(maxheap.peek()+" ");
            }
        }
    }


}
