package chep3.Test4;

class Abox implements boxInform{
	public double boxLen = 5.0;
	public double boxWid = 3.0;
	public double boxHigh = 7.0;
	
	public void PrintLen(){
		System.out.println(this.boxLen);
	}
	public void PrintWid(){
		System.out.println(this.boxWid);
	}
	public void PrintHigh(){
		System.out.println(this.boxHigh);
	}
	public void PrintWit() {
		// TODO Auto-generated method stub
	}
	public void PrintColr() {
		// TODO Auto-generated method stub
	}
}
class Bbox extends Abox implements boxInform{
	public double boxWit = 2.0;
	public String boxColr = "ºì";
	
	public void PrintWit() {
		System.out.println(this.boxWit);
	}
	public void PrintColr() {
		System.out.println(this.boxColr);
	}
}
public class boxes{
	public static void main(String []args){
		Abox box1 = new Abox();
		box1.PrintLen();
		box1.PrintWid();
		box1.PrintHigh();
		
		System.out.println("\n");
		
		Bbox box2 = new Bbox();
		box2.PrintLen();
		box2.PrintWid();
		box2.PrintHigh();
		box2.PrintWit();
		box2.PrintColr();
	}
}