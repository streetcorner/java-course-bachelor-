import java.util.ArrayList;
import java.util.Scanner; //加入扫描器

public class Prime{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in); //获取文本扫描器
		System.out.println("请输入一个整数");
		int n ;
		n = input.nextInt(); //使输入文本保存在n, 这里是 nextInt(),大写i
		System.out.println("1到" +n +"的所有质数为：");
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
	
