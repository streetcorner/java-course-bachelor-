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
		Arrays.sort(a); //��������
		System.out.println("���ֵΪ " + a[len-1]);
		System.out.println("��СֵΪ " + a[0]);
		System.out.println("ƽ��ֵΪ " + avr);
		System.out.println("��Ϊ " + sum);
		}
}