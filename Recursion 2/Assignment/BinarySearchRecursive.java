/*
Binary Search (Recursive)

Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
Return -1 if x is not present in the given array.
Note : If given array size is even, take first mid.
Input format :

Line 1 : Array size

Line 2 : Array elements (separated by space)

Line 3 : x (element to be searched)

Sample Input :
6
2 3 4 5 6 8 
5 
Sample Output:
3 
*/
public class BinarySearchRecursive {

	
	public static int binarySearch(int input[], int element) {
	

        return binarySearch(input,0,input.length-1, element);
	}
    
    public static int binarySearch(int input[],int sI, int eI, int element){
        if(sI>eI){
            return -1;
        }
        int mid = (sI+eI)/2;
        if(input[mid]==element){
            return mid;
        }

        if(element < input[mid]){
            return binarySearch(input,sI ,mid-1,element);
        }else{
            return binarySearch(input,mid+1 ,eI , element);
        }
       
    }
}
