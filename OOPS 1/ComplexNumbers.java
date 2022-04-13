public class ComplexNumbers {
	// Complete this class
	private int real;
	private int img;
	
	public ComplexNumbers(int real, int img) {
		this.real = real;
		this.img  = img;
	}
	
	public void plus(ComplexNumbers c2) {
		this.real = this.real + c2.real;
		this.img = this.img + c2.img;
	}
	
	public void multiply(ComplexNumbers c2) {
		// int real = this.real;
		// this.real = this.real*c2.real-this.img*c2.img;
		// this.img = this.real*c2.img +c2.real*this.img;
    	int firsts= this.real*c2.real;
    	int outers= this.real*c2.img;
    	int inners= this.img*c2.real;
    	int lasts=(-1)*(this.img*c2.img);
    	real=firsts+lasts;
    	img=outers+inners;
	}
	
	public void print(){
		System.out.println(real +" +"+" i"+img);
	}
}
