import java.util.Scanner;
class Point //����
{
      protected double x;
      protected double y;
      public Point(){x=0.0;y=0.0;} //ȱʡ���췽��
      public Point(double x, double y){this.x= x;this.y = y;}//���췽��
      public void setX(double x){this.x = x;} //����x����ֵ
      public void setY(double y){this.y= y;}	//����y����ֵ
      public double getX(){return x;}		//��ȡX����ֵ
      public double getY(){return y;}     //��ȡy����ֵ
}// class Point

class MyLine{
	public Point px; //��X
	public Point py; //��y
	public MyLine(Point  p1,Point p2){ //�˵�Ĺ��췽��
		this.px= p1;
		this.py = p2;}		
	public MyLine(float x1,float y1,float x2,float y2){ //�˵�����Ĺ��췽��
		this.px=new Point();
		this.py=new Point();
		
		this.px.setX(x1);
		this.px.setY(y1);
		
		this.py.setX(x2);
		this.py.setY(y2);
	}
	public boolean checkArea(){  //�ж��Ƿ��ڵ�һ����
		if (px.x>0 && px.y>0 && py.x>0 && py.y>0)
			return true;
		else return false;
	}	
	public double Length(Point px0,Point py0)//���߶γ���
	{
		double diffx = px.getX() - py.getX();
		double diffy = px.getY() - py.getY();
		double length = Math.sqrt(diffx * diffx + diffy * diffy);
		return length;
	}	
	public boolean Intersect(MyLine line){  //�ж��Ƿ�Ͳ���line�ཻ
		double k1 = (this.py.getY() - this.px.getY()) *(line.py.getY() - line.px.getY());
		double k2 = (this.py.getX() - this.px.getX()) *(line.py.getX()- line.px.getX());
		if((k1 - k2) == 0)
			return false;
		else return true;
	}
	public double Distance(Point pz) //���������x���߶�����ֱ�ߵľ���
	{
		double top = Math.abs((pz.getY() - this.px.getY())/(pz.getX() - this.px.getX())
					- (this.py.getY() - this.px.getY()/(this.py.getX() - this.px.getX() )));
		double a = (this.py.getY() - this.px.getY())/(this.py.getX() - this.px.getX());
		double b= 1.0;
		double bottom = Math.sqrt(a*a + b*b);
		double distance = top / bottom;
		return distance;
	}
	
	public Point Midpoint(MyLine line) //���߶ε��е�
	{
		Point pz = new Point();
		pz.setX((line.px.getX() + line.py.getX()) / 2);
		pz.setY((line.px.getY() + line.py.getY()) / 2);
		return pz;
	}
}//class MyLine

public class c{
	public static void main(String[] args){
		Point pointx = new Point(); //�߶��ϵĵ�һ���˵�
		pointx.setX(1.0);
		pointx.setY(1.0);
		Point pointy = new Point(2.0,2.0); //���캯�������߶��ϵĵڶ����˵�
		MyLine line1 = new MyLine(pointx, pointy);
		
		
		MyLine line2 =  new MyLine(1,0,2,1);//���캯��������һ���߶Σ�Ϊ�˺����ж��Ƿ��ཻ
		Point pointz = new Point(2.0,1.0); //������ֱ�߾���Ҫ�õ��ĵ�
		
		
		System.out.println("�ж��߶�line1�Ƿ��ڵ�һ���޵Ľ��Ϊ�� "+line1.checkArea());
		System.out.println("�߶�line1�ĳ���Ϊ�� "+
			((double)((int)(line1.Length(pointx,pointy)*1000))/1000));//������λС��
		System.out.println("�ж��߶�line1�Ƿ��line2�ཻ�Ľ��Ϊ�� "+line1.Intersect(line2));
		System.out.println("�жϵ�pointz���߶�line1�ľ���Ϊ�� "
			+((double)((int)(line1.Distance(pointz)*1000))/1000)); //������λС��
		System.out.println("�߶�line1���е�Ϊ�� ("+line1.Midpoint(line1).getX()+","
			+line1.Midpoint(line1).getY()+")");
		}
}