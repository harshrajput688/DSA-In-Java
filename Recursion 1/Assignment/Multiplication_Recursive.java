
public class Multiplication_Recursive {

     
	public static int multiplyTwoIntegers(int m, int n){
	
	
        if(n==0){
            return 0;
        }
        int ans = multiplyTwoIntegers(m, n-1);
        int sum = m + ans;
        return sum;
	}
}
