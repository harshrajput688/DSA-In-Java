/*
String to Integer

Write a recursive function to convert a given string into the number it represents. That is input will be a numeric string that contains only numbers, you need to convert the string into corresponding integer and return the answer.
Input format :
Numeric string S (string, Eg. "1234")
Output format :
Corresponding integer N (int, Eg. 1234)
Constraints :
0 <= |S| <= 9
where |S| represents length of string S.
Sample Input 1 :
00001231
Sample Output 1 :
1231
Sample Input 2 :
12567
Sample Output 2 :
12567
*/
public class StringtoInteger {

	public static int convertStringToInt(String input){
		// Write your code here
        return convertStringToInt(input, input.length()-1, 0);
        
    }
    public static int convertStringToInt(String input,int idx, int num ){
        if(idx < 0){
            return 0;
        }
        num = convertStringToInt(input, idx-1, num);
        int digit = input.charAt(idx)-'0';
        return num*10+digit;
    } 
        
}
