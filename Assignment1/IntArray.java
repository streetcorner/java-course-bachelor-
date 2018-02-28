import java.util.Arrays;
public class IntArray{
	public static void main(String args[]){
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		int len = a.length;
		double sum = 0;
		double avr = 0;
		for(int i = 0; i <len; i++)
		{
			sum += a[i]; 
		}
		avr =  sum / len;
		Arrays.sort(a); //升序排序
		System.out.println("最大值为 " + a[len-1]);
		System.out.println("最小值为 " + a[0]);
		System.out.println("平均值为 " + avr);
		System.out.println("和为 " + sum);
		}
}