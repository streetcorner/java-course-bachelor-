import java.util.ArrayList;
import java.util.Scanner; //����ɨ����

public class Prime{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); //��ȡ�ı�ɨ����
		System.out.println("������һ������");
		int n ;
		n = input.nextInt(); //ʹ�����ı�������n, ������ nextInt(),��дi
		System.out.println("1��" +n +"����������Ϊ��");
		for(int i = 2; i <= n; i++)
		{
			boolean flag = true;
			for(int j = 2; j < i; j++)
			{
				if(i % j == 0)
				{
					flag = false;
					break;
				}
			}
			if(flag)
			{
				System.out.print(i +"\t");
			}
		}    

    }
}
	
