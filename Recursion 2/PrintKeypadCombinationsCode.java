/*
Print Keypad Combinations Code

Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
*/
public class PrintKeypadCombinationsCode{

	public static void printKeypad(int input){
		
		 String ans[] = {""};
        printKeypad(input,ans);
	}
    
    public static void printKeypad(int input, String ans[]){
        if(input == 0){
            for(int i = 0; i<ans.length;i++){
                System.out.println(ans[i]);
            }
            return;

        }

        int rem = input%10;
        String combination = helper(rem);
        String Ans[] = new String[combination.length()*ans.length];
        int k = 0;
        for(int i = 0; i<combination.length();i++){
            for(int j = 0; j<ans.length;j++){
                Ans[k] = combination.charAt(i)+ans[j];
                k++;
            }            
        }

        printKeypad(input/10, Ans);
        
        
    }
    
    public static String helper(int rem){
        String str = " ";
        switch(rem){
            case 0:
            return str;
            case 1:
            return str;
            case 2:
            str = "abc";
            return str;
            case 3:
            str = "def";
            return str;
            case 4:
            str = "ghi";
            return str;
            case 5:
            str = "jkl";
            return str;
            case 6:
            str = "mno";
            return str;
            case 7:
            str = "pqrs";
            return str;
            case 8:
            str = "tuv";
            return str;
            case 9:
            str = "wxyz";
            return str;
            default:
            return str;
        }

        // return str;

    }
}
