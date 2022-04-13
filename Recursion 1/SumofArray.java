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
