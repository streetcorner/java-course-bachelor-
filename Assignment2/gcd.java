import java.util.Scanner;
public class gcd{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("�������������������Ա�������ǵ����Լ���� ");
		int m,n,result = 1,a,b;
		m = input.nextInt();
		n = input.nextInt();
		//System.out.println(m + " " +n);
		if(m <= 0 || n <=0)
		{
			System.out.println("�Ƿ����룡");
		}
		
		if(m >= n)
		{
			a = m;
			b = n;
		}
		else 
		{
			a = n;
			b = m;
		}
		
		while(true)
		{
			int mo = a % b;
			if(mo == 0) 
			{
				result = b;
				break;
			}
			else 
			{
				a = b;
				b = mo;
			}
		}
		
		System.out.println(m +" �� "+n + " �����Լ��Ϊ: " + result );
	}
}