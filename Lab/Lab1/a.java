import java.util.Scanner;
class Students{
	public String studentID; //学号
	public String classID; //课程号
	public String studentName; //学生姓名
	public String studentSex; //学生性别
	public int studentAge; //学生年龄
	
	public String getStudentId(){ //获取学生号
		return studentID;}
	public String getClassId(){ //获取教室号
		return classID;}
	public String getStudentName(){ //获取学生姓名
		return studentName;}
	public String getStudentSex(){ //获取学生性别
		return studentSex;}
	public int getStudentAge(){ //获取学生年龄
		return studentAge;}
	public void setStudentAge(int age){ //设置学生年龄
		studentAge = age;}
}//class
public class a{
	public static void main(String[] args){
		Students std1 = new Students();
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入学生的学号"); //得到学号
		std1.studentID = input.nextLine();
		
		System.out.println("请输入学生的教室号"); //得到教室号
		std1.classID = input.nextLine();
		
		System.out.println("请输入学生的姓名"); //得到学生姓名
		std1.studentName = input.nextLine();
		
		System.out.println("请输入学生的性别"); //得到学生性别
		std1.studentSex = input.nextLine();
		
		std1.setStudentAge(24); //设置学生年龄为24
		
		System.out.println("学生的学号为： "+std1.getStudentId()+"\n学生的教室号位："+
			std1.getClassId()+"\n学生的姓名为： " +std1.getStudentName() +"\n学生的性别为："
			+std1.getStudentSex() + "\n学生的年龄为 "+std1.getStudentAge());			
		}
}