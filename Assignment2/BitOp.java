public class BitOp{
	public static void main(String[] args)
	{
		int a  = 0xA4;
		int b = 0xB6;
		System.out.println("a = " + Integer.toBinaryString(a)); //整型转为二进制字符串
		System.out.println("b = " + Integer.toBinaryString(b));
		System.out.println("a&b =" + Integer.toBinaryString(a&b)); //与
		System.out.println("a|b =" + Integer.toBinaryString(a|b)); //或
		System.out.println("~a = " + Integer.toBinaryString(~a)); //非
		System.out.println("a^b " + Integer.toBinaryString(a^b)); //异或
		System.out.println("a<<2 " + Integer.toBinaryString(a<<2));	 //左移两位
	}	
}