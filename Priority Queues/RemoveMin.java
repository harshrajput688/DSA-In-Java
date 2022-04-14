
/*
Implement the function RemoveMin for the min priority queue class.
For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.
Note : main function is given for your reference which we are using internally to test the code.

*/
import java.util.ArrayList;

public class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException{
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
        if(isEmpty()){
			throw new PriorityQueueException();
		}
		int min = heap.get(0);
		heap.set(0,heap.get(size()-1));
		heap.remove(size()-1);
		
		int parentIndex = 0;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		while(heap.size()>leftChildIndex&&heap.size()>rightChildIndex) {
			if(heap.get(leftChildIndex)<heap.get(rightChildIndex)) {	
               if(heap.get(parentIndex)>heap.get(leftChildIndex)) {
            	   int temp = heap.get(parentIndex);
            	   heap.set(parentIndex, heap.get(leftChildIndex));
            	   heap.set(leftChildIndex,temp);
            	   parentIndex = leftChildIndex;
               }else {
            	   return min;
               }
			}else {
				if(heap.get(parentIndex)>heap.get(rightChildIndex)) {
	            	   int temp = heap.get(parentIndex);
	            	   heap.set(parentIndex, heap.get(rightChildIndex));
	            	   heap.set(rightChildIndex,temp);
	            	   parentIndex = rightChildIndex;
	               }else {
	            	   return min;
	               }
			}
			
			leftChildIndex = 2*parentIndex+1;
			rightChildIndex = 2*parentIndex+2;
		}
		if(heap.size()>leftChildIndex) {
			if(heap.get(parentIndex)>heap.get(leftChildIndex)) {
				 int temp = heap.get(parentIndex);
          	     heap.set(parentIndex, heap.get(leftChildIndex));
          	     heap.set(leftChildIndex,temp);
			}else {
				return min;
			}
		}else if(heap.size()>rightChildIndex) { 
			if(heap.get(parentIndex)>heap.get(rightChildIndex)){
			   int temp = heap.get(parentIndex);
        	   heap.set(parentIndex, heap.get(rightChildIndex));
        	   heap.set(rightChildIndex,temp);
			}else {
				return min;
			}
		}
		return min;
	}
}

class PriorityQueueException extends Exception {

}
