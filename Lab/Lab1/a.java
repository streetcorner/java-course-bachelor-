import java.util.Scanner;
class Students{
	public String studentID; //ѧ��
	public String classID; //�γ̺�
	public String studentName; //ѧ������
	public String studentSex; //ѧ���Ա�
	public int studentAge; //ѧ������
	
	public String getStudentId(){ //��ȡѧ����
		return studentID;}
	public String getClassId(){ //��ȡ���Һ�
		return classID;}
	public String getStudentName(){ //��ȡѧ������
		return studentName;}
	public String getStudentSex(){ //��ȡѧ���Ա�
		return studentSex;}
	public int getStudentAge(){ //��ȡѧ������
		return studentAge;}
	public void setStudentAge(int age){ //����ѧ������
		studentAge = age;}
}//class
public class a{
	public static void main(String[] args){
		Students std1 = new Students();
		Scanner input = new Scanner(System.in);
		
		System.out.println("������ѧ����ѧ��"); //�õ�ѧ��
		std1.studentID = input.nextLine();
		
		System.out.println("������ѧ���Ľ��Һ�"); //�õ����Һ�
		std1.classID = input.nextLine();
		
		System.out.println("������ѧ��������"); //�õ�ѧ������
		std1.studentName = input.nextLine();
		
		System.out.println("������ѧ�����Ա�"); //�õ�ѧ���Ա�
		std1.studentSex = input.nextLine();
		
		std1.setStudentAge(24); //����ѧ������Ϊ24
		
		System.out.println("ѧ����ѧ��Ϊ�� "+std1.getStudentId()+"\nѧ���Ľ��Һ�λ��"+
			std1.getClassId()+"\nѧ��������Ϊ�� " +std1.getStudentName() +"\nѧ�����Ա�Ϊ��"
			+std1.getStudentSex() + "\nѧ��������Ϊ "+std1.getStudentAge());			
		}
}