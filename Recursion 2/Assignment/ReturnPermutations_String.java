/*
Return Permutations - String

Given a string S, find and return all the possible permutations of the input string.
Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
Input Format :
String S
Output Format :
All permutations (in different lines)
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
*/
public class ReturnPermutations_String {
	
	public static String[] permutationOfString(String input){
		
           if(input.length()==0){
            String[] s={""};
            return s;
        }
        String smallans[]=permutationOfString(input.substring(1));
        String ans[]=new String[(smallans.length)*(smallans[0].length()+1)];
        int l=0;
        for(int i=0;i<smallans.length;i++){
            for(int j=0;j<=smallans[i].length();j++){
                ans[l]=smallans[i].substring(0,j)+input.charAt(0)+smallans[i].substring(j);
                l++;
                
            }
            
        }
        return ans;
		
	}
	
}
