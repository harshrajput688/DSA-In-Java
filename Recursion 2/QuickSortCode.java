/*
Quick Sort Code

Sort an array A using Quick Sort.
Change in the input array itself. So no need to return or print anything.


Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)
Constraints :
1 <= n <= 10^3
Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
1 5 2 7 3
Sample Output 2 :
1 2 3 5 7 
*/
public class QuickSortCode {
	
	public static void quickSort(int[] input) {
	
		quickSort(input, 0, input.length-1);
	}
    
     public static void quickSort(int input[], int sI , int eI){
        if(sI>=eI){
            return;
        }
        int pivotPos = partition(input, sI,eI);
        // System.out.println("location"+pivotPos);
        quickSort(input, sI, pivotPos-1);
        quickSort(input, pivotPos+1, eI);
    }
    public static int partition(int input[],int sI, int eI){
        int pivot = input[sI];
        int i = sI;
        int j = eI;
        // System.out.println(j);
        int count=0;
        for(int k=sI+1;k<=eI;k++){
            if(input[k]<=pivot){
                count++;
            }
        }
        int pivotpos=sI+count;
        int temp=pivot;
        input[sI]=input[pivotpos];
        input[pivotpos]=temp;
        while(i<j){
            if(input[i]<=pivot){
                i++;
            }
            else if(input[j]>pivot){
                j--;
            }
            else{
                int tempo = input[i];
                input[i] = input[j];
                input[j] = tempo;
            }
        }
        return pivotpos;

    }
}
