/*
First Index of Number

Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
First index means, the index of first occurrence of x in the input array.
Do this recursively. Indexing in the array starts from 0.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
first index or -1
Constraints :
1 <= N <= 10^3
Sample Input :
4
9 8 10 8
8
Sample Output :
1
*/
public class FirstIndexofNumber {

    public static int idx = 0;
    public static int firstIndex(int input[], int idx, int x){

        if(idx == input.length){
            return -1;
        }
        if(input[idx] == x){
            return idx;
        }
        return firstIndex(input, idx + 1, x);
    }
	public static int firstIndex(int input[], int x) {
		
		return firstIndex(input, 0, x);
	}
	
}
