public class LastIndexofNumber{

    public static int lastInd = -1;
    public static int lastIndex(int input[],int idx, int x){
        if(idx == input.length){
            return lastInd;
        }
        if(input[idx] == x){
            lastInd = idx;
        }
        return lastIndex(input, idx+1, x);
    }
	public static int lastIndex(int input[], int x) {

        return lastIndex(input, 0 , x);
	}
	
}
