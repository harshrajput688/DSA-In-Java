/*
Code : In-place heap sort

Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.
Constraints :
1 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2
*/
public class In_placeheapsort{

	public static void inplaceHeapSort(int arr[]) {
	
        if(arr.length<2){
            return;
        }
		int childIndex = 0;
        int parentIndex  = 0;
        int i  = 0;
        while(i<arr.length){
            childIndex = i;
            parentIndex = (childIndex-1)/2;
            while(childIndex>0){
                if(arr[childIndex]<arr[parentIndex]){
                    int temp = arr[childIndex];
                    arr[childIndex] = arr[parentIndex];
                    arr[parentIndex] = temp;
                    childIndex = parentIndex;
                    parentIndex = (childIndex-1)/2;
                }else{
                    break;
                }
            }
            i++;
        }
      
        int size = arr.length;
        
        while(size>0){
            int index = 0;
            int temp = arr[0];
            arr[0] = arr[size-1];
            arr[size-1] = temp;
            
            int leftChildIndex = 1;
            int rightChildIndex = 2;
            int  minIndex = 0;
            size--;
            
            while(leftChildIndex<size){
                if(arr[index]>arr[leftChildIndex]){
                    minIndex = leftChildIndex;
                }
                if(rightChildIndex<size&&arr[minIndex]>arr[rightChildIndex]){
                    minIndex = rightChildIndex;
                }
                if(minIndex == index){
                    break;
                }
                int temp1 = arr[index];
                arr[index] = arr[minIndex];
                arr[minIndex] = temp1;
                
                index = minIndex;
                leftChildIndex = 2*index+1;
                rightChildIndex = 2*index+2;
            }
            
        }
	}
}    
