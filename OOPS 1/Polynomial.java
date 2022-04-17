/*
Polynomial class

Implement a polynomial class, that contains following functions -
1. setCoefficient -
This function sets coefficient for a particular degree value. If term with given degree is not there in the polynomial, then corresponding term (with specified degree and value) is added. If the term is already present in the polynomial, then previous coefficient value is replaced by given coefficient value.
2. add -
Adds two polynomials and returns a new polynomial which has the result.
3. subtract -
Subtracts two polynomials and returns a new polynomial which has the result.
4. multiply -
Multiplies two polynomials and returns a new polynomial which has the result.
5. print -
Prints all the terms (only terms with non zero coefficients are to be printed) in increasing order of degree.
Print pattern for a single term : "x"
And multiple terms should be printed separated by space. For more clarity, refer sample test cases.
Note : Only keep those terms which have non - zero coefficients.
Input Format:
The first line of input contains count of the number of coefficients in polynomial 1(C1)
The next line of input has C1 degrees for polynomial 1.
The next line of input has C1 coefficients for polynomial 1.  
The next line of input contains count of the number of coefficients in polynomial 2(C2)
The next line of input has C2 degrees for polynomial 2.
The next line of input has C2 coefficients for polynomial 2.  
The next line of input has the choice for the function you want to implement.
Output Format:
The output will be printed in case of print function same as that of print function format.
Sample Input 1 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 1 :
P1 + P2 = 2x2 2x3 3x4 4x6
Sample Input 2 :
P1 : 1x2 2x3 4x6 
P2 : 3x4 1x2
Sample Output 2 :
P1 - P2 = 2x3 -3x4 4x6
*/
public class Polynomial {

	
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    private int[] coeffa;
	private int degree;

	public Polynomial() {
		coeffa=new int[5];
		degree=-1;
    }
	public void setCoefficient(int degree, int coeff){
       if(degree >=coeffa.length) {
			restructure(degree);
		}
		coeffa[degree]=coeff;
		if(degree >= this.degree) {
			this.degree=degree;
		}
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){for(int i=0;i<coeffa.length;i++) {
			if(coeffa[i] !=0)
				System.out.print( coeffa[i]  +"x"+ i +" ");
		}	
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
     Polynomial x=new Polynomial();

		int i=0,j=0,k=0;
		while(i < p.coeffa.length && j < this.coeffa.length) {
			x.setCoefficient(k, p.coeffa[i] + this.coeffa[i]);
			i++;
			j++;
			k++;
		}
		while(i<p.coeffa.length) {
			x.setCoefficient(k, p.coeffa[i]);
			k++;
			i++;
		}
		while(j<this.coeffa.length) {
			x.setCoefficient(k, this.coeffa[j]);
			k++;
			j++;
		}


		return x;
		
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
	
		Polynomial x=new Polynomial();

		int i=0,j=0,k=0;
		while(i < p.coeffa.length && j < this.coeffa.length) {
			x.setCoefficient(k,  this.coeffa[i] - p.coeffa[i] );
			i++;
			j++;
			k++;
		}
		while(i<p.coeffa.length) {
			x.setCoefficient(k, -p.coeffa[i]);
			k++;
			i++;
		}
		while(j<this.coeffa.length) {
			x.setCoefficient(k, this.coeffa[j]);
			k++;
			j++;
		}


		return x;		
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		Polynomial x=new Polynomial();

		for(int i=0;i<p.coeffa.length;i++) {
			for(int j=0;j<this.coeffa.length;j++) {
				if(i + j <=x.degree)
					x.setCoefficient( i + j ,x.coeffa[i+j]+p.coeffa[i] * this.coeffa[j]);
				else
					x.setCoefficient(i + j ,p.coeffa[i] * this.coeffa[j]);
			}
		}
		return x;
	}
    private void restructure(int degree) {

		int[] temp=coeffa;
		coeffa=new int[degree + 1];
		for(int i=0;i<temp.length;i++) {
			coeffa[i]=temp[i];
		}
    }
}
