import java.util.Scanner;
public class gcd{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("请输入两个正整数，以便计算它们的最大公约数： ");
		int m,n,result = 1,a,b;
		m = input.nextInt();
		n = input.nextInt();
		//System.out.println(m + " " +n);
		if(m <= 0 || n <=0)
		{
			System.out.println("非法输入！");
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
		
		System.out.println(m +" 和 "+n + " 的最大公约数为: " + result );
	}
}