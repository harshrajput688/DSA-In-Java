/*
Code : Merge Sort

 Given a singly linked list of integers, sort it using 'Merge Sort.'
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 
*/
public class MergeSort {

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
        LinkedListNode<Integer> slow = head, fast = head;
        while(fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.next==null){
                break;
            }
        }
        LinkedListNode<Integer> head1 = head, head2 = slow.next;
        slow.next = null;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return head = merge(head1,head2);
	}
    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
         if(head1 == null && head2 == null){
            return null;
        }else if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }
        LinkedListNode<Integer> head=null, tail=null;
        if(head1.data<head2.data){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }else{
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        while(head1 != null && head2 != null){
            if(head1.data<head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null){

            tail.next = head1;
        }else if(head2 != null){
            tail.next = head2;
        }
        return head;
    }
    

}
