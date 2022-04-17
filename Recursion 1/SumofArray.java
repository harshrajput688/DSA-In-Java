/*
Sum of Array

Given an array of length N, you need to find and return the sum of all elements of the array.
Do this recursively.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Output Format :
Sum
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 9
Sample Output 1 :
26
Sample Input 2 :
3
4 2 1
Sample Output 2 :
7    
*/
public class SumofArray {

	public static int sum(int input[]) {
	 
		if(input.length == 0){
            return 0;
        }
        int smallArray [] = new int [input.length-1];
        for(int i = 1; i<input.length;i++){

            smallArray[i-1] = input[i];
        }
        int ans = sum(smallArray);
        int sumArr = ans + input[0];
        return sumArr;
	}
}
