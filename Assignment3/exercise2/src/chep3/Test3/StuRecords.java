package chep3.Test3;

public class StuRecords{
	public String StuName = "王雨朦";
	public String StuSex = "女";
	public int StuAge = 21;
	public String StuEdu = "天津大学";
	
	public void PrintName(){
		System.out.println(this.StuName);
	}
	public void PrintSex(){
		System.out.println(this.StuSex);
	}
	public void PrintAge(){
		System.out.println(this.StuAge);
	}
	public void PrintEdu(){
		System.out.println(this.StuEdu);
	}
	public static void main(String []args){
		StuRecords std = new StuRecords();
		std.PrintName();
		std.PrintSex();
		std.PrintAge();
		std.PrintEdu();
	}
}