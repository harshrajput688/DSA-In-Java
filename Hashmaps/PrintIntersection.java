/*
Print Intersection

You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. You need to print their intersection; An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, when there is a common value that exists in both the arrays/lists.
Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the first sorted array/list (ARR1).


Input format :
The first line of input contains an integer 'N' representing the size of the first array/list.

The second line contains 'N' single space separated integers representing the elements of the first the array/list.

The third line contains an integer 'M' representing the size of the second array/list.

The fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
Print the intersection elements. Each element is printed in a separate line.
Constraints :
0 <= N <= 10^6
0 <= M <= 10^6

Time Limit: 1 sec 
Sample Input 1 :
6
2 6 8 5 4 3
4
2 3 4 7 
Sample Output 1 :
2
3 
4
Sample Input 2 :
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 
2 
2
*/
import java.util.HashMap;
import java.util.Set;
public class PrintIntersection {


   public static void printIntersection(int[] a1,int[] a2){
	// using hash-map for finding the intersection
	/*
	 	-> save the frequency of array-1 
	 	-> now check whether hash-map contains the value of array-2
	 	-> if present, then print and decrement the value of values in hash map by 1
	 */
	if(a1.length == 0 || a2.length == 0)
			return;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i= 0;i<a1.length;i++)
		{
			if(map.containsKey(a1[i]))
				map.put(a1[i],map.get(a1[i])+1);
			else {
				map.put(a1[i],1);
			}
		}
		for(int i=0;i<a2.length;i++)
		{
			if(map.containsKey(a2[i]))
			{
				if(map.get(a2[i]) == 0)
					continue;
				else {
					System.out.println(a2[i]);
					map.put(a2[i], map.get(a2[i])-1);
				}
			}
		}
	}
}
