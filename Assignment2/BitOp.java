public class BitOp{
	public static void main(String[] args)
	{
		int a  = 0xA4;
		int b = 0xB6;
		System.out.println("a = " + Integer.toBinaryString(a)); //����תΪ�������ַ���
		System.out.println("b = " + Integer.toBinaryString(b));
		System.out.println("a&b =" + Integer.toBinaryString(a&b)); //��
		System.out.println("a|b =" + Integer.toBinaryString(a|b)); //��
		System.out.println("~a = " + Integer.toBinaryString(~a)); //��
		System.out.println("a^b " + Integer.toBinaryString(a^b)); //���
		System.out.println("a<<2 " + Integer.toBinaryString(a<<2));	 //������λ
	}	
}