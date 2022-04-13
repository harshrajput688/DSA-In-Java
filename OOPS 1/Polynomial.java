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
