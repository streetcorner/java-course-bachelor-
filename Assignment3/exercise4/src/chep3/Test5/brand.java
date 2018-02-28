package chep3.Test5;

class laptop implements brandInform{
	public void PrintBrand(){
		System.out.println("AAA");
	}
}
class Lenovo extends laptop{
	public void PrintBrand(){
		System.out.println("Lenovo");
	}
}
class Dell extends laptop{
	public void PrintBrand(){
		System.out.println("Dell");
	}
}
class Fouunder extends laptop{
	public void PrintBrand(){
		System.out.println("Fouunder");
	}
}
public class brand {
	public static void main(String []args)
	{
		Lenovo pc1 = new Lenovo();
		Dell pc2 = new Dell();
		Fouunder pc3 = new Fouunder();
		
		pc1.PrintBrand();
		pc2.PrintBrand();
		pc3.PrintBrand();
	}
} 