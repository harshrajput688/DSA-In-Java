public class FirstIndexofNumber {

    public static int idx = 0;
    public static int firstIndex(int input[], int idx, int x){

        if(idx == input.length){
            return -1;
        }
        if(input[idx] == x){
            return idx;
        }
        return firstIndex(input, idx + 1, x);
    }
	public static int firstIndex(int input[], int x) {
		
		return firstIndex(input, 0, x);
	}
	
}
