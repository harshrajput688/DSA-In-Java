/*
All Indices of Number

Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
Do this recursively. Indexing in the array starts from 0.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
indexes where x is present in the array (separated by space)
Constraints :
1 <= N <= 10^3
Sample Input :
5
9 8 10 8 8
8
Sample Output :
1 3 4
*/
public class AllIndicesofNumber {

    public static int[] allIndexes(int input[], int x, int startIndex) {
        if(startIndex == input.length) {
            int output[] = new int[0];
            return output;
        }
        int smallOutput[] = allIndexes(input, x, startIndex + 1);
        if(input[startIndex] == x) {
            int output[] = new int[smallOutput.length + 1];
            output[0] = startIndex;
            for(int i = 0; i < smallOutput.length; i++) {
                output[i + 1] = smallOutput[i];
            }
            return output;
        }
        else {
        	return smallOutput;
        }
	}
    public static int[] allIndexes(int input[], int x) {
    	return allIndexes(input, x, 0);
    }
	
}
