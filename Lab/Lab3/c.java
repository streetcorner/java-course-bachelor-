import java.util.Scanner;
class Point //点类
{
      protected double x;
      protected double y;
      public Point(){x=0.0;y=0.0;} //缺省构造方法
      public Point(double x, double y){this.x= x;this.y = y;}//构造方法
      public void setX(double x){this.x = x;} //设置x坐标值
      public void setY(double y){this.y= y;}	//设置y坐标值
      public double getX(){return x;}		//获取X坐标值
      public double getY(){return y;}     //获取y坐标值
}// class Point

class MyLine{
	public Point px; //点X
	public Point py; //点y
	public MyLine(Point  p1,Point p2){ //端点的构造方法
		this.px= p1;
		this.py = p2;}		
	public MyLine(float x1,float y1,float x2,float y2){ //端点坐标的构造方法
		this.px=new Point();
		this.py=new Point();
		
		this.px.setX(x1);
		this.px.setY(y1);
		
		this.py.setX(x2);
		this.py.setY(y2);
	}
	public boolean checkArea(){  //判断是否在第一象限
		if (px.x>0 && px.y>0 && py.x>0 && py.y>0)
			return true;
		else return false;
	}	
	public double Length(Point px0,Point py0)//求线段长度
	{
		double diffx = px.getX() - py.getX();
		double diffy = px.getY() - py.getY();
		double length = Math.sqrt(diffx * diffx + diffy * diffy);
		return length;
	}	
	public boolean Intersect(MyLine line){  //判断是否和参数line相交
		double k1 = (this.py.getY() - this.px.getY()) *(line.py.getY() - line.px.getY());
		double k2 = (this.py.getX() - this.px.getX()) *(line.py.getX()- line.px.getX());
		if((k1 - k2) == 0)
			return false;
		else return true;
	}
	public double Distance(Point pz) //计算给定点x到线段所在直线的距离
	{
		double top = Math.abs((pz.getY() - this.px.getY())/(pz.getX() - this.px.getX())
					- (this.py.getY() - this.px.getY()/(this.py.getX() - this.px.getX() )));
		double a = (this.py.getY() - this.px.getY())/(this.py.getX() - this.px.getX());
		double b= 1.0;
		double bottom = Math.sqrt(a*a + b*b);
		double distance = top / bottom;
		return distance;
	}
	
	public Point Midpoint(MyLine line) //求线段的中点
	{
		Point pz = new Point();
		pz.setX((line.px.getX() + line.py.getX()) / 2);
		pz.setY((line.px.getY() + line.py.getY()) / 2);
		return pz;
	}
}//class MyLine

public class c{
	public static void main(String[] args){
		Point pointx = new Point(); //线段上的第一个端点
		pointx.setX(1.0);
		pointx.setY(1.0);
		Point pointy = new Point(2.0,2.0); //构造函数构造线段上的第二个端点
		MyLine line1 = new MyLine(pointx, pointy);
		
		
		MyLine line2 =  new MyLine(1,0,2,1);//构造函数构造另一条线段，为了后面判断是否相交
		Point pointz = new Point(2.0,1.0); //后面求到直线距离要用到的点
		
		
		System.out.println("判断线段line1是否在第一象限的结果为： "+line1.checkArea());
		System.out.println("线段line1的长度为： "+
			((double)((int)(line1.Length(pointx,pointy)*1000))/1000));//保留三位小数
		System.out.println("判断线段line1是否和line2相交的结果为： "+line1.Intersect(line2));
		System.out.println("判断点pointz到线段line1的距离为： "
			+((double)((int)(line1.Distance(pointz)*1000))/1000)); //保留三位小数
		System.out.println("线段line1的中点为： ("+line1.Midpoint(line1).getX()+","
			+line1.Midpoint(line1).getY()+")");
		}
}